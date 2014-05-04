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

package hu.vilmospapp.urlshrinker.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import hu.vilmospapp.urlshrinker.model.Url;

import java.util.List;

/**
 * The persistence utility for the url service. This utility wraps {@link UrlPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Vilmos Papp
 * @see UrlPersistence
 * @see UrlPersistenceImpl
 * @generated
 */
public class UrlUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Url url) {
		getPersistence().clearCache(url);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Url> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Url> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Url> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Url update(Url url, boolean merge) throws SystemException {
		return getPersistence().update(url, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Url update(Url url, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(url, merge, serviceContext);
	}

	/**
	* Caches the url in the entity cache if it is enabled.
	*
	* @param url the url
	*/
	public static void cacheResult(hu.vilmospapp.urlshrinker.model.Url url) {
		getPersistence().cacheResult(url);
	}

	/**
	* Caches the urls in the entity cache if it is enabled.
	*
	* @param urls the urls
	*/
	public static void cacheResult(
		java.util.List<hu.vilmospapp.urlshrinker.model.Url> urls) {
		getPersistence().cacheResult(urls);
	}

	/**
	* Creates a new url with the primary key. Does not add the url to the database.
	*
	* @param urlId the primary key for the new url
	* @return the new url
	*/
	public static hu.vilmospapp.urlshrinker.model.Url create(long urlId) {
		return getPersistence().create(urlId);
	}

	/**
	* Removes the url with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param urlId the primary key of the url
	* @return the url that was removed
	* @throws hu.vilmospapp.urlshrinker.NoSuchUrlException if a url with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url remove(long urlId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException {
		return getPersistence().remove(urlId);
	}

	public static hu.vilmospapp.urlshrinker.model.Url updateImpl(
		hu.vilmospapp.urlshrinker.model.Url url, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(url, merge);
	}

	/**
	* Returns the url with the primary key or throws a {@link hu.vilmospapp.urlshrinker.NoSuchUrlException} if it could not be found.
	*
	* @param urlId the primary key of the url
	* @return the url
	* @throws hu.vilmospapp.urlshrinker.NoSuchUrlException if a url with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url findByPrimaryKey(
		long urlId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException {
		return getPersistence().findByPrimaryKey(urlId);
	}

	/**
	* Returns the url with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param urlId the primary key of the url
	* @return the url, or <code>null</code> if a url with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url fetchByPrimaryKey(
		long urlId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(urlId);
	}

	/**
	* Returns all the urls where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching urls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.vilmospapp.urlshrinker.model.Url> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the urls where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of urls
	* @param end the upper bound of the range of urls (not inclusive)
	* @return the range of matching urls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.vilmospapp.urlshrinker.model.Url> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the urls where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of urls
	* @param end the upper bound of the range of urls (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching urls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.vilmospapp.urlshrinker.model.Url> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first url in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching url
	* @throws hu.vilmospapp.urlshrinker.NoSuchUrlException if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first url in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching url, or <code>null</code> if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last url in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching url
	* @throws hu.vilmospapp.urlshrinker.NoSuchUrlException if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last url in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching url, or <code>null</code> if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the urls before and after the current url in the ordered set where uuid = &#63;.
	*
	* @param urlId the primary key of the current url
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next url
	* @throws hu.vilmospapp.urlshrinker.NoSuchUrlException if a url with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url[] findByUuid_PrevAndNext(
		long urlId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException {
		return getPersistence()
				   .findByUuid_PrevAndNext(urlId, uuid, orderByComparator);
	}

	/**
	* Returns the url where uuid = &#63; and groupId = &#63; or throws a {@link hu.vilmospapp.urlshrinker.NoSuchUrlException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching url
	* @throws hu.vilmospapp.urlshrinker.NoSuchUrlException if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the url where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching url, or <code>null</code> if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the url where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching url, or <code>null</code> if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Returns all the urls where companyId = &#63; and expirationDate &le; &#63;.
	*
	* @param companyId the company ID
	* @param expirationDate the expiration date
	* @return the matching urls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.vilmospapp.urlshrinker.model.Url> findByExpirationDate(
		long companyId, java.util.Date expirationDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByExpirationDate(companyId, expirationDate);
	}

	/**
	* Returns a range of all the urls where companyId = &#63; and expirationDate &le; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param expirationDate the expiration date
	* @param start the lower bound of the range of urls
	* @param end the upper bound of the range of urls (not inclusive)
	* @return the range of matching urls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.vilmospapp.urlshrinker.model.Url> findByExpirationDate(
		long companyId, java.util.Date expirationDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByExpirationDate(companyId, expirationDate, start, end);
	}

	/**
	* Returns an ordered range of all the urls where companyId = &#63; and expirationDate &le; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param expirationDate the expiration date
	* @param start the lower bound of the range of urls
	* @param end the upper bound of the range of urls (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching urls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.vilmospapp.urlshrinker.model.Url> findByExpirationDate(
		long companyId, java.util.Date expirationDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByExpirationDate(companyId, expirationDate, start, end,
			orderByComparator);
	}

	/**
	* Returns the first url in the ordered set where companyId = &#63; and expirationDate &le; &#63;.
	*
	* @param companyId the company ID
	* @param expirationDate the expiration date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching url
	* @throws hu.vilmospapp.urlshrinker.NoSuchUrlException if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url findByExpirationDate_First(
		long companyId, java.util.Date expirationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException {
		return getPersistence()
				   .findByExpirationDate_First(companyId, expirationDate,
			orderByComparator);
	}

	/**
	* Returns the first url in the ordered set where companyId = &#63; and expirationDate &le; &#63;.
	*
	* @param companyId the company ID
	* @param expirationDate the expiration date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching url, or <code>null</code> if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url fetchByExpirationDate_First(
		long companyId, java.util.Date expirationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByExpirationDate_First(companyId, expirationDate,
			orderByComparator);
	}

	/**
	* Returns the last url in the ordered set where companyId = &#63; and expirationDate &le; &#63;.
	*
	* @param companyId the company ID
	* @param expirationDate the expiration date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching url
	* @throws hu.vilmospapp.urlshrinker.NoSuchUrlException if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url findByExpirationDate_Last(
		long companyId, java.util.Date expirationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException {
		return getPersistence()
				   .findByExpirationDate_Last(companyId, expirationDate,
			orderByComparator);
	}

	/**
	* Returns the last url in the ordered set where companyId = &#63; and expirationDate &le; &#63;.
	*
	* @param companyId the company ID
	* @param expirationDate the expiration date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching url, or <code>null</code> if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url fetchByExpirationDate_Last(
		long companyId, java.util.Date expirationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByExpirationDate_Last(companyId, expirationDate,
			orderByComparator);
	}

	/**
	* Returns the urls before and after the current url in the ordered set where companyId = &#63; and expirationDate &le; &#63;.
	*
	* @param urlId the primary key of the current url
	* @param companyId the company ID
	* @param expirationDate the expiration date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next url
	* @throws hu.vilmospapp.urlshrinker.NoSuchUrlException if a url with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url[] findByExpirationDate_PrevAndNext(
		long urlId, long companyId, java.util.Date expirationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException {
		return getPersistence()
				   .findByExpirationDate_PrevAndNext(urlId, companyId,
			expirationDate, orderByComparator);
	}

	/**
	* Returns the url where companyId = &#63; and groupId = &#63; and userId = &#63; or throws a {@link hu.vilmospapp.urlshrinker.NoSuchUrlException} if it could not be found.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the matching url
	* @throws hu.vilmospapp.urlshrinker.NoSuchUrlException if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url findByC_G_U(
		long companyId, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException {
		return getPersistence().findByC_G_U(companyId, groupId, userId);
	}

	/**
	* Returns the url where companyId = &#63; and groupId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the matching url, or <code>null</code> if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url fetchByC_G_U(
		long companyId, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByC_G_U(companyId, groupId, userId);
	}

	/**
	* Returns the url where companyId = &#63; and groupId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching url, or <code>null</code> if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url fetchByC_G_U(
		long companyId, long groupId, long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_U(companyId, groupId, userId, retrieveFromCache);
	}

	/**
	* Returns all the urls where companyId = &#63; and groupId = &#63; and hash = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @return the matching urls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.vilmospapp.urlshrinker.model.Url> findByC_G_H(
		long companyId, long groupId, java.lang.String hash)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G_H(companyId, groupId, hash);
	}

	/**
	* Returns a range of all the urls where companyId = &#63; and groupId = &#63; and hash = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param start the lower bound of the range of urls
	* @param end the upper bound of the range of urls (not inclusive)
	* @return the range of matching urls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.vilmospapp.urlshrinker.model.Url> findByC_G_H(
		long companyId, long groupId, java.lang.String hash, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_G_H(companyId, groupId, hash, start, end);
	}

	/**
	* Returns an ordered range of all the urls where companyId = &#63; and groupId = &#63; and hash = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param start the lower bound of the range of urls
	* @param end the upper bound of the range of urls (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching urls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.vilmospapp.urlshrinker.model.Url> findByC_G_H(
		long companyId, long groupId, java.lang.String hash, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_H(companyId, groupId, hash, start, end,
			orderByComparator);
	}

	/**
	* Returns the first url in the ordered set where companyId = &#63; and groupId = &#63; and hash = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching url
	* @throws hu.vilmospapp.urlshrinker.NoSuchUrlException if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url findByC_G_H_First(
		long companyId, long groupId, java.lang.String hash,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException {
		return getPersistence()
				   .findByC_G_H_First(companyId, groupId, hash,
			orderByComparator);
	}

	/**
	* Returns the first url in the ordered set where companyId = &#63; and groupId = &#63; and hash = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching url, or <code>null</code> if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url fetchByC_G_H_First(
		long companyId, long groupId, java.lang.String hash,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_H_First(companyId, groupId, hash,
			orderByComparator);
	}

	/**
	* Returns the last url in the ordered set where companyId = &#63; and groupId = &#63; and hash = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching url
	* @throws hu.vilmospapp.urlshrinker.NoSuchUrlException if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url findByC_G_H_Last(
		long companyId, long groupId, java.lang.String hash,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException {
		return getPersistence()
				   .findByC_G_H_Last(companyId, groupId, hash, orderByComparator);
	}

	/**
	* Returns the last url in the ordered set where companyId = &#63; and groupId = &#63; and hash = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching url, or <code>null</code> if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url fetchByC_G_H_Last(
		long companyId, long groupId, java.lang.String hash,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_H_Last(companyId, groupId, hash,
			orderByComparator);
	}

	/**
	* Returns the urls before and after the current url in the ordered set where companyId = &#63; and groupId = &#63; and hash = &#63;.
	*
	* @param urlId the primary key of the current url
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next url
	* @throws hu.vilmospapp.urlshrinker.NoSuchUrlException if a url with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url[] findByC_G_H_PrevAndNext(
		long urlId, long companyId, long groupId, java.lang.String hash,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException {
		return getPersistence()
				   .findByC_G_H_PrevAndNext(urlId, companyId, groupId, hash,
			orderByComparator);
	}

	/**
	* Returns all the urls where companyId = &#63; and groupId = &#63; and hash = &#63; and privateUrl = &#63; and protectedUrl = &#63; and archived = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param privateUrl the private url
	* @param protectedUrl the protected url
	* @param archived the archived
	* @return the matching urls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.vilmospapp.urlshrinker.model.Url> findByC_G_H_P_P_A(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl, boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_H_P_P_A(companyId, groupId, hash, privateUrl,
			protectedUrl, archived);
	}

	/**
	* Returns a range of all the urls where companyId = &#63; and groupId = &#63; and hash = &#63; and privateUrl = &#63; and protectedUrl = &#63; and archived = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param privateUrl the private url
	* @param protectedUrl the protected url
	* @param archived the archived
	* @param start the lower bound of the range of urls
	* @param end the upper bound of the range of urls (not inclusive)
	* @return the range of matching urls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.vilmospapp.urlshrinker.model.Url> findByC_G_H_P_P_A(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl, boolean archived, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_H_P_P_A(companyId, groupId, hash, privateUrl,
			protectedUrl, archived, start, end);
	}

	/**
	* Returns an ordered range of all the urls where companyId = &#63; and groupId = &#63; and hash = &#63; and privateUrl = &#63; and protectedUrl = &#63; and archived = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param privateUrl the private url
	* @param protectedUrl the protected url
	* @param archived the archived
	* @param start the lower bound of the range of urls
	* @param end the upper bound of the range of urls (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching urls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.vilmospapp.urlshrinker.model.Url> findByC_G_H_P_P_A(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl, boolean archived, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_H_P_P_A(companyId, groupId, hash, privateUrl,
			protectedUrl, archived, start, end, orderByComparator);
	}

	/**
	* Returns the first url in the ordered set where companyId = &#63; and groupId = &#63; and hash = &#63; and privateUrl = &#63; and protectedUrl = &#63; and archived = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param privateUrl the private url
	* @param protectedUrl the protected url
	* @param archived the archived
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching url
	* @throws hu.vilmospapp.urlshrinker.NoSuchUrlException if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url findByC_G_H_P_P_A_First(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl, boolean archived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException {
		return getPersistence()
				   .findByC_G_H_P_P_A_First(companyId, groupId, hash,
			privateUrl, protectedUrl, archived, orderByComparator);
	}

	/**
	* Returns the first url in the ordered set where companyId = &#63; and groupId = &#63; and hash = &#63; and privateUrl = &#63; and protectedUrl = &#63; and archived = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param privateUrl the private url
	* @param protectedUrl the protected url
	* @param archived the archived
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching url, or <code>null</code> if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url fetchByC_G_H_P_P_A_First(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl, boolean archived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_H_P_P_A_First(companyId, groupId, hash,
			privateUrl, protectedUrl, archived, orderByComparator);
	}

	/**
	* Returns the last url in the ordered set where companyId = &#63; and groupId = &#63; and hash = &#63; and privateUrl = &#63; and protectedUrl = &#63; and archived = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param privateUrl the private url
	* @param protectedUrl the protected url
	* @param archived the archived
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching url
	* @throws hu.vilmospapp.urlshrinker.NoSuchUrlException if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url findByC_G_H_P_P_A_Last(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl, boolean archived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException {
		return getPersistence()
				   .findByC_G_H_P_P_A_Last(companyId, groupId, hash,
			privateUrl, protectedUrl, archived, orderByComparator);
	}

	/**
	* Returns the last url in the ordered set where companyId = &#63; and groupId = &#63; and hash = &#63; and privateUrl = &#63; and protectedUrl = &#63; and archived = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param privateUrl the private url
	* @param protectedUrl the protected url
	* @param archived the archived
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching url, or <code>null</code> if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url fetchByC_G_H_P_P_A_Last(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl, boolean archived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_H_P_P_A_Last(companyId, groupId, hash,
			privateUrl, protectedUrl, archived, orderByComparator);
	}

	/**
	* Returns the urls before and after the current url in the ordered set where companyId = &#63; and groupId = &#63; and hash = &#63; and privateUrl = &#63; and protectedUrl = &#63; and archived = &#63;.
	*
	* @param urlId the primary key of the current url
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param privateUrl the private url
	* @param protectedUrl the protected url
	* @param archived the archived
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next url
	* @throws hu.vilmospapp.urlshrinker.NoSuchUrlException if a url with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url[] findByC_G_H_P_P_A_PrevAndNext(
		long urlId, long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl, boolean archived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException {
		return getPersistence()
				   .findByC_G_H_P_P_A_PrevAndNext(urlId, companyId, groupId,
			hash, privateUrl, protectedUrl, archived, orderByComparator);
	}

	/**
	* Returns all the urls where companyId = &#63; and groupId = &#63; and hash = &#63; and privateUrl = &#63; and protectedUrl = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param privateUrl the private url
	* @param protectedUrl the protected url
	* @return the matching urls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.vilmospapp.urlshrinker.model.Url> findByC_G_H_P_P(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_H_P_P(companyId, groupId, hash, privateUrl,
			protectedUrl);
	}

	/**
	* Returns a range of all the urls where companyId = &#63; and groupId = &#63; and hash = &#63; and privateUrl = &#63; and protectedUrl = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param privateUrl the private url
	* @param protectedUrl the protected url
	* @param start the lower bound of the range of urls
	* @param end the upper bound of the range of urls (not inclusive)
	* @return the range of matching urls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.vilmospapp.urlshrinker.model.Url> findByC_G_H_P_P(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_H_P_P(companyId, groupId, hash, privateUrl,
			protectedUrl, start, end);
	}

	/**
	* Returns an ordered range of all the urls where companyId = &#63; and groupId = &#63; and hash = &#63; and privateUrl = &#63; and protectedUrl = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param privateUrl the private url
	* @param protectedUrl the protected url
	* @param start the lower bound of the range of urls
	* @param end the upper bound of the range of urls (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching urls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.vilmospapp.urlshrinker.model.Url> findByC_G_H_P_P(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_G_H_P_P(companyId, groupId, hash, privateUrl,
			protectedUrl, start, end, orderByComparator);
	}

	/**
	* Returns the first url in the ordered set where companyId = &#63; and groupId = &#63; and hash = &#63; and privateUrl = &#63; and protectedUrl = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param privateUrl the private url
	* @param protectedUrl the protected url
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching url
	* @throws hu.vilmospapp.urlshrinker.NoSuchUrlException if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url findByC_G_H_P_P_First(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException {
		return getPersistence()
				   .findByC_G_H_P_P_First(companyId, groupId, hash, privateUrl,
			protectedUrl, orderByComparator);
	}

	/**
	* Returns the first url in the ordered set where companyId = &#63; and groupId = &#63; and hash = &#63; and privateUrl = &#63; and protectedUrl = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param privateUrl the private url
	* @param protectedUrl the protected url
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching url, or <code>null</code> if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url fetchByC_G_H_P_P_First(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_H_P_P_First(companyId, groupId, hash,
			privateUrl, protectedUrl, orderByComparator);
	}

	/**
	* Returns the last url in the ordered set where companyId = &#63; and groupId = &#63; and hash = &#63; and privateUrl = &#63; and protectedUrl = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param privateUrl the private url
	* @param protectedUrl the protected url
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching url
	* @throws hu.vilmospapp.urlshrinker.NoSuchUrlException if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url findByC_G_H_P_P_Last(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException {
		return getPersistence()
				   .findByC_G_H_P_P_Last(companyId, groupId, hash, privateUrl,
			protectedUrl, orderByComparator);
	}

	/**
	* Returns the last url in the ordered set where companyId = &#63; and groupId = &#63; and hash = &#63; and privateUrl = &#63; and protectedUrl = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param privateUrl the private url
	* @param protectedUrl the protected url
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching url, or <code>null</code> if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url fetchByC_G_H_P_P_Last(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_H_P_P_Last(companyId, groupId, hash, privateUrl,
			protectedUrl, orderByComparator);
	}

	/**
	* Returns the urls before and after the current url in the ordered set where companyId = &#63; and groupId = &#63; and hash = &#63; and privateUrl = &#63; and protectedUrl = &#63;.
	*
	* @param urlId the primary key of the current url
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param privateUrl the private url
	* @param protectedUrl the protected url
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next url
	* @throws hu.vilmospapp.urlshrinker.NoSuchUrlException if a url with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url[] findByC_G_H_P_P_PrevAndNext(
		long urlId, long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException {
		return getPersistence()
				   .findByC_G_H_P_P_PrevAndNext(urlId, companyId, groupId,
			hash, privateUrl, protectedUrl, orderByComparator);
	}

	/**
	* Returns the url where companyId = &#63; and groupId = &#63; and hash = &#63; and privateUrl = &#63; and archived = &#63; or throws a {@link hu.vilmospapp.urlshrinker.NoSuchUrlException} if it could not be found.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param privateUrl the private url
	* @param archived the archived
	* @return the matching url
	* @throws hu.vilmospapp.urlshrinker.NoSuchUrlException if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url findByC_G_H_Private_A(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException {
		return getPersistence()
				   .findByC_G_H_Private_A(companyId, groupId, hash, privateUrl,
			archived);
	}

	/**
	* Returns the url where companyId = &#63; and groupId = &#63; and hash = &#63; and privateUrl = &#63; and archived = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param privateUrl the private url
	* @param archived the archived
	* @return the matching url, or <code>null</code> if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url fetchByC_G_H_Private_A(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_H_Private_A(companyId, groupId, hash,
			privateUrl, archived);
	}

	/**
	* Returns the url where companyId = &#63; and groupId = &#63; and hash = &#63; and privateUrl = &#63; and archived = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param privateUrl the private url
	* @param archived the archived
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching url, or <code>null</code> if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url fetchByC_G_H_Private_A(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean archived, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_G_H_Private_A(companyId, groupId, hash,
			privateUrl, archived, retrieveFromCache);
	}

	/**
	* Returns all the urls.
	*
	* @return the urls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.vilmospapp.urlshrinker.model.Url> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<hu.vilmospapp.urlshrinker.model.Url> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the urls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of urls
	* @param end the upper bound of the range of urls (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of urls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.vilmospapp.urlshrinker.model.Url> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the urls where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Removes the url where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the url that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Removes all the urls where companyId = &#63; and expirationDate &le; &#63; from the database.
	*
	* @param companyId the company ID
	* @param expirationDate the expiration date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByExpirationDate(long companyId,
		java.util.Date expirationDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByExpirationDate(companyId, expirationDate);
	}

	/**
	* Removes the url where companyId = &#63; and groupId = &#63; and userId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the url that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url removeByC_G_U(
		long companyId, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException {
		return getPersistence().removeByC_G_U(companyId, groupId, userId);
	}

	/**
	* Removes all the urls where companyId = &#63; and groupId = &#63; and hash = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_G_H(long companyId, long groupId,
		java.lang.String hash)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_G_H(companyId, groupId, hash);
	}

	/**
	* Removes all the urls where companyId = &#63; and groupId = &#63; and hash = &#63; and privateUrl = &#63; and protectedUrl = &#63; and archived = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param privateUrl the private url
	* @param protectedUrl the protected url
	* @param archived the archived
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_G_H_P_P_A(long companyId, long groupId,
		java.lang.String hash, boolean privateUrl, boolean protectedUrl,
		boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByC_G_H_P_P_A(companyId, groupId, hash, privateUrl,
			protectedUrl, archived);
	}

	/**
	* Removes all the urls where companyId = &#63; and groupId = &#63; and hash = &#63; and privateUrl = &#63; and protectedUrl = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param privateUrl the private url
	* @param protectedUrl the protected url
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_G_H_P_P(long companyId, long groupId,
		java.lang.String hash, boolean privateUrl, boolean protectedUrl)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByC_G_H_P_P(companyId, groupId, hash, privateUrl,
			protectedUrl);
	}

	/**
	* Removes the url where companyId = &#63; and groupId = &#63; and hash = &#63; and privateUrl = &#63; and archived = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param privateUrl the private url
	* @param archived the archived
	* @return the url that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static hu.vilmospapp.urlshrinker.model.Url removeByC_G_H_Private_A(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException {
		return getPersistence()
				   .removeByC_G_H_Private_A(companyId, groupId, hash,
			privateUrl, archived);
	}

	/**
	* Removes all the urls from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of urls where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching urls
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the number of urls where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching urls
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of urls where companyId = &#63; and expirationDate &le; &#63;.
	*
	* @param companyId the company ID
	* @param expirationDate the expiration date
	* @return the number of matching urls
	* @throws SystemException if a system exception occurred
	*/
	public static int countByExpirationDate(long companyId,
		java.util.Date expirationDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByExpirationDate(companyId, expirationDate);
	}

	/**
	* Returns the number of urls where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the number of matching urls
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_G_U(long companyId, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_G_U(companyId, groupId, userId);
	}

	/**
	* Returns the number of urls where companyId = &#63; and groupId = &#63; and hash = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @return the number of matching urls
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_G_H(long companyId, long groupId,
		java.lang.String hash)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_G_H(companyId, groupId, hash);
	}

	/**
	* Returns the number of urls where companyId = &#63; and groupId = &#63; and hash = &#63; and privateUrl = &#63; and protectedUrl = &#63; and archived = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param privateUrl the private url
	* @param protectedUrl the protected url
	* @param archived the archived
	* @return the number of matching urls
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_G_H_P_P_A(long companyId, long groupId,
		java.lang.String hash, boolean privateUrl, boolean protectedUrl,
		boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByC_G_H_P_P_A(companyId, groupId, hash, privateUrl,
			protectedUrl, archived);
	}

	/**
	* Returns the number of urls where companyId = &#63; and groupId = &#63; and hash = &#63; and privateUrl = &#63; and protectedUrl = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param privateUrl the private url
	* @param protectedUrl the protected url
	* @return the number of matching urls
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_G_H_P_P(long companyId, long groupId,
		java.lang.String hash, boolean privateUrl, boolean protectedUrl)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByC_G_H_P_P(companyId, groupId, hash, privateUrl,
			protectedUrl);
	}

	/**
	* Returns the number of urls where companyId = &#63; and groupId = &#63; and hash = &#63; and privateUrl = &#63; and archived = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @param privateUrl the private url
	* @param archived the archived
	* @return the number of matching urls
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_G_H_Private_A(long companyId, long groupId,
		java.lang.String hash, boolean privateUrl, boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByC_G_H_Private_A(companyId, groupId, hash,
			privateUrl, archived);
	}

	/**
	* Returns the number of urls.
	*
	* @return the number of urls
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UrlPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UrlPersistence)PortletBeanLocatorUtil.locate(hu.vilmospapp.urlshrinker.service.ClpSerializer.getServletContextName(),
					UrlPersistence.class.getName());

			ReferenceRegistry.registerReference(UrlUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(UrlPersistence persistence) {
	}

	private static UrlPersistence _persistence;
}