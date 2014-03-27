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

package hu.vilmospapp.urlshrinker.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import hu.vilmospapp.urlshrinker.model.Url;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Url in entity cache.
 *
 * @author Vilmos Papp
 * @see Url
 * @generated
 */
public class UrlCacheModel implements CacheModel<Url>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", urlId=");
		sb.append(urlId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", hash=");
		sb.append(hash);
		sb.append(", originalUrl=");
		sb.append(originalUrl);
		sb.append(", privateUrl=");
		sb.append(privateUrl);
		sb.append(", protectedUrl=");
		sb.append(protectedUrl);
		sb.append(", password=");
		sb.append(password);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", archived=");
		sb.append(archived);
		sb.append(", customUrl=");
		sb.append(customUrl);
		sb.append(", qrcode=");
		sb.append(qrcode);
		sb.append(", statistics=");
		sb.append(statistics);
		sb.append("}");

		return sb.toString();
	}

	public Url toEntityModel() {
		UrlImpl urlImpl = new UrlImpl();

		if (uuid == null) {
			urlImpl.setUuid(StringPool.BLANK);
		}
		else {
			urlImpl.setUuid(uuid);
		}

		urlImpl.setUrlId(urlId);
		urlImpl.setUserId(userId);
		urlImpl.setCompanyId(companyId);
		urlImpl.setGroupId(groupId);

		if (hash == null) {
			urlImpl.setHash(StringPool.BLANK);
		}
		else {
			urlImpl.setHash(hash);
		}

		if (originalUrl == null) {
			urlImpl.setOriginalUrl(StringPool.BLANK);
		}
		else {
			urlImpl.setOriginalUrl(originalUrl);
		}

		urlImpl.setPrivateUrl(privateUrl);
		urlImpl.setProtectedUrl(protectedUrl);

		if (password == null) {
			urlImpl.setPassword(StringPool.BLANK);
		}
		else {
			urlImpl.setPassword(password);
		}

		if (createdDate == Long.MIN_VALUE) {
			urlImpl.setCreatedDate(null);
		}
		else {
			urlImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			urlImpl.setModifiedDate(null);
		}
		else {
			urlImpl.setModifiedDate(new Date(modifiedDate));
		}

		urlImpl.setArchived(archived);
		urlImpl.setCustomUrl(customUrl);
		urlImpl.setQrcode(qrcode);
		urlImpl.setStatistics(statistics);

		urlImpl.resetOriginalValues();

		return urlImpl;
	}

	public String uuid;
	public long urlId;
	public long userId;
	public long companyId;
	public long groupId;
	public String hash;
	public String originalUrl;
	public boolean privateUrl;
	public boolean protectedUrl;
	public String password;
	public long createdDate;
	public long modifiedDate;
	public boolean archived;
	public boolean customUrl;
	public boolean qrcode;
	public boolean statistics;
}