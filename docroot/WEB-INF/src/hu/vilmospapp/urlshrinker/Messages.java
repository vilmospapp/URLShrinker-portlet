package hu.vilmospapp.urlshrinker;

import com.vaadin.data.Validator;
import com.vaadin.ui.Field;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;

public class Messages {
	private static final String BUNDLE_NAME = "hu.vilmospapp.urlshrinker.messages"; //$NON-NLS-1$

	private static ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private Messages() {
	}

	public static Set<Field> getLocalizedComponents() {
		return _captionLocalizationMap.keySet();
	}

	public static String getString(String key) {
		return getString(key, _locale);
	}

	public static String getString(String key, Locale locale) {
		try {
			setLocale(locale);

			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return key;
		}
	}

	public static void refreshFieldLocalizations() {
		Set<Field> fields = getLocalizedComponents();

		for (Field field : fields) {
			String captionKey = _captionLocalizationMap.get(field);

			if (com.liferay.portal.kernel.util.Validator.isNotNull(captionKey)) {
				field.setCaption(getString(captionKey));
			}

			String errorKey = _requiredErrorLocalizationMap.get(field);

			if (com.liferay.portal.kernel.util.Validator.isNotNull(errorKey)) {
				field.setRequiredError(getString(errorKey));
			}

			String validationErrorKey = _validationErrorLocalizationMap.get(
				field);

			if (com.liferay.portal.kernel.util.Validator.isNotNull(
				validationErrorKey)) {

				for (Validator validator : field.getValidators()) {
					if (validator instanceof UrlValidator) {
						field.setRequiredError(getString(validationErrorKey));
					}
				}
			}
		}
	}

	public static void registerLocalizedField(Field field, String captionKey) {
		registerLocalizedField(field, captionKey, null);
	}

	public static void registerLocalizedField(
		Field field, String captionKey, String errorKey) {

		_captionLocalizationMap.put(field, captionKey);

		if (com.liferay.portal.kernel.util.Validator.isNotNull(errorKey)) {
			_requiredErrorLocalizationMap.put(field, errorKey);
		}
	}

	public static void registerLocalizedValidationError(
		Field field, String errorKey) {

		_validationErrorLocalizationMap.put(field, errorKey);
	}

	public static void setLocale(Locale locale) {
		if ((_locale == null) || !locale.equals(_locale)) {
			_locale = locale;

			RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME, locale);
		}
	}

	private static Map<Field, String> _captionLocalizationMap =
		new HashMap<Field, String>();
	private static Locale _locale;
	private static Map<Field, String> _requiredErrorLocalizationMap =
		new HashMap<Field, String>();
	private static Map<Field, String> _validationErrorLocalizationMap =
			new HashMap<Field, String>();

}
