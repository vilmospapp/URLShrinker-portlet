package hu.vilmospapp.urlshrinker;

import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
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

		if (propertyId.equals("password")) {
			field = new PasswordField(Messages.getString("password"));
		}
		else if (propertyId.equals("reEnterPassword")) {
			field = new PasswordField(Messages.getString("reenter-password"));
		}
		else if (propertyId.equals("privateUrl")) {
			field = new CheckBox(Messages.getString("private-url"));
		}
		else if (propertyId.equals("protectedUrl")) {
			field = new CheckBox(Messages.getString("protected-url"));
		}
		else if (propertyId.equals("qrcode")) {
			field = new CheckBox(Messages.getString("qrcode"));
		}
		else if (propertyId.equals("customUrl")) {
			field = new CheckBox(Messages.getString("custom-url"));
		}
		else if (propertyId.equals("statistics")) {
			field = new CheckBox(Messages.getString("statistics"));
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
				"custom validator errors"));
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
				new UrlValidator(
					Messages.getString("url-validator-error-message")));
		}
		else if (propertyId.equals("password")) {
			PasswordField passwordField = (PasswordField)field;
			passwordField.setCaption("password");
			passwordField.setEnabled(false);
			passwordField.setImmediate(true);
			passwordField.addValidator(
				new CustomRequiredFieldValidator("custom validator errors"));
		}
		else if (propertyId.equals("reEnterPassword")) {
			PasswordField passwordField = (PasswordField)field;
			passwordField.setCaption("reenter-password");
			passwordField.setEnabled(false);
			passwordField.setImmediate(true);
			passwordField.addValidator(
				new CustomRequiredFieldValidator("custom validator errors"));
		}
		else if (propertyId.equals("protectedUrl")){
			CheckBox protectedUrl = (CheckBox)field;
			protectedUrl.setImmediate(true);
		}

		return field;
	}

}
