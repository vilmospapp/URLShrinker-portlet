package hu.vilmospapp.urlshrinker;

import com.vaadin.data.Validator;
import com.vaadin.ui.Field;

import i18n.Messages;

import java.text.MessageFormat;

public class CustomRequiredFieldValidator implements Validator {

	public CustomRequiredFieldValidator(Field field, String errorMessageKey) {
		Messages.registerLocalizedValidationError(field, errorMessageKey);
		_errorMessageKey = errorMessageKey;
	}

	@Override
	public void validate(Object value) throws InvalidValueException {
		if (com.liferay.portal.kernel.util.Validator.isNull(value)) {
			String requiredFieldMessage = Messages.getString("x-is-required");
			String field = Messages.getString(_errorMessageKey);

			String message = MessageFormat.format(
				requiredFieldMessage, new String[] {field});

			throw new InvalidValueException(message);
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

}
