package hu.vilmospapp.urlshrinker.util;

import com.liferay.portal.kernel.util.StringBundler;

public class UrlShrinkerUtil {

	public static String convertPKToHash(long primaryKey) {
		StringBundler hash = new StringBundler();
		long number = primaryKey;

		while (number > 0) {
			int remainder = (int)(number % 62);

			hash.append(_charset.charAt(remainder));

			number = number / 62;
		}

		return hash.toString();
	}

	private static final String _charset = 
		"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
}
