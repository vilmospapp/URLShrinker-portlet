package hu.vilmospapp.urlshrinker;

import com.vaadin.data.Validator;
import com.vaadin.ui.Field;

public class UrlValidator implements Validator {

	public UrlValidator(Field field, String errorMessageKey) {
		Messages.registerLocalizedValidationError(field, errorMessageKey);

		_errorMessageKey = errorMessageKey;
	}

	@Override
	public void validate(Object value) throws InvalidValueException {
		if (!com.liferay.portal.kernel.util.Validator.isUrl((String)value)) {
			throw new InvalidValueException(
				Messages.getString(_errorMessageKey));
		}
	}

	@Override
	public boolean isValid(Object value) {
		return com.liferay.portal.kernel.util.Validator.isUrl((String)value);
	}

	private String _errorMessageKey;

}
