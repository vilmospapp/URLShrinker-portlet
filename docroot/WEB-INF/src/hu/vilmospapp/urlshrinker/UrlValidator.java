package hu.vilmospapp.urlshrinker;

import com.vaadin.data.Validator;

public class UrlValidator implements Validator {

	public UrlValidator(String errorMessage) {
	}

	@Override
	public void validate(Object value) throws InvalidValueException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(Object value) {
		return com.liferay.portal.kernel.util.Validator.isUrl((String)value);
	}

}
