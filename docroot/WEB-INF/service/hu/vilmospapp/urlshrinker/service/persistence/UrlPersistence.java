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

import com.liferay.portal.service.persistence.BasePersistence;

import hu.vilmospapp.urlshrinker.model.Url;

/**
 * The persistence interface for the url service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Vilmos Papp
 * @see UrlPersistenceImpl
 * @see UrlUtil
 * @generated
 */
public interface UrlPersistence extends BasePersistence<Url> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UrlUtil} to access the url persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the url in the entity cache if it is enabled.
	*
	* @param url the url
	*/
	public void cacheResult(hu.vilmospapp.urlshrinker.model.Url url);

	/**
	* Caches the urls in the entity cache if it is enabled.
	*
	* @param urls the urls
	*/
	public void cacheResult(
		java.util.List<hu.vilmospapp.urlshrinker.model.Url> urls);

	/**
	* Creates a new url with the primary key. Does not add the url to the database.
	*
	* @param urlId the primary key for the new url
	* @return the new url
	*/
	public hu.vilmospapp.urlshrinker.model.Url create(long urlId);

	/**
	* Removes the url with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param urlId the primary key of the url
	* @return the url that was removed
	* @throws hu.vilmospapp.urlshrinker.NoSuchUrlException if a url with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.vilmospapp.urlshrinker.model.Url remove(long urlId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException;

	public hu.vilmospapp.urlshrinker.model.Url updateImpl(
		hu.vilmospapp.urlshrinker.model.Url url, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the url with the primary key or throws a {@link hu.vilmospapp.urlshrinker.NoSuchUrlException} if it could not be found.
	*
	* @param urlId the primary key of the url
	* @return the url
	* @throws hu.vilmospapp.urlshrinker.NoSuchUrlException if a url with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.vilmospapp.urlshrinker.model.Url findByPrimaryKey(long urlId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException;

	/**
	* Returns the url with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param urlId the primary key of the url
	* @return the url, or <code>null</code> if a url with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.vilmospapp.urlshrinker.model.Url fetchByPrimaryKey(long urlId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the urls where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching urls
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.vilmospapp.urlshrinker.model.Url> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.vilmospapp.urlshrinker.model.Url> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.vilmospapp.urlshrinker.model.Url> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first url in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching url
	* @throws hu.vilmospapp.urlshrinker.NoSuchUrlException if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.vilmospapp.urlshrinker.model.Url findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException;

	/**
	* Returns the first url in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching url, or <code>null</code> if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.vilmospapp.urlshrinker.model.Url fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last url in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching url
	* @throws hu.vilmospapp.urlshrinker.NoSuchUrlException if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.vilmospapp.urlshrinker.model.Url findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException;

	/**
	* Returns the last url in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching url, or <code>null</code> if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.vilmospapp.urlshrinker.model.Url fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public hu.vilmospapp.urlshrinker.model.Url[] findByUuid_PrevAndNext(
		long urlId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException;

	/**
	* Returns the url where uuid = &#63; and groupId = &#63; or throws a {@link hu.vilmospapp.urlshrinker.NoSuchUrlException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching url
	* @throws hu.vilmospapp.urlshrinker.NoSuchUrlException if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.vilmospapp.urlshrinker.model.Url findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException;

	/**
	* Returns the url where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching url, or <code>null</code> if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.vilmospapp.urlshrinker.model.Url fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the url where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching url, or <code>null</code> if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.vilmospapp.urlshrinker.model.Url fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the urls where companyId = &#63; and expirationDate &le; &#63;.
	*
	* @param companyId the company ID
	* @param expirationDate the expiration date
	* @return the matching urls
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.vilmospapp.urlshrinker.model.Url> findByExpirationDate(
		long companyId, java.util.Date expirationDate)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.vilmospapp.urlshrinker.model.Url> findByExpirationDate(
		long companyId, java.util.Date expirationDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.vilmospapp.urlshrinker.model.Url> findByExpirationDate(
		long companyId, java.util.Date expirationDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public hu.vilmospapp.urlshrinker.model.Url findByExpirationDate_First(
		long companyId, java.util.Date expirationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException;

	/**
	* Returns the first url in the ordered set where companyId = &#63; and expirationDate &le; &#63;.
	*
	* @param companyId the company ID
	* @param expirationDate the expiration date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching url, or <code>null</code> if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.vilmospapp.urlshrinker.model.Url fetchByExpirationDate_First(
		long companyId, java.util.Date expirationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public hu.vilmospapp.urlshrinker.model.Url findByExpirationDate_Last(
		long companyId, java.util.Date expirationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException;

	/**
	* Returns the last url in the ordered set where companyId = &#63; and expirationDate &le; &#63;.
	*
	* @param companyId the company ID
	* @param expirationDate the expiration date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching url, or <code>null</code> if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.vilmospapp.urlshrinker.model.Url fetchByExpirationDate_Last(
		long companyId, java.util.Date expirationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public hu.vilmospapp.urlshrinker.model.Url[] findByExpirationDate_PrevAndNext(
		long urlId, long companyId, java.util.Date expirationDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException;

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
	public hu.vilmospapp.urlshrinker.model.Url findByC_G_U(long companyId,
		long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException;

	/**
	* Returns the url where companyId = &#63; and groupId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the matching url, or <code>null</code> if a matching url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.vilmospapp.urlshrinker.model.Url fetchByC_G_U(long companyId,
		long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public hu.vilmospapp.urlshrinker.model.Url fetchByC_G_U(long companyId,
		long groupId, long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the urls where companyId = &#63; and groupId = &#63; and hash = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @return the matching urls
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.vilmospapp.urlshrinker.model.Url> findByC_G_H(
		long companyId, long groupId, java.lang.String hash)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.vilmospapp.urlshrinker.model.Url> findByC_G_H(
		long companyId, long groupId, java.lang.String hash, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.vilmospapp.urlshrinker.model.Url> findByC_G_H(
		long companyId, long groupId, java.lang.String hash, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public hu.vilmospapp.urlshrinker.model.Url findByC_G_H_First(
		long companyId, long groupId, java.lang.String hash,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException;

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
	public hu.vilmospapp.urlshrinker.model.Url fetchByC_G_H_First(
		long companyId, long groupId, java.lang.String hash,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public hu.vilmospapp.urlshrinker.model.Url findByC_G_H_Last(
		long companyId, long groupId, java.lang.String hash,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException;

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
	public hu.vilmospapp.urlshrinker.model.Url fetchByC_G_H_Last(
		long companyId, long groupId, java.lang.String hash,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public hu.vilmospapp.urlshrinker.model.Url[] findByC_G_H_PrevAndNext(
		long urlId, long companyId, long groupId, java.lang.String hash,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException;

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
	public java.util.List<hu.vilmospapp.urlshrinker.model.Url> findByC_G_H_P_P_A(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl, boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.vilmospapp.urlshrinker.model.Url> findByC_G_H_P_P_A(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl, boolean archived, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.vilmospapp.urlshrinker.model.Url> findByC_G_H_P_P_A(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl, boolean archived, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public hu.vilmospapp.urlshrinker.model.Url findByC_G_H_P_P_A_First(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl, boolean archived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException;

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
	public hu.vilmospapp.urlshrinker.model.Url fetchByC_G_H_P_P_A_First(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl, boolean archived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public hu.vilmospapp.urlshrinker.model.Url findByC_G_H_P_P_A_Last(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl, boolean archived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException;

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
	public hu.vilmospapp.urlshrinker.model.Url fetchByC_G_H_P_P_A_Last(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl, boolean archived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public hu.vilmospapp.urlshrinker.model.Url[] findByC_G_H_P_P_A_PrevAndNext(
		long urlId, long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl, boolean archived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException;

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
	public java.util.List<hu.vilmospapp.urlshrinker.model.Url> findByC_G_H_P_P(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.vilmospapp.urlshrinker.model.Url> findByC_G_H_P_P(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.vilmospapp.urlshrinker.model.Url> findByC_G_H_P_P(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public hu.vilmospapp.urlshrinker.model.Url findByC_G_H_P_P_First(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException;

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
	public hu.vilmospapp.urlshrinker.model.Url fetchByC_G_H_P_P_First(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public hu.vilmospapp.urlshrinker.model.Url findByC_G_H_P_P_Last(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException;

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
	public hu.vilmospapp.urlshrinker.model.Url fetchByC_G_H_P_P_Last(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public hu.vilmospapp.urlshrinker.model.Url[] findByC_G_H_P_P_PrevAndNext(
		long urlId, long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean protectedUrl,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException;

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
	public hu.vilmospapp.urlshrinker.model.Url findByC_G_H_Private_A(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException;

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
	public hu.vilmospapp.urlshrinker.model.Url fetchByC_G_H_Private_A(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public hu.vilmospapp.urlshrinker.model.Url fetchByC_G_H_Private_A(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean archived, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the urls.
	*
	* @return the urls
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.vilmospapp.urlshrinker.model.Url> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.vilmospapp.urlshrinker.model.Url> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.vilmospapp.urlshrinker.model.Url> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the urls where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the url where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the url that was removed
	* @throws SystemException if a system exception occurred
	*/
	public hu.vilmospapp.urlshrinker.model.Url removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException;

	/**
	* Removes all the urls where companyId = &#63; and expirationDate &le; &#63; from the database.
	*
	* @param companyId the company ID
	* @param expirationDate the expiration date
	* @throws SystemException if a system exception occurred
	*/
	public void removeByExpirationDate(long companyId,
		java.util.Date expirationDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the url where companyId = &#63; and groupId = &#63; and userId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the url that was removed
	* @throws SystemException if a system exception occurred
	*/
	public hu.vilmospapp.urlshrinker.model.Url removeByC_G_U(long companyId,
		long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException;

	/**
	* Removes all the urls where companyId = &#63; and groupId = &#63; and hash = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_G_H(long companyId, long groupId,
		java.lang.String hash)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public void removeByC_G_H_P_P_A(long companyId, long groupId,
		java.lang.String hash, boolean privateUrl, boolean protectedUrl,
		boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public void removeByC_G_H_P_P(long companyId, long groupId,
		java.lang.String hash, boolean privateUrl, boolean protectedUrl)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public hu.vilmospapp.urlshrinker.model.Url removeByC_G_H_Private_A(
		long companyId, long groupId, java.lang.String hash,
		boolean privateUrl, boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.vilmospapp.urlshrinker.NoSuchUrlException;

	/**
	* Removes all the urls from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of urls where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching urls
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of urls where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching urls
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of urls where companyId = &#63; and expirationDate &le; &#63;.
	*
	* @param companyId the company ID
	* @param expirationDate the expiration date
	* @return the number of matching urls
	* @throws SystemException if a system exception occurred
	*/
	public int countByExpirationDate(long companyId,
		java.util.Date expirationDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of urls where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the number of matching urls
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G_U(long companyId, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of urls where companyId = &#63; and groupId = &#63; and hash = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param hash the hash
	* @return the number of matching urls
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_G_H(long companyId, long groupId, java.lang.String hash)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByC_G_H_P_P_A(long companyId, long groupId,
		java.lang.String hash, boolean privateUrl, boolean protectedUrl,
		boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByC_G_H_P_P(long companyId, long groupId,
		java.lang.String hash, boolean privateUrl, boolean protectedUrl)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByC_G_H_Private_A(long companyId, long groupId,
		java.lang.String hash, boolean privateUrl, boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of urls.
	*
	* @return the number of urls
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}