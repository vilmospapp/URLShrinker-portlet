package hu.vilmospapp.urlshrinker;

import com.vaadin.data.Validator;
import com.vaadin.ui.Field;

public class CustomRequiredFieldValidator implements Validator {

	public CustomRequiredFieldValidator(Field field, String errorMessage) {

	}

	@Override
	public void validate(Object value) throws InvalidValueException {
		// TODO Auto-generated method stub
		System.out.println(value);
	}

	@Override
	public boolean isValid(Object value) {
		return (((String)value).length() > 0);
	}
}
