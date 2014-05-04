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

package hu.vilmospapp.urlshrinker.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Url}.
 * </p>
 *
 * @author    Vilmos Papp
 * @see       Url
 * @generated
 */
public class UrlWrapper implements Url, ModelWrapper<Url> {
	public UrlWrapper(Url url) {
		_url = url;
	}

	public Class<?> getModelClass() {
		return Url.class;
	}

	public String getModelClassName() {
		return Url.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("urlId", getUrlId());
		attributes.put("userId", getUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("hash", getHash());
		attributes.put("originalUrl", getOriginalUrl());
		attributes.put("privateUrl", getPrivateUrl());
		attributes.put("protectedUrl", getProtectedUrl());
		attributes.put("password", getPassword());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("archived", getArchived());
		attributes.put("customUrl", getCustomUrl());
		attributes.put("qrcode", getQrcode());
		attributes.put("statistics", getStatistics());
		attributes.put("favicon", getFavicon());
		attributes.put("preview", getPreview());
		attributes.put("status", getStatus());
		attributes.put("expirationDate", getExpirationDate());
		attributes.put("oneTimeUrl", getOneTimeUrl());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long urlId = (Long)attributes.get("urlId");

		if (urlId != null) {
			setUrlId(urlId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String hash = (String)attributes.get("hash");

		if (hash != null) {
			setHash(hash);
		}

		String originalUrl = (String)attributes.get("originalUrl");

		if (originalUrl != null) {
			setOriginalUrl(originalUrl);
		}

		Boolean privateUrl = (Boolean)attributes.get("privateUrl");

		if (privateUrl != null) {
			setPrivateUrl(privateUrl);
		}

		Boolean protectedUrl = (Boolean)attributes.get("protectedUrl");

		if (protectedUrl != null) {
			setProtectedUrl(protectedUrl);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Boolean archived = (Boolean)attributes.get("archived");

		if (archived != null) {
			setArchived(archived);
		}

		Boolean customUrl = (Boolean)attributes.get("customUrl");

		if (customUrl != null) {
			setCustomUrl(customUrl);
		}

		Boolean qrcode = (Boolean)attributes.get("qrcode");

		if (qrcode != null) {
			setQrcode(qrcode);
		}

		Boolean statistics = (Boolean)attributes.get("statistics");

		if (statistics != null) {
			setStatistics(statistics);
		}

		String favicon = (String)attributes.get("favicon");

		if (favicon != null) {
			setFavicon(favicon);
		}

		String preview = (String)attributes.get("preview");

		if (preview != null) {
			setPreview(preview);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date expirationDate = (Date)attributes.get("expirationDate");

		if (expirationDate != null) {
			setExpirationDate(expirationDate);
		}

		Boolean oneTimeUrl = (Boolean)attributes.get("oneTimeUrl");

		if (oneTimeUrl != null) {
			setOneTimeUrl(oneTimeUrl);
		}
	}

	/**
	* Returns the primary key of this url.
	*
	* @return the primary key of this url
	*/
	public long getPrimaryKey() {
		return _url.getPrimaryKey();
	}

	/**
	* Sets the primary key of this url.
	*
	* @param primaryKey the primary key of this url
	*/
	public void setPrimaryKey(long primaryKey) {
		_url.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this url.
	*
	* @return the uuid of this url
	*/
	public java.lang.String getUuid() {
		return _url.getUuid();
	}

	/**
	* Sets the uuid of this url.
	*
	* @param uuid the uuid of this url
	*/
	public void setUuid(java.lang.String uuid) {
		_url.setUuid(uuid);
	}

	/**
	* Returns the url ID of this url.
	*
	* @return the url ID of this url
	*/
	public long getUrlId() {
		return _url.getUrlId();
	}

	/**
	* Sets the url ID of this url.
	*
	* @param urlId the url ID of this url
	*/
	public void setUrlId(long urlId) {
		_url.setUrlId(urlId);
	}

	/**
	* Returns the user ID of this url.
	*
	* @return the user ID of this url
	*/
	public long getUserId() {
		return _url.getUserId();
	}

	/**
	* Sets the user ID of this url.
	*
	* @param userId the user ID of this url
	*/
	public void setUserId(long userId) {
		_url.setUserId(userId);
	}

	/**
	* Returns the user uuid of this url.
	*
	* @return the user uuid of this url
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _url.getUserUuid();
	}

	/**
	* Sets the user uuid of this url.
	*
	* @param userUuid the user uuid of this url
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_url.setUserUuid(userUuid);
	}

	/**
	* Returns the company ID of this url.
	*
	* @return the company ID of this url
	*/
	public long getCompanyId() {
		return _url.getCompanyId();
	}

	/**
	* Sets the company ID of this url.
	*
	* @param companyId the company ID of this url
	*/
	public void setCompanyId(long companyId) {
		_url.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this url.
	*
	* @return the group ID of this url
	*/
	public long getGroupId() {
		return _url.getGroupId();
	}

	/**
	* Sets the group ID of this url.
	*
	* @param groupId the group ID of this url
	*/
	public void setGroupId(long groupId) {
		_url.setGroupId(groupId);
	}

	/**
	* Returns the hash of this url.
	*
	* @return the hash of this url
	*/
	public java.lang.String getHash() {
		return _url.getHash();
	}

	/**
	* Sets the hash of this url.
	*
	* @param hash the hash of this url
	*/
	public void setHash(java.lang.String hash) {
		_url.setHash(hash);
	}

	/**
	* Returns the original url of this url.
	*
	* @return the original url of this url
	*/
	public java.lang.String getOriginalUrl() {
		return _url.getOriginalUrl();
	}

	/**
	* Sets the original url of this url.
	*
	* @param originalUrl the original url of this url
	*/
	public void setOriginalUrl(java.lang.String originalUrl) {
		_url.setOriginalUrl(originalUrl);
	}

	/**
	* Returns the private url of this url.
	*
	* @return the private url of this url
	*/
	public boolean getPrivateUrl() {
		return _url.getPrivateUrl();
	}

	/**
	* Returns <code>true</code> if this url is private url.
	*
	* @return <code>true</code> if this url is private url; <code>false</code> otherwise
	*/
	public boolean isPrivateUrl() {
		return _url.isPrivateUrl();
	}

	/**
	* Sets whether this url is private url.
	*
	* @param privateUrl the private url of this url
	*/
	public void setPrivateUrl(boolean privateUrl) {
		_url.setPrivateUrl(privateUrl);
	}

	/**
	* Returns the protected url of this url.
	*
	* @return the protected url of this url
	*/
	public boolean getProtectedUrl() {
		return _url.getProtectedUrl();
	}

	/**
	* Returns <code>true</code> if this url is protected url.
	*
	* @return <code>true</code> if this url is protected url; <code>false</code> otherwise
	*/
	public boolean isProtectedUrl() {
		return _url.isProtectedUrl();
	}

	/**
	* Sets whether this url is protected url.
	*
	* @param protectedUrl the protected url of this url
	*/
	public void setProtectedUrl(boolean protectedUrl) {
		_url.setProtectedUrl(protectedUrl);
	}

	/**
	* Returns the password of this url.
	*
	* @return the password of this url
	*/
	public java.lang.String getPassword() {
		return _url.getPassword();
	}

	/**
	* Sets the password of this url.
	*
	* @param password the password of this url
	*/
	public void setPassword(java.lang.String password) {
		_url.setPassword(password);
	}

	/**
	* Returns the created date of this url.
	*
	* @return the created date of this url
	*/
	public java.util.Date getCreatedDate() {
		return _url.getCreatedDate();
	}

	/**
	* Sets the created date of this url.
	*
	* @param createdDate the created date of this url
	*/
	public void setCreatedDate(java.util.Date createdDate) {
		_url.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this url.
	*
	* @return the modified date of this url
	*/
	public java.util.Date getModifiedDate() {
		return _url.getModifiedDate();
	}

	/**
	* Sets the modified date of this url.
	*
	* @param modifiedDate the modified date of this url
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_url.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the archived of this url.
	*
	* @return the archived of this url
	*/
	public boolean getArchived() {
		return _url.getArchived();
	}

	/**
	* Returns <code>true</code> if this url is archived.
	*
	* @return <code>true</code> if this url is archived; <code>false</code> otherwise
	*/
	public boolean isArchived() {
		return _url.isArchived();
	}

	/**
	* Sets whether this url is archived.
	*
	* @param archived the archived of this url
	*/
	public void setArchived(boolean archived) {
		_url.setArchived(archived);
	}

	/**
	* Returns the custom url of this url.
	*
	* @return the custom url of this url
	*/
	public boolean getCustomUrl() {
		return _url.getCustomUrl();
	}

	/**
	* Returns <code>true</code> if this url is custom url.
	*
	* @return <code>true</code> if this url is custom url; <code>false</code> otherwise
	*/
	public boolean isCustomUrl() {
		return _url.isCustomUrl();
	}

	/**
	* Sets whether this url is custom url.
	*
	* @param customUrl the custom url of this url
	*/
	public void setCustomUrl(boolean customUrl) {
		_url.setCustomUrl(customUrl);
	}

	/**
	* Returns the qrcode of this url.
	*
	* @return the qrcode of this url
	*/
	public boolean getQrcode() {
		return _url.getQrcode();
	}

	/**
	* Returns <code>true</code> if this url is qrcode.
	*
	* @return <code>true</code> if this url is qrcode; <code>false</code> otherwise
	*/
	public boolean isQrcode() {
		return _url.isQrcode();
	}

	/**
	* Sets whether this url is qrcode.
	*
	* @param qrcode the qrcode of this url
	*/
	public void setQrcode(boolean qrcode) {
		_url.setQrcode(qrcode);
	}

	/**
	* Returns the statistics of this url.
	*
	* @return the statistics of this url
	*/
	public boolean getStatistics() {
		return _url.getStatistics();
	}

	/**
	* Returns <code>true</code> if this url is statistics.
	*
	* @return <code>true</code> if this url is statistics; <code>false</code> otherwise
	*/
	public boolean isStatistics() {
		return _url.isStatistics();
	}

	/**
	* Sets whether this url is statistics.
	*
	* @param statistics the statistics of this url
	*/
	public void setStatistics(boolean statistics) {
		_url.setStatistics(statistics);
	}

	/**
	* Returns the favicon of this url.
	*
	* @return the favicon of this url
	*/
	public java.lang.String getFavicon() {
		return _url.getFavicon();
	}

	/**
	* Sets the favicon of this url.
	*
	* @param favicon the favicon of this url
	*/
	public void setFavicon(java.lang.String favicon) {
		_url.setFavicon(favicon);
	}

	/**
	* Returns the preview of this url.
	*
	* @return the preview of this url
	*/
	public java.lang.String getPreview() {
		return _url.getPreview();
	}

	/**
	* Sets the preview of this url.
	*
	* @param preview the preview of this url
	*/
	public void setPreview(java.lang.String preview) {
		_url.setPreview(preview);
	}

	/**
	* Returns the status of this url.
	*
	* @return the status of this url
	*/
	public int getStatus() {
		return _url.getStatus();
	}

	/**
	* Sets the status of this url.
	*
	* @param status the status of this url
	*/
	public void setStatus(int status) {
		_url.setStatus(status);
	}

	/**
	* Returns the expiration date of this url.
	*
	* @return the expiration date of this url
	*/
	public java.util.Date getExpirationDate() {
		return _url.getExpirationDate();
	}

	/**
	* Sets the expiration date of this url.
	*
	* @param expirationDate the expiration date of this url
	*/
	public void setExpirationDate(java.util.Date expirationDate) {
		_url.setExpirationDate(expirationDate);
	}

	/**
	* Returns the one time url of this url.
	*
	* @return the one time url of this url
	*/
	public boolean getOneTimeUrl() {
		return _url.getOneTimeUrl();
	}

	/**
	* Returns <code>true</code> if this url is one time url.
	*
	* @return <code>true</code> if this url is one time url; <code>false</code> otherwise
	*/
	public boolean isOneTimeUrl() {
		return _url.isOneTimeUrl();
	}

	/**
	* Sets whether this url is one time url.
	*
	* @param oneTimeUrl the one time url of this url
	*/
	public void setOneTimeUrl(boolean oneTimeUrl) {
		_url.setOneTimeUrl(oneTimeUrl);
	}

	public boolean isNew() {
		return _url.isNew();
	}

	public void setNew(boolean n) {
		_url.setNew(n);
	}

	public boolean isCachedModel() {
		return _url.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_url.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _url.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _url.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_url.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _url.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_url.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UrlWrapper((Url)_url.clone());
	}

	public int compareTo(hu.vilmospapp.urlshrinker.model.Url url) {
		return _url.compareTo(url);
	}

	@Override
	public int hashCode() {
		return _url.hashCode();
	}

	public com.liferay.portal.model.CacheModel<hu.vilmospapp.urlshrinker.model.Url> toCacheModel() {
		return _url.toCacheModel();
	}

	public hu.vilmospapp.urlshrinker.model.Url toEscapedModel() {
		return new UrlWrapper(_url.toEscapedModel());
	}

	public hu.vilmospapp.urlshrinker.model.Url toUnescapedModel() {
		return new UrlWrapper(_url.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _url.toString();
	}

	public java.lang.String toXmlString() {
		return _url.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_url.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UrlWrapper)) {
			return false;
		}

		UrlWrapper urlWrapper = (UrlWrapper)obj;

		if (Validator.equals(_url, urlWrapper._url)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Url getWrappedUrl() {
		return _url;
	}

	public Url getWrappedModel() {
		return _url;
	}

	public void resetOriginalValues() {
		_url.resetOriginalValues();
	}

	private Url _url;
}