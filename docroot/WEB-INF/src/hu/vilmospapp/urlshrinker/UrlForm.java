package hu.vilmospapp.urlshrinker;

import com.vaadin.data.util.BeanItem;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.PasswordField;

import hu.vilmospapp.urlshrinker.model.Url;

public class UrlForm extends Form {

	public UrlForm(BeanItem<Url> urlItem) {
		setCaption(Messages.getString("title")); //$NON-NLS-1$

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

	private GridLayout _mainLayout;

}
