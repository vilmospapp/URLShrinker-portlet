/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package hu.vilmospapp.urlshrinker.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Time;

import hu.vilmospapp.urlshrinker.model.Url;
import hu.vilmospapp.urlshrinker.service.base.UrlLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the url local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link hu.vilmospapp.urlshrinker.service.UrlLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Vilmos Papp
 * @see hu.vilmospapp.urlshrinker.service.base.UrlLocalServiceBaseImpl
 * @see hu.vilmospapp.urlshrinker.service.UrlLocalServiceUtil
 */
public class UrlLocalServiceImpl extends UrlLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link hu.vilmospapp.urlshrinker.service.UrlLocalServiceUtil} to access the url local service.
	 */
	public List<Url> getExpiredUrls(long companyId, Date expirationDate) {
		List<Url> expiredUrls = null;
		try {
			expiredUrls = urlPersistence.findByExpirationDate(
				companyId, expirationDate);
		}
		catch (SystemException e) {
		}

		return expiredUrls;
	}

	public boolean isHashUnique(long companyId, long groupId, String hash) {
		try {
			urlPersistence.findByC_G_H(companyId, groupId, hash);
			return true;
		}
		catch (SystemException se) {
		}

		return false;
	}

	private static final long _URL_CHECK_INTERVAL =
			GetterUtil.getLong(PropsUtil.get("url.check.interval")) * Time.MINUTE;
}