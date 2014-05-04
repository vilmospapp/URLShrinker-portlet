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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import hu.vilmospapp.urlshrinker.service.ClpSerializer;
import hu.vilmospapp.urlshrinker.service.UrlLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Vilmos Papp
 */
public class UrlClp extends BaseModelImpl<Url> implements Url {
	public UrlClp() {
	}

	public Class<?> getModelClass() {
		return Url.class;
	}

	public String getModelClassName() {
		return Url.class.getName();
	}

	public long getPrimaryKey() {
		return _urlId;
	}

	public void setPrimaryKey(long primaryKey) {
		setUrlId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_urlId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_urlRemoteModel != null) {
			try {
				Class<?> clazz = _urlRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_urlRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getUrlId() {
		return _urlId;
	}

	public void setUrlId(long urlId) {
		_urlId = urlId;

		if (_urlRemoteModel != null) {
			try {
				Class<?> clazz = _urlRemoteModel.getClass();

				Method method = clazz.getMethod("setUrlId", long.class);

				method.invoke(_urlRemoteModel, urlId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;

		if (_urlRemoteModel != null) {
			try {
				Class<?> clazz = _urlRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_urlRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_urlRemoteModel != null) {
			try {
				Class<?> clazz = _urlRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_urlRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_urlRemoteModel != null) {
			try {
				Class<?> clazz = _urlRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_urlRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getHash() {
		return _hash;
	}

	public void setHash(String hash) {
		_hash = hash;

		if (_urlRemoteModel != null) {
			try {
				Class<?> clazz = _urlRemoteModel.getClass();

				Method method = clazz.getMethod("setHash", String.class);

				method.invoke(_urlRemoteModel, hash);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getOriginalUrl() {
		return _originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		_originalUrl = originalUrl;

		if (_urlRemoteModel != null) {
			try {
				Class<?> clazz = _urlRemoteModel.getClass();

				Method method = clazz.getMethod("setOriginalUrl", String.class);

				method.invoke(_urlRemoteModel, originalUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public boolean getPrivateUrl() {
		return _privateUrl;
	}

	public boolean isPrivateUrl() {
		return _privateUrl;
	}

	public void setPrivateUrl(boolean privateUrl) {
		_privateUrl = privateUrl;

		if (_urlRemoteModel != null) {
			try {
				Class<?> clazz = _urlRemoteModel.getClass();

				Method method = clazz.getMethod("setPrivateUrl", boolean.class);

				method.invoke(_urlRemoteModel, privateUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public boolean getProtectedUrl() {
		return _protectedUrl;
	}

	public boolean isProtectedUrl() {
		return _protectedUrl;
	}

	public void setProtectedUrl(boolean protectedUrl) {
		_protectedUrl = protectedUrl;

		if (_urlRemoteModel != null) {
			try {
				Class<?> clazz = _urlRemoteModel.getClass();

				Method method = clazz.getMethod("setProtectedUrl", boolean.class);

				method.invoke(_urlRemoteModel, protectedUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;

		if (_urlRemoteModel != null) {
			try {
				Class<?> clazz = _urlRemoteModel.getClass();

				Method method = clazz.getMethod("setPassword", String.class);

				method.invoke(_urlRemoteModel, password);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;

		if (_urlRemoteModel != null) {
			try {
				Class<?> clazz = _urlRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_urlRemoteModel, createdDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_urlRemoteModel != null) {
			try {
				Class<?> clazz = _urlRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_urlRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public boolean getArchived() {
		return _archived;
	}

	public boolean isArchived() {
		return _archived;
	}

	public void setArchived(boolean archived) {
		_archived = archived;

		if (_urlRemoteModel != null) {
			try {
				Class<?> clazz = _urlRemoteModel.getClass();

				Method method = clazz.getMethod("setArchived", boolean.class);

				method.invoke(_urlRemoteModel, archived);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public boolean getCustomUrl() {
		return _customUrl;
	}

	public boolean isCustomUrl() {
		return _customUrl;
	}

	public void setCustomUrl(boolean customUrl) {
		_customUrl = customUrl;

		if (_urlRemoteModel != null) {
			try {
				Class<?> clazz = _urlRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomUrl", boolean.class);

				method.invoke(_urlRemoteModel, customUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public boolean getQrcode() {
		return _qrcode;
	}

	public boolean isQrcode() {
		return _qrcode;
	}

	public void setQrcode(boolean qrcode) {
		_qrcode = qrcode;

		if (_urlRemoteModel != null) {
			try {
				Class<?> clazz = _urlRemoteModel.getClass();

				Method method = clazz.getMethod("setQrcode", boolean.class);

				method.invoke(_urlRemoteModel, qrcode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public boolean getStatistics() {
		return _statistics;
	}

	public boolean isStatistics() {
		return _statistics;
	}

	public void setStatistics(boolean statistics) {
		_statistics = statistics;

		if (_urlRemoteModel != null) {
			try {
				Class<?> clazz = _urlRemoteModel.getClass();

				Method method = clazz.getMethod("setStatistics", boolean.class);

				method.invoke(_urlRemoteModel, statistics);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getFavicon() {
		return _favicon;
	}

	public void setFavicon(String favicon) {
		_favicon = favicon;

		if (_urlRemoteModel != null) {
			try {
				Class<?> clazz = _urlRemoteModel.getClass();

				Method method = clazz.getMethod("setFavicon", String.class);

				method.invoke(_urlRemoteModel, favicon);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getPreview() {
		return _preview;
	}

	public void setPreview(String preview) {
		_preview = preview;

		if (_urlRemoteModel != null) {
			try {
				Class<?> clazz = _urlRemoteModel.getClass();

				Method method = clazz.getMethod("setPreview", String.class);

				method.invoke(_urlRemoteModel, preview);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;

		if (_urlRemoteModel != null) {
			try {
				Class<?> clazz = _urlRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_urlRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getExpirationDate() {
		return _expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		_expirationDate = expirationDate;

		if (_urlRemoteModel != null) {
			try {
				Class<?> clazz = _urlRemoteModel.getClass();

				Method method = clazz.getMethod("setExpirationDate", Date.class);

				method.invoke(_urlRemoteModel, expirationDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public boolean getOneTimeUrl() {
		return _oneTimeUrl;
	}

	public boolean isOneTimeUrl() {
		return _oneTimeUrl;
	}

	public void setOneTimeUrl(boolean oneTimeUrl) {
		_oneTimeUrl = oneTimeUrl;

		if (_urlRemoteModel != null) {
			try {
				Class<?> clazz = _urlRemoteModel.getClass();

				Method method = clazz.getMethod("setOneTimeUrl", boolean.class);

				method.invoke(_urlRemoteModel, oneTimeUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUrlRemoteModel() {
		return _urlRemoteModel;
	}

	public void setUrlRemoteModel(BaseModel<?> urlRemoteModel) {
		_urlRemoteModel = urlRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _urlRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_urlRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			UrlLocalServiceUtil.addUrl(this);
		}
		else {
			UrlLocalServiceUtil.updateUrl(this);
		}
	}

	@Override
	public Url toEscapedModel() {
		return (Url)ProxyUtil.newProxyInstance(Url.class.getClassLoader(),
			new Class[] { Url.class }, new AutoEscapeBeanHandler(this));
	}

	public Url toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		UrlClp clone = new UrlClp();

		clone.setUuid(getUuid());
		clone.setUrlId(getUrlId());
		clone.setUserId(getUserId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setHash(getHash());
		clone.setOriginalUrl(getOriginalUrl());
		clone.setPrivateUrl(getPrivateUrl());
		clone.setProtectedUrl(getProtectedUrl());
		clone.setPassword(getPassword());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setArchived(getArchived());
		clone.setCustomUrl(getCustomUrl());
		clone.setQrcode(getQrcode());
		clone.setStatistics(getStatistics());
		clone.setFavicon(getFavicon());
		clone.setPreview(getPreview());
		clone.setStatus(getStatus());
		clone.setExpirationDate(getExpirationDate());
		clone.setOneTimeUrl(getOneTimeUrl());

		return clone;
	}

	public int compareTo(Url url) {
		long primaryKey = url.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UrlClp)) {
			return false;
		}

		UrlClp url = (UrlClp)obj;

		long primaryKey = url.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", urlId=");
		sb.append(getUrlId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", hash=");
		sb.append(getHash());
		sb.append(", originalUrl=");
		sb.append(getOriginalUrl());
		sb.append(", privateUrl=");
		sb.append(getPrivateUrl());
		sb.append(", protectedUrl=");
		sb.append(getProtectedUrl());
		sb.append(", password=");
		sb.append(getPassword());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", archived=");
		sb.append(getArchived());
		sb.append(", customUrl=");
		sb.append(getCustomUrl());
		sb.append(", qrcode=");
		sb.append(getQrcode());
		sb.append(", statistics=");
		sb.append(getStatistics());
		sb.append(", favicon=");
		sb.append(getFavicon());
		sb.append(", preview=");
		sb.append(getPreview());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", expirationDate=");
		sb.append(getExpirationDate());
		sb.append(", oneTimeUrl=");
		sb.append(getOneTimeUrl());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(67);

		sb.append("<model><model-name>");
		sb.append("hu.vilmospapp.urlshrinker.model.Url");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>urlId</column-name><column-value><![CDATA[");
		sb.append(getUrlId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hash</column-name><column-value><![CDATA[");
		sb.append(getHash());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>originalUrl</column-name><column-value><![CDATA[");
		sb.append(getOriginalUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>privateUrl</column-name><column-value><![CDATA[");
		sb.append(getPrivateUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>protectedUrl</column-name><column-value><![CDATA[");
		sb.append(getProtectedUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>password</column-name><column-value><![CDATA[");
		sb.append(getPassword());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>archived</column-name><column-value><![CDATA[");
		sb.append(getArchived());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customUrl</column-name><column-value><![CDATA[");
		sb.append(getCustomUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>qrcode</column-name><column-value><![CDATA[");
		sb.append(getQrcode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statistics</column-name><column-value><![CDATA[");
		sb.append(getStatistics());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>favicon</column-name><column-value><![CDATA[");
		sb.append(getFavicon());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>preview</column-name><column-value><![CDATA[");
		sb.append(getPreview());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expirationDate</column-name><column-value><![CDATA[");
		sb.append(getExpirationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>oneTimeUrl</column-name><column-value><![CDATA[");
		sb.append(getOneTimeUrl());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _urlId;
	private long _userId;
	private String _userUuid;
	private long _companyId;
	private long _groupId;
	private String _hash;
	private String _originalUrl;
	private boolean _privateUrl;
	private boolean _protectedUrl;
	private String _password;
	private Date _createdDate;
	private Date _modifiedDate;
	private boolean _archived;
	private boolean _customUrl;
	private boolean _qrcode;
	private boolean _statistics;
	private String _favicon;
	private String _preview;
	private int _status;
	private Date _expirationDate;
	private boolean _oneTimeUrl;
	private BaseModel<?> _urlRemoteModel;
}