package hu.vilmospapp.urlshrinker;

import com.vaadin.data.util.BeanItem;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.TextField;

import hu.vilmospapp.urlshrinker.model.Url;

import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class UrlForm extends Form {

	public UrlForm(
		BeanItem<Url> urlItem, Locale locale) {

		setCaption(Messages.getString("title", locale)); //$NON-NLS-1$

		_mainLayout = new GridLayout(6, 6);
		_mainLayout.setMargin(true, false, false, true);
		_mainLayout.setSpacing(true);
		_mainLayout.setWidth(100, Sizeable.UNITS_PERCENTAGE);
		_mainLayout.setRowExpandRatio(0, 1.0f);

		setLayout(_mainLayout);
	}

	@Override
	protected void attachField(Object propertyId, Field field) {
		if (propertyId.equals("originalUrl")) { //$NON-NLS-1$
			_mainLayout.addComponent(field, 0, 0, 4, 0);
		}
		else if (propertyId.equals("privateUrl")) { //$NON-NLS-1$
			_mainLayout.addComponent(field, 0, 1);
		}
		else if (propertyId.equals("password")) { //$NON-NLS-1$
			_mainLayout.addComponent(field, 1, 2);
		}
		else if (propertyId.equals("reEnterPassword")) { //$NON-NLS-1$
			_mainLayout.addComponent(field, 2, 2);
		}
		else if (propertyId.equals("protectedUrl")) { //$NON-NLS-1$
			_mainLayout.addComponent(field, 0, 2);
		}
		else if (propertyId.equals("qrcode")) { //$NON-NLS-1$
			_mainLayout.addComponent(field, 0, 3);
		}
		else if (propertyId.equals("statistics")) { //$NON-NLS-1$
			_mainLayout.addComponent(field, 0, 4);
		}
		else if (propertyId.equals("customUrl")) { //$NON-NLS-1$
			_mainLayout.addComponent(field, 0, 5);
		}
		else if (propertyId.equals("hash")) { //$NON-NLS-1$
			_mainLayout.addComponent(field, 1, 5, 4, 5);
		}
	}

//	public void popUnSavedValues() {
//		Set<Object> propertyIds = _unSavedValues.keySet();
//
//		for (Object propertyId : propertyIds.toArray()) {
//			Field field = getField(propertyId);
//
//			Object value =_unSavedValues.get(propertyId);
//
//			field.setValue(value);
//		}
//
//		requestRepaint();
//	}

//	public void pushUnSavedValues() {
//		_unSavedValues.clear();
//
//		Collection<?> propertyIds = getItemPropertyIds();
//
//		for (Object itemPropertyId : propertyIds) {
//			Field field = getField(itemPropertyId);
//
//			if (field instanceof TextField) {
//				_unSavedValues.put(itemPropertyId, field.getValue());
//			}
//		}
//	}

	private GridLayout _mainLayout;
//	private Map<Object, Object> _unSavedValues = new HashMap<Object, Object>();

}
