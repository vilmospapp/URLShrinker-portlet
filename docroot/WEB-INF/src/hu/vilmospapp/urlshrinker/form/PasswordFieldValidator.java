package hu.vilmospapp.urlshrinker.form;

import com.liferay.portal.kernel.util.StringPool;
import com.vaadin.data.Validator;
import com.vaadin.ui.Field;

import i18n.Messages;


public class PasswordFieldValidator implements Validator {

	public PasswordFieldValidator(
		Field field, Field otherPasswordField, String errorMessageKey) {

		Messages.registerLocalizedValidationError(field, errorMessageKey);

		_errorMessageKey = errorMessageKey;
		_otherPasswordField = otherPasswordField;
	}

	@Override
	public void validate(Object value) throws InvalidValueException {
		String password = (String)value;

		if (com.liferay.portal.kernel.util.Validator.isNull(password)) {
			throw new InvalidValueException(
				Messages.getString("specify-password"));
		}

		String reEnteredPassword = (String)_otherPasswordField.getValue();

		if (!password.equals(reEnteredPassword)) {
			throw new InvalidValueException(
				Messages.getString(_errorMessageKey));
		}
	}

	@Override
	public boolean isValid(Object value) {
		try {
			validate(value);

			return true;
		}
		catch (InvalidValueException ive) {
			return false;
		}
	}

	private String _errorMessageKey;
	private Field _otherPasswordField;

}
