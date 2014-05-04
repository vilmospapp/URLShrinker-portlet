	package hu.vilmospapp.urlshrinker.form;

import com.vaadin.data.Item;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

import i18n.Messages;

import hu.vilmospapp.urlshrinker.CustomRequiredFieldValidator;

public class UrlFieldFactory extends DefaultFieldFactory {


	public UrlFieldFactory(String portalUrl) {
		_portalUrl = portalUrl;
	}

	@Override
	public Field createField(
		Item item, Object propertyId, Component uiContext) {

		Field field;

		String languageKey = (String)propertyId;

		if (propertyId.equals("password")) {
			field = new PasswordField(Messages.getString("password"));
		}
		else if (propertyId.equals("reEnterPassword")) {
			languageKey = "reenter-password";

			field = new PasswordField(Messages.getString("reenter-password"));
		}
		else if (propertyId.equals("urlExpiration")) {
			languageKey = "enable-url-expiration";

			field = new CheckBox(Messages.getString("enable-url-expiration"));
		}
		else if (propertyId.equals("privateUrl")) {
			languageKey = "private-url";

			field = new CheckBox(Messages.getString("private-url"));
		}
		else if (propertyId.equals("protectedUrl")) {
			languageKey = "protected-url";

			field = new CheckBox(Messages.getString("protected-url"));
		}
		else if (propertyId.equals("qrcode")) {
			field = new CheckBox(Messages.getString("qrcode"));
		}
		else if (propertyId.equals("customUrl")) {
			languageKey = "custom-url";

			field = new CheckBox(Messages.getString("custom-url"));
		}
		else if (propertyId.equals("statistics")) {
			field = new CheckBox(Messages.getString("statistics"));
		}
		else if (propertyId.equals("hash")) {
			field = new TextField(Messages.getString("hash"));
		}
		else if (propertyId.equals("originalUrl")) {
			languageKey = "url";

			field = new TextField(Messages.getString("url"));
		}
		else if (propertyId.equals("expirationDate")) {
			languageKey = "expires";

			field = new DateField(Messages.getString("expires"));
		}
		else if (propertyId.equals("oneTimeUrl")) {
			languageKey = "one-time-url";

			field = new CheckBox(Messages.getString("one-time-url"));
		}
		else {
			field = super.createField(item, propertyId, uiContext);
		}

		if (propertyId.equals("customUrl")){
			CheckBox customdUrl = (CheckBox)field;
			customdUrl.setImmediate(true);
		}
		else if (propertyId.equals("expirationDate")) {
			//TODO handle expiration date setup
			DateField expirationDate = (DateField)field;
			expirationDate.setCaption(Messages.getString("expires"));
			expirationDate.setEnabled(false);
			expirationDate.setImmediate(true);
		}
		else if (propertyId.equals("hash")) {
			TextField customUrlField = (TextField)field;
			customUrlField.setCaption(Messages.getString("hash", _portalUrl));
			customUrlField.setEnabled(false);
			customUrlField.setImmediate(true);
			customUrlField.addValidator(new CustomRequiredFieldValidator(
				customUrlField, "custom validator errors"));
			customUrlField.setWidth(100, Sizeable.UNITS_PERCENTAGE);
		}
		else if (propertyId.equals("customUrl")){
			CheckBox oneTimeUrl = (CheckBox)field;
			oneTimeUrl.setImmediate(true);
		}
		else if (propertyId.equals("urlExpiration")){
			CheckBox urlExpiration = (CheckBox)field;
			urlExpiration.setImmediate(true);
		}
		else if (propertyId.equals("originalUrl")) {
			TextField urlField = (TextField)field;
			urlField.setCaption(Messages.getString("url"));
			urlField.addStyleName("url-field");
			urlField.setImmediate(true);
			urlField.setRequired(true);
			urlField.setRequiredError(Messages.getString("url-required-error"));
			urlField.setWidth(100, Sizeable.UNITS_PERCENTAGE);
			urlField.addValidator(
				new UrlValidator(urlField,"url-validator-error-message"));
		}
		else if (propertyId.equals("password")) {
			PasswordField passwordField = (PasswordField)field;
			passwordField.setCaption(Messages.getString("password"));
			passwordField.setEnabled(false);
			passwordField.setImmediate(true);
		}
		else if (propertyId.equals("reEnterPassword")) {
			PasswordField reEnterPasswordField = (PasswordField)field;
			reEnterPasswordField.setCaption(
				Messages.getString("reenter-password"));
			reEnterPasswordField.setEnabled(false);
			reEnterPasswordField.setImmediate(true);
		}
		else if (propertyId.equals("privateUrl")) {
			CheckBox privateUrl = (CheckBox)field;
			privateUrl.setImmediate(true);
			privateUrl.setValue(true);
		}
		else if (propertyId.equals("protectedUrl")){
			CheckBox protectedUrl = (CheckBox)field;
			protectedUrl.setImmediate(true);
		}

		Messages.registerLocalizedField(field, languageKey);

		return field;
	}

	private static String _portalUrl;

}
