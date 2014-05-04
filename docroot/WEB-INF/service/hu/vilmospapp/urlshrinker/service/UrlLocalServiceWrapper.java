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

package hu.vilmospapp.urlshrinker.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link UrlLocalService}.
 * </p>
 *
 * @author    Vilmos Papp
 * @see       UrlLocalService
 * @generated
 */
public class UrlLocalServiceWrapper implements UrlLocalService,
	ServiceWrapper<UrlLocalService> {
	public UrlLocalServiceWrapper(UrlLocalService urlLocalService) {
		_urlLocalService = urlLocalService;
	}

	/**
	* Adds the url to the database. Also notifies the appropriate model listeners.
	*
	* @param url the url
	* @return the url that was added
	* @throws SystemException if a system exception occurred
	*/
	public hu.vilmospapp.urlshrinker.model.Url addUrl(
		hu.vilmospapp.urlshrinker.model.Url url)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _urlLocalService.addUrl(url);
	}

	/**
	* Creates a new url with the primary key. Does not add the url to the database.
	*
	* @param urlId the primary key for the new url
	* @return the new url
	*/
	public hu.vilmospapp.urlshrinker.model.Url createUrl(long urlId) {
		return _urlLocalService.createUrl(urlId);
	}

	/**
	* Deletes the url with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param urlId the primary key of the url
	* @return the url that was removed
	* @throws PortalException if a url with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.vilmospapp.urlshrinker.model.Url deleteUrl(long urlId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _urlLocalService.deleteUrl(urlId);
	}

	/**
	* Deletes the url from the database. Also notifies the appropriate model listeners.
	*
	* @param url the url
	* @return the url that was removed
	* @throws SystemException if a system exception occurred
	*/
	public hu.vilmospapp.urlshrinker.model.Url deleteUrl(
		hu.vilmospapp.urlshrinker.model.Url url)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _urlLocalService.deleteUrl(url);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _urlLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _urlLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _urlLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _urlLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _urlLocalService.dynamicQueryCount(dynamicQuery);
	}

	public hu.vilmospapp.urlshrinker.model.Url fetchUrl(long urlId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _urlLocalService.fetchUrl(urlId);
	}

	/**
	* Returns the url with the primary key.
	*
	* @param urlId the primary key of the url
	* @return the url
	* @throws PortalException if a url with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.vilmospapp.urlshrinker.model.Url getUrl(long urlId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _urlLocalService.getUrl(urlId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _urlLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the url with the UUID in the group.
	*
	* @param uuid the UUID of url
	* @param groupId the group id of the url
	* @return the url
	* @throws PortalException if a url with the UUID in the group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.vilmospapp.urlshrinker.model.Url getUrlByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _urlLocalService.getUrlByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the urls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of urls
	* @param end the upper bound of the range of urls (not inclusive)
	* @return the range of urls
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.vilmospapp.urlshrinker.model.Url> getUrls(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _urlLocalService.getUrls(start, end);
	}

	/**
	* Returns the number of urls.
	*
	* @return the number of urls
	* @throws SystemException if a system exception occurred
	*/
	public int getUrlsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _urlLocalService.getUrlsCount();
	}

	/**
	* Updates the url in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param url the url
	* @return the url that was updated
	* @throws SystemException if a system exception occurred
	*/
	public hu.vilmospapp.urlshrinker.model.Url updateUrl(
		hu.vilmospapp.urlshrinker.model.Url url)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _urlLocalService.updateUrl(url);
	}

	/**
	* Updates the url in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param url the url
	* @param merge whether to merge the url with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the url that was updated
	* @throws SystemException if a system exception occurred
	*/
	public hu.vilmospapp.urlshrinker.model.Url updateUrl(
		hu.vilmospapp.urlshrinker.model.Url url, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _urlLocalService.updateUrl(url, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _urlLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_urlLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _urlLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	public java.util.List<hu.vilmospapp.urlshrinker.model.Url> getExpiredUrls(
		long companyId, java.util.Date expirationDate) {
		return _urlLocalService.getExpiredUrls(companyId, expirationDate);
	}

	public boolean isHashUnique(long companyId, long groupId,
		java.lang.String hash) {
		return _urlLocalService.isHashUnique(companyId, groupId, hash);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public UrlLocalService getWrappedUrlLocalService() {
		return _urlLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedUrlLocalService(UrlLocalService urlLocalService) {
		_urlLocalService = urlLocalService;
	}

	public UrlLocalService getWrappedService() {
		return _urlLocalService;
	}

	public void setWrappedService(UrlLocalService urlLocalService) {
		_urlLocalService = urlLocalService;
	}

	private UrlLocalService _urlLocalService;
}