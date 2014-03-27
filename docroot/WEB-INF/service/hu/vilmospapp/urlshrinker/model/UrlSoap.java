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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link hu.vilmospapp.urlshrinker.service.http.UrlServiceSoap}.
 *
 * @author    Vilmos Papp
 * @see       hu.vilmospapp.urlshrinker.service.http.UrlServiceSoap
 * @generated
 */
public class UrlSoap implements Serializable {
	public static UrlSoap toSoapModel(Url model) {
		UrlSoap soapModel = new UrlSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setUrlId(model.getUrlId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setHash(model.getHash());
		soapModel.setOriginalUrl(model.getOriginalUrl());
		soapModel.setPrivateUrl(model.getPrivateUrl());
		soapModel.setProtectedUrl(model.getProtectedUrl());
		soapModel.setPassword(model.getPassword());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setArchived(model.getArchived());
		soapModel.setCustomUrl(model.getCustomUrl());
		soapModel.setQrcode(model.getQrcode());
		soapModel.setStatistics(model.getStatistics());

		return soapModel;
	}

	public static UrlSoap[] toSoapModels(Url[] models) {
		UrlSoap[] soapModels = new UrlSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UrlSoap[][] toSoapModels(Url[][] models) {
		UrlSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UrlSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UrlSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UrlSoap[] toSoapModels(List<Url> models) {
		List<UrlSoap> soapModels = new ArrayList<UrlSoap>(models.size());

		for (Url model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UrlSoap[soapModels.size()]);
	}

	public UrlSoap() {
	}

	public long getPrimaryKey() {
		return _urlId;
	}

	public void setPrimaryKey(long pk) {
		setUrlId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getUrlId() {
		return _urlId;
	}

	public void setUrlId(long urlId) {
		_urlId = urlId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getHash() {
		return _hash;
	}

	public void setHash(String hash) {
		_hash = hash;
	}

	public String getOriginalUrl() {
		return _originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		_originalUrl = originalUrl;
	}

	public boolean getPrivateUrl() {
		return _privateUrl;
	}

	public boolean isPrivateUrl() {
		return _privateUrl;
	}

	public void setPrivateUrl(boolean privateUrl) {
		_privateUrl = privateUrl;
	}

	public boolean getProtectedUrl() {
		return _protectedUrl;
	}

	public boolean isProtectedUrl() {
		return _protectedUrl;
	}

	public void setProtectedUrl(boolean protectedUrl) {
		_protectedUrl = protectedUrl;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public boolean getArchived() {
		return _archived;
	}

	public boolean isArchived() {
		return _archived;
	}

	public void setArchived(boolean archived) {
		_archived = archived;
	}

	public boolean getCustomUrl() {
		return _customUrl;
	}

	public boolean isCustomUrl() {
		return _customUrl;
	}

	public void setCustomUrl(boolean customUrl) {
		_customUrl = customUrl;
	}

	public boolean getQrcode() {
		return _qrcode;
	}

	public boolean isQrcode() {
		return _qrcode;
	}

	public void setQrcode(boolean qrcode) {
		_qrcode = qrcode;
	}

	public boolean getStatistics() {
		return _statistics;
	}

	public boolean isStatistics() {
		return _statistics;
	}

	public void setStatistics(boolean statistics) {
		_statistics = statistics;
	}

	private String _uuid;
	private long _urlId;
	private long _userId;
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
}