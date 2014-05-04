package hu.vilmospapp.urlshrinker.form;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Field;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window.Notification;

import hu.vilmospapp.urlshrinker.model.Url;
import hu.vilmospapp.urlshrinker.model.impl.UrlImpl;
import hu.vilmospapp.urlshrinker.service.UrlLocalServiceUtil;
import hu.vilmospapp.urlshrinker.util.UrlShrinkerUtil;
import i18n.Messages;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class UrlFormLayout extends VerticalLayout {

	public UrlFormLayout(Locale locale, String portalUrl) {
		_url = new UrlImpl();

		_locale = locale;

		BeanItem<Url> urlItem = new BeanItem<Url>(_url);

		urlItem.addItemProperty(
			"reEnterPassword", new ObjectProperty(StringPool.BLANK));

		urlItem.addItemProperty(
			"urlExpiration", new ObjectProperty(Boolean.FALSE));

		final UrlForm urlForm = new UrlForm(urlItem, locale);

		_formLayout = (GridLayout)urlForm.getLayout();

		urlForm.setWidth(100, Sizeable.UNITS_PERCENTAGE);

		addComponent(urlForm);

		urlForm.setWriteThrough(true); // we want explicit 'apply'
		urlForm.setInvalidCommitted(false); // no invalid values in datamodel

		// FieldFactory for customizing the fields and adding validators
		urlForm.setFormFieldFactory(new UrlFieldFactory(portalUrl));
		urlForm.setItemDataSource(urlItem); // bind to POJO via BeanItem

		// Determines which properties are shown, and in which order:
		urlForm.setVisibleItemProperties(Arrays.asList(new String[] {
			"originalUrl", "privateUrl", "protectedUrl", "password",
			"reEnterPassword", "qrcode", "statistics", "archive", "customUrl",
			"hash", "urlExpiration", "expirationDate", "oneTimeUrl"}));

		final CheckBox customUrl = (CheckBox)urlForm.getField(
			"customUrl");

		final TextField textField = (TextField)urlForm.getField(
			"hash");

		customUrl.addListener(new ValueChangeListener() {
			@Override
			public void valueChange(
				com.vaadin.data.Property.ValueChangeEvent event) {

				textField.setEnabled(customUrl.booleanValue());
				textField.setRequired(customUrl.booleanValue());
			}
		});

		final CheckBox urlExpiration = (CheckBox)urlForm.getField(
			"urlExpiration");

		final DateField expirationDate = (DateField)urlForm.getField(
			"expirationDate");

		urlExpiration.addListener(new ValueChangeListener() {
			@Override
			public void valueChange(
				com.vaadin.data.Property.ValueChangeEvent event) {

				expirationDate.setEnabled(urlExpiration.booleanValue());
			}
		});

		final CheckBox protectedUrl = (CheckBox)urlForm.getField(
			"protectedUrl");

		final PasswordField passwordField = (PasswordField)urlForm.getField(
			"password");

		final PasswordField reEnterPasswordField =
			(PasswordField)urlForm.getField("reEnterPassword");

		passwordField.addValidator(
			new PasswordFieldValidator(
				passwordField, reEnterPasswordField, "passwords-differ"));

		reEnterPasswordField.addValidator(
			new PasswordFieldValidator(
				reEnterPasswordField, passwordField, "passwords-differ"));

		protectedUrl.addListener(new ValueChangeListener() {
			@Override
			public void valueChange(
				com.vaadin.data.Property.ValueChangeEvent event) {

				String requiredFieldMessage = Messages.getString(
					"x-is-required");

				String messageKey = Messages.getString("password");

				String message = MessageFormat.format(
					requiredFieldMessage, new String[] {messageKey});

				passwordField.setRequiredError(message);

				passwordField.setEnabled(protectedUrl.booleanValue());
				passwordField.setRequired(protectedUrl.booleanValue());

				messageKey = Messages.getString("reenter-password");

				message = MessageFormat.format(
					requiredFieldMessage, new String[] {messageKey});

				reEnterPasswordField.setRequiredError(message);

				reEnterPasswordField.setEnabled(protectedUrl.booleanValue());
				reEnterPasswordField.setRequired(protectedUrl.booleanValue());
			}

		});

		NativeButton shrinkButton = new NativeButton(
			Messages.getString("shrink", _locale),
			new Button.ClickListener() {
				public void buttonClick(ClickEvent event) {
					try {
						urlForm.setComponentError(null);
						urlForm.setValidationVisible(false);
						urlForm.commit();

						addUrl();

						resetForm(urlForm);

					}
					catch (Exception e) {
						e.printStackTrace();
					// Ingnored, we'll let the Form handle the errors
					}
				}
			}
		);

		Messages.registerLocalizedField(shrinkButton, "shrink");

		int width = (shrinkButton.getCaption().length() * 3) / 2;

		shrinkButton.setWidth(width, Sizeable.UNITS_EM);
		shrinkButton.addStyleName("shrink-button");

		_formLayout.addComponent(shrinkButton, 5, 0);
		urlForm.getFooter().addStyleName("right-aligned-buttons");
		urlForm.getFooter().setMargin(true);

		resetForm(urlForm);
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public void setUser(User user) {
		_user = user;
	}

	public void setLocale(Locale locale) {
		if (!_locale.equals(locale)) {
			_locale = locale;

			Messages.setLocale(locale);
			Messages.refreshFieldLocalizations();

			try {
				((UrlForm)_formLayout.getParent()).validate();
			}
			catch (InvalidValueException ive) {
			}
		}
	}

	protected void addUrl()
		throws SystemException, PortalException, KeyManagementException,
			KeyStoreException, NoSuchAlgorithmException, ClientProtocolException, IOException {

		long urlId = CounterLocalServiceUtil.increment(Url.class.getName());

		Date now = new Date();
		// Url url = UrlLocalServiceUtil.getUrl(urlText);
		Url url = UrlLocalServiceUtil.createUrl(urlId);

		url.setArchived(false);
		url.setCompanyId(_companyId);
		url.setGroupId(_groupId);
		url.setCreatedDate(now);
		url.setModifiedDate(now);
		url.setNew(true);
		url.setOriginalUrl(_url.getOriginalUrl());
		url.setPrivateUrl(_url.isPrivateUrl());

		if (_url.isProtectedUrl() && Validator.isNotNull(_url.getPassword())) {
			url.setPassword(_url.getPassword());
		}

		url.setProtectedUrl(_url.isProtectedUrl());
	
		User user = _user;

		if (user == null) {
			user = UserLocalServiceUtil.getDefaultUser(_companyId);
		}

		url.setUserId(user.getUserId());
		url.setUserUuid(user.getUserUuid());

		String hash = _url.getHash();

		if (!_url.isCustomUrl()) {
			hash = UrlShrinkerUtil.convertPKToHash(url.getUrlId());
		}

		if (!UrlLocalServiceUtil.isHashUnique(_companyId, _groupId, hash)) {
			throw new SystemException(Messages.getString("hash-not-unique"));
		}

		url.setHash(hash);
		url.setQrcode(_url.isQrcode());
		url.setStatistics(_url.isStatistics());

		//TODO verify that favIconExtractor service is enabled (have internet connection)

		String favIconURL = UrlShrinkerUtil.getFaviconURL(
			url.getOriginalUrl());

		String domain = HttpUtil.getDomain(url.getOriginalUrl());
		String fileName = favIconURL.substring(
			favIconURL.lastIndexOf(CharPool.SLASH)+1);

		String sourceFileName = domain + " - " + fileName;

		url.setFavicon(favIconURL);

		long defaultUserId = UserLocalServiceUtil.getDefaultUserId(_companyId);

		Folder favIconFolder = null;

		ServiceContext serviceContext = new ServiceContext();

		try {
			favIconFolder = DLAppLocalServiceUtil.getFolder(
				_groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
				_FAVICON_FOLDER_NAME);
		}
		catch (NoSuchFolderException nsfe) {
			System.out.println("no folder, try to create one");
			favIconFolder = DLAppLocalServiceUtil.addFolder(
				defaultUserId, _groupId,
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
				_FAVICON_FOLDER_NAME,
				Messages.getString(_FAVICON_FOLDER_DESCRIPTION),
				serviceContext);
		}

		FileEntry fileEntry = null;

		try {
			fileEntry = DLAppLocalServiceUtil.getFileEntry(
				_groupId, favIconFolder.getFolderId(), sourceFileName);
		}
		catch (NoSuchFileEntryException nsfee) {
			String mimeType = MimeTypesUtil.getContentType(sourceFileName);

			byte[] favIconBytes = getFavIconBytes(favIconURL);

			fileEntry = DLAppLocalServiceUtil.addFileEntry(
				defaultUserId, favIconFolder.getRepositoryId(),
				favIconFolder.getFolderId(), sourceFileName, mimeType,
				StringPool.BLANK, StringPool.BLANK, StringPool.BLANK,
				favIconBytes, serviceContext);
		}

		url.setFavicon(String.valueOf(fileEntry.getFileEntryId())); // TODO refactor to use the ID
		// TODO Preview render + save 
		// http://docs.oracle.com/javafx/2/webview/jfxpub-webview.htm
		// http://phantomjs.org/screen-capture.html
		UrlLocalServiceUtil.addUrl(url);

		getApplication().getMainWindow().showNotification(
			Messages.getString("url-saved", _locale),
			Notification.TYPE_HUMANIZED_MESSAGE);

	}

	protected byte[] getFavIconBytes(String url)
		throws KeyStoreException, KeyManagementException,
			NoSuchAlgorithmException, ClientProtocolException, IOException {

		CloseableHttpClient httpClient;

		boolean https = url.toLowerCase().startsWith(Http.HTTPS);

		if (https) {
			KeyStore trustStore  = KeyStore.getInstance(
				KeyStore.getDefaultType());

			SSLContext sslcontext = SSLContext.getInstance("TLS");

			X509TrustManager tm = new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				@Override
				public void checkClientTrusted(
						java.security.cert.X509Certificate[] chain, String authType)
						throws java.security.cert.CertificateException {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void checkServerTrusted(
						java.security.cert.X509Certificate[] chain, String authType)
						throws java.security.cert.CertificateException {
					// TODO Auto-generated method stub
					
				}
			};

			sslcontext.init(null, new TrustManager[]{tm}, null);

			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
				sslcontext, new String[] { "TLSv1" }, null,
				SSLConnectionSocketFactory
					.ALLOW_ALL_HOSTNAME_VERIFIER);

			httpClient = HttpClients.custom().setSSLSocketFactory(
				sslsf).build();
		}
		else {
			httpClient = HttpClients.custom().build();
		}

		byte[] iconBytes = null;

		HttpGet httpGet = new HttpGet(url);

		try {
			CloseableHttpResponse response = httpClient.execute(httpGet);

			 try {
					HttpEntity entity = response.getEntity();

					int statusCode = response.getStatusLine().getStatusCode();

					if (statusCode == HttpServletResponse.SC_OK) {
						if (entity != null) {
							InputStream is = entity.getContent();

							iconBytes = new byte[is.available()];

							try {
								is.read(iconBytes);
							}
							finally {
								StreamUtil.cleanUp(is);
							}
						}
					}

					EntityUtils.consume(entity);
			 }
			 finally {
				 response.close();
			 }
		}
		catch (SSLHandshakeException e) {
		}

		return iconBytes;
	}

	protected void resetForm(UrlForm urlForm) {
		for(Object propertyId : urlForm.getItemPropertyIds()) {
			Field field = urlForm.getField(propertyId);

			if (field.getType().equals(Boolean.class)) {
				CheckBox checkBox = (CheckBox)field;
				checkBox.setValue(propertyId.equals("privateUrl"));
			}
			else if (field.getType().equals(String.class)) {
				field.setValue(StringPool.BLANK);
			}
		}
	}

	private static final String _FAVICON_FOLDER_DESCRIPTION =
		"favicon-folder-description";
	private static final String _FAVICON_FOLDER_NAME = "Favicons";

	private GridLayout _formLayout;
	private long _companyId;
	private long _groupId;
	private Locale _locale;
	private Url _url;
	private User _user;

}
