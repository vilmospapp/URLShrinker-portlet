package hu.vilmospapp.urlshrinker.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringBundler;

import hu.vilmospapp.urlshrinker.model.Url;
import hu.vilmospapp.urlshrinker.service.UrlLocalServiceUtil;

import java.security.SecureRandom;
import java.util.Date;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class UrlShrinkerUtil {

	public static void checkExpiredUrls(long companyId) {
		Date now = new Date();

		List<Url> expiredUrls = UrlLocalServiceUtil.getExpiredUrls(
			companyId, now);

		if (expiredUrls != null) {
			for (Url url : expiredUrls) {
				try {
					UrlLocalServiceUtil.deleteUrl(url.getUrlId());
				} catch (PortalException e) {
					System.err.println("WARN:" + e.getMessage());
				} catch (SystemException e) {
					System.err.println("WARN:" + e.getMessage());
				}
			}
		}
	}

	public static String convertPKToHash(long primaryKey) {
		StringBundler hash = new StringBundler();
		long number = primaryKey;

		while (number > 0) {
			int remainder = (int)(number % 62);

			hash.append(_CHARSET.charAt(remainder));

			number = number / 62;
		}

		return hash.toString();
	}

	public static String getFaviconURL(String url) {
		String favIconURL = _DEFAULT_FAVICON; 

		try {
			setTrustAllCerts();
			Document document = Jsoup.connect(url).get();
			Element head = document.head();
			Element favIcon = head.select(
				"link[href~=.*\\.(ico|png)]").first();

			if (favIcon != null) {
				favIconURL = favIcon.attr("href");
			}

			if (favIconURL.indexOf(Http.PROTOCOL_DELIMITER) == -1) {
				StringBundler sb = new StringBundler(4);

				sb.append(HttpUtil.getProtocol(url));
				sb.append(Http.PROTOCOL_DELIMITER);
				sb.append(HttpUtil.getDomain(url));
				sb.append(favIconURL);

				favIconURL = sb.toString();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return favIconURL;
	}

	protected static void setTrustAllCerts() throws Exception {
		TrustManager[] trustAllCerts = new TrustManager[] {
			new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkClientTrusted(
					java.security.cert.X509Certificate[] certs,
					String authType ) {
				}

				public void checkServerTrusted(
					java.security.cert.X509Certificate[] certs,
					String authType ) {
				}
			}
		};

		// Install the all-trusting trust manager
		try {
			SSLContext sslContext = SSLContext.getInstance("SSL");
			sslContext.init(null, trustAllCerts, new SecureRandom());

			HttpsURLConnection.setDefaultSSLSocketFactory(
				sslContext.getSocketFactory());

			HttpsURLConnection.setDefaultHostnameVerifier( 
				new HostnameVerifier() {
					public boolean verify(
						String urlHostName, SSLSession session) {

						return true;
					}
				}
			);
		}
		catch ( Exception e ) {
			//We can not recover from this exception.
			e.printStackTrace();
		}
	}

	private static final String _CHARSET = 
		"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	private static final String _DEFAULT_FAVICON = "/favicon.ico";

}
