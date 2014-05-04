package hu.vilmospapp.urlshrinker.scheduler;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import hu.vilmospapp.urlshrinker.util.UrlShrinkerUtil;
/**
 * @author Vilmos Papp
 */
public class CheckExpiredURLMessageListener extends BaseMessageListener {

	@Override
	protected void doReceive(Message message) throws Exception {
		long companyId = message.getLong("companyId");

		UrlShrinkerUtil.checkExpiredUrls(companyId);
	}

}
