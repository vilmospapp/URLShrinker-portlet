package hu.vilmospapp.urlshrinker;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.vaadin.Application;
import com.vaadin.service.ApplicationContext.TransactionListener;
import com.vaadin.terminal.gwt.server.PortletApplicationContext2;
import com.vaadin.terminal.gwt.server.PortletApplicationContext2.PortletListener;
import com.vaadin.terminal.gwt.server.PortletRequestListener;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.Notification;
import com.vaadin.ui.themes.Reindeer;

import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

@SuppressWarnings("serial")
public class URLShrinkerApplication extends Application implements
	PortletListener, PortletRequestListener, TransactionListener {

	public static URLShrinkerApplication getCurrent() {
		return _application.get();
	}

	@Override
	public void handleRenderRequest(RenderRequest request,
			RenderResponse response, Window window) {
	}

	@Override
	public void handleActionRequest(ActionRequest request,
			ActionResponse response, Window window) {
	}

	@Override
	public void handleEventRequest(EventRequest request,
			EventResponse response, Window window) {
	}

	@Override
	public void handleResourceRequest(ResourceRequest request,
			ResourceResponse response, Window window) {
	}

	public void init() {
		setTheme(Reindeer.THEME_NAME);

		setCurrent(this);

		if (getContext() instanceof PortletApplicationContext2) {
			PortletApplicationContext2 ctx =
				(PortletApplicationContext2) getContext();
			ctx.addPortletListener(this, this);
			ctx.addTransactionListener(this);
			_urlFormLayout = new UrlFormLayout(getLocale());
		}
		else {
			// should not happen with portlet 2.0
			getMainWindow().showNotification(
				"Not inited via Portal!", Notification.TYPE_ERROR_MESSAGE);
		}

		Window window = new Window();

		setMainWindow(window);

		window.addComponent(_urlFormLayout);

	}

	public void onRequestEnd(PortletRequest request, PortletResponse response) {
	}

	public void onRequestStart(
		PortletRequest request, PortletResponse response) {

		try {
			User user = PortalUtil.getUser(request);
			setUser(user);

			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
				WebKeys.THEME_DISPLAY);

			Locale locale = themeDisplay.getLocale();

			if (_urlFormLayout == null) {
				_urlFormLayout = new UrlFormLayout(locale);
			}

			_urlFormLayout.setLocale(locale);

			_urlFormLayout.setUser(user);

			_urlFormLayout.setCompanyId(themeDisplay.getCompanyId());
			_urlFormLayout.setGroupId(themeDisplay.getScopeGroupId());
		}
		catch (PortalException e) {
			e.printStackTrace();
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
	}

	public static void removeCurrent() {
		_application.remove();
	}

	public static void setCurrent(URLShrinkerApplication application) {
		if (_application.get() == null) {
			_application.set(application);
		}
	}

	public void transactionEnd(
		Application application, Object transactionData) {

		if (application == this) {
			URLShrinkerApplication.removeCurrent();
		}
	}

	public void transactionStart(
		Application application, Object transactionData) {

		if (application == this) {
			URLShrinkerApplication.setCurrent(
				(URLShrinkerApplication)application);
		}
	}

	private static ThreadLocal<URLShrinkerApplication> _application =
			new ThreadLocal<URLShrinkerApplication>();

	private UrlFormLayout _urlFormLayout;

}