package hu.vilmospapp.urlshrinker;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import hu.vilmospapp.urlshrinker.model.Url;
import hu.vilmospapp.urlshrinker.model.impl.UrlImpl;
import hu.vilmospapp.urlshrinker.service.UrlLocalServiceUtil;
import hu.vilmospapp.urlshrinker.util.UrlShrinkerUtil;

import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class UrlFormLayout extends VerticalLayout {

	public UrlFormLayout(Locale locale) {
		_url = new UrlImpl();

		_locale = locale;

		BeanItem<Url> urlItem = new BeanItem<Url>(_url);

		final UrlForm urlForm = new UrlForm(urlItem, locale);

		_formLayout = (GridLayout)urlForm.getLayout();

		urlForm.setWidth(100, Sizeable.UNITS_PERCENTAGE);
		addComponent(urlForm);

		urlForm.setWriteThrough(true); // we want explicit 'apply'
		urlForm.setInvalidCommitted(false); // no invalid values in datamodel

		// FieldFactory for customizing the fields and adding validators
		urlForm.setFormFieldFactory(new UrlFieldFactory());
		urlForm.setItemDataSource(urlItem); // bind to POJO via BeanItem

		// Determines which properties are shown, and in which order:
		urlForm.setVisibleItemProperties(Arrays.asList(new String[] {
			"originalUrl", "privateUrl", "protectedUrl", "password",
			"reEnterPassword", "qrcode", "statistics", "archive", "customUrl",
			"hash"}));

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

		final CheckBox protectedUrl = (CheckBox)urlForm.getField(
			"protectedUrl");

		final PasswordField passwordField = (PasswordField)urlForm.getField(
			"password");

		ObjectProperty<String> property = new ObjectProperty<String>(
			"reEnterPassword");

		final PasswordField reEnterPasswordField = new PasswordField(
			"reenter-password");

		Messages.registerLocalizedField(
			reEnterPasswordField, "reenter-password");

		reEnterPasswordField.setPropertyDataSource(property);
		reEnterPasswordField.setEnabled(false);

		_formLayout.addComponent(reEnterPasswordField, 2, 2);

		protectedUrl.addListener(new ValueChangeListener() {
			@Override
			public void valueChange(
				com.vaadin.data.Property.ValueChangeEvent event) {

				passwordField.setEnabled(protectedUrl.booleanValue());
				passwordField.setRequired(protectedUrl.booleanValue());

				reEnterPasswordField.setEnabled(protectedUrl.booleanValue());
				reEnterPasswordField.setRequired(protectedUrl.booleanValue());
			}
		});

		NativeButton shrinkButton = new NativeButton(
			Messages.getString("shrink", _locale),
			new Button.ClickListener() {
				public void buttonClick(ClickEvent event) {
					try {
						urlForm.commit();

						if (urlForm.isValid()) {
							addUrl();
						}
					} 
					catch (Exception e) {
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
		throws SystemException, PortalException {

		long urlId = CounterLocalServiceUtil.increment(Url.class.getName());
System.out.println("add url....");
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
		url.setHash(hash);

		url.setQrcode(_url.isQrcode());
		url.setStatistics(_url.isStatistics());

		UrlLocalServiceUtil.addUrl(url);

	}

	private GridLayout _formLayout;
	private long _companyId;
	private long _groupId;
	private Locale _locale;
	private Url _url;
	private User _user;

}
