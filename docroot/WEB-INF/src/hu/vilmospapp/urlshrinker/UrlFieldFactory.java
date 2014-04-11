	package hu.vilmospapp.urlshrinker;

import com.vaadin.data.Item;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

public class UrlFieldFactory extends DefaultFieldFactory {

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
		else {
			field = super.createField(item, propertyId, uiContext);
		}

		if (propertyId.equals("customUrl")){
			CheckBox customdUrl = (CheckBox)field;
			customdUrl.setImmediate(true);
		}
		else if (propertyId.equals("hash")) {
			TextField customUrlField = (TextField)field;
			customUrlField.setCaption(Messages.getString("hash"));
			customUrlField.setEnabled(false);
			customUrlField.setImmediate(true);
			customUrlField.addValidator(new CustomRequiredFieldValidator(
				customUrlField, "custom validator errors"));
			customUrlField.setWidth(100, Sizeable.UNITS_PERCENTAGE);
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
			passwordField.addValidator(
				new CustomRequiredFieldValidator(
					passwordField, "custom validator errors"));
		}
		else if (propertyId.equals("reEnterPassword")) {
			PasswordField reEnterPasswordField = (PasswordField)field;
			reEnterPasswordField.setCaption(Messages.getString("reenter-password"));
			reEnterPasswordField.setEnabled(false);
			reEnterPasswordField.setImmediate(true);
			reEnterPasswordField.addValidator(
				new CustomRequiredFieldValidator(
					reEnterPasswordField, "custom validator errors"));
		}
		else if (propertyId.equals("protectedUrl")){
			CheckBox protectedUrl = (CheckBox)field;
			protectedUrl.setImmediate(true);
		}

		Messages.registerLocalizedField(field, languageKey);

		return field;
	}

}
