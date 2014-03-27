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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import hu.vilmospapp.urlshrinker.NoSuchUrlException;
import hu.vilmospapp.urlshrinker.model.Url;
import hu.vilmospapp.urlshrinker.model.impl.UrlImpl;
import hu.vilmospapp.urlshrinker.model.impl.UrlModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the url service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Vilmos Papp
 * @see UrlPersistence
 * @see UrlUtil
 * @generated
 */
public class UrlPersistenceImpl extends BasePersistenceImpl<Url>
	implements UrlPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UrlUtil} to access the url persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UrlImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(UrlModelImpl.ENTITY_CACHE_ENABLED,
			UrlModelImpl.FINDER_CACHE_ENABLED, UrlImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(UrlModelImpl.ENTITY_CACHE_ENABLED,
			UrlModelImpl.FINDER_CACHE_ENABLED, UrlImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			UrlModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(UrlModelImpl.ENTITY_CACHE_ENABLED,
			UrlModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(UrlModelImpl.ENTITY_CACHE_ENABLED,
			UrlModelImpl.FINDER_CACHE_ENABLED, UrlImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			UrlModelImpl.UUID_COLUMN_BITMASK |
			UrlModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(UrlModelImpl.ENTITY_CACHE_ENABLED,
			UrlModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_C_G_U = new FinderPath(UrlModelImpl.ENTITY_CACHE_ENABLED,
			UrlModelImpl.FINDER_CACHE_ENABLED, UrlImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			UrlModelImpl.COMPANYID_COLUMN_BITMASK |
			UrlModelImpl.GROUPID_COLUMN_BITMASK |
			UrlModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G_U = new FinderPath(UrlModelImpl.ENTITY_CACHE_ENABLED,
			UrlModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_H = new FinderPath(UrlModelImpl.ENTITY_CACHE_ENABLED,
			UrlModelImpl.FINDER_CACHE_ENABLED, UrlImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G_H",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_H = new FinderPath(UrlModelImpl.ENTITY_CACHE_ENABLED,
			UrlModelImpl.FINDER_CACHE_ENABLED, UrlImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G_H",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			UrlModelImpl.COMPANYID_COLUMN_BITMASK |
			UrlModelImpl.GROUPID_COLUMN_BITMASK |
			UrlModelImpl.HASH_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G_H = new FinderPath(UrlModelImpl.ENTITY_CACHE_ENABLED,
			UrlModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_H",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_H_P_P_A =
		new FinderPath(UrlModelImpl.ENTITY_CACHE_ENABLED,
			UrlModelImpl.FINDER_CACHE_ENABLED, UrlImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G_H_P_P_A",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Boolean.class.getName(),
				Boolean.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_H_P_P_A =
		new FinderPath(UrlModelImpl.ENTITY_CACHE_ENABLED,
			UrlModelImpl.FINDER_CACHE_ENABLED, UrlImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G_H_P_P_A",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Boolean.class.getName(),
				Boolean.class.getName(), Boolean.class.getName()
			},
			UrlModelImpl.COMPANYID_COLUMN_BITMASK |
			UrlModelImpl.GROUPID_COLUMN_BITMASK |
			UrlModelImpl.HASH_COLUMN_BITMASK |
			UrlModelImpl.PRIVATEURL_COLUMN_BITMASK |
			UrlModelImpl.PROTECTEDURL_COLUMN_BITMASK |
			UrlModelImpl.ARCHIVED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G_H_P_P_A = new FinderPath(UrlModelImpl.ENTITY_CACHE_ENABLED,
			UrlModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_H_P_P_A",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Boolean.class.getName(),
				Boolean.class.getName(), Boolean.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_H_P_P =
		new FinderPath(UrlModelImpl.ENTITY_CACHE_ENABLED,
			UrlModelImpl.FINDER_CACHE_ENABLED, UrlImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G_H_P_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Boolean.class.getName(),
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_H_P_P =
		new FinderPath(UrlModelImpl.ENTITY_CACHE_ENABLED,
			UrlModelImpl.FINDER_CACHE_ENABLED, UrlImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G_H_P_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			},
			UrlModelImpl.COMPANYID_COLUMN_BITMASK |
			UrlModelImpl.GROUPID_COLUMN_BITMASK |
			UrlModelImpl.HASH_COLUMN_BITMASK |
			UrlModelImpl.PRIVATEURL_COLUMN_BITMASK |
			UrlModelImpl.PROTECTEDURL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G_H_P_P = new FinderPath(UrlModelImpl.ENTITY_CACHE_ENABLED,
			UrlModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_H_P_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			});
	public static final FinderPath FINDER_PATH_FETCH_BY_C_G_H_PRIVATE_A = new FinderPath(UrlModelImpl.ENTITY_CACHE_ENABLED,
			UrlModelImpl.FINDER_CACHE_ENABLED, UrlImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_G_H_Private_A",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			},
			UrlModelImpl.COMPANYID_COLUMN_BITMASK |
			UrlModelImpl.GROUPID_COLUMN_BITMASK |
			UrlModelImpl.HASH_COLUMN_BITMASK |
			UrlModelImpl.PRIVATEURL_COLUMN_BITMASK |
			UrlModelImpl.ARCHIVED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G_H_PRIVATE_A = new FinderPath(UrlModelImpl.ENTITY_CACHE_ENABLED,
			UrlModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByC_G_H_Private_A",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UrlModelImpl.ENTITY_CACHE_ENABLED,
			UrlModelImpl.FINDER_CACHE_ENABLED, UrlImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UrlModelImpl.ENTITY_CACHE_ENABLED,
			UrlModelImpl.FINDER_CACHE_ENABLED, UrlImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UrlModelImpl.ENTITY_CACHE_ENABLED,
			UrlModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the url in the entity cache if it is enabled.
	 *
	 * @param url the url
	 */
	public void cacheResult(Url url) {
		EntityCacheUtil.putResult(UrlModelImpl.ENTITY_CACHE_ENABLED,
			UrlImpl.class, url.getPrimaryKey(), url);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { url.getUuid(), Long.valueOf(url.getGroupId()) }, url);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_U,
			new Object[] {
				Long.valueOf(url.getCompanyId()), Long.valueOf(url.getGroupId()),
				Long.valueOf(url.getUserId())
			}, url);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_H_PRIVATE_A,
			new Object[] {
				Long.valueOf(url.getCompanyId()), Long.valueOf(url.getGroupId()),
				
			url.getHash(), Boolean.valueOf(url.getPrivateUrl()),
				Boolean.valueOf(url.getArchived())
			}, url);

		url.resetOriginalValues();
	}

	/**
	 * Caches the urls in the entity cache if it is enabled.
	 *
	 * @param urls the urls
	 */
	public void cacheResult(List<Url> urls) {
		for (Url url : urls) {
			if (EntityCacheUtil.getResult(UrlModelImpl.ENTITY_CACHE_ENABLED,
						UrlImpl.class, url.getPrimaryKey()) == null) {
				cacheResult(url);
			}
			else {
				url.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all urls.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UrlImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UrlImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the url.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Url url) {
		EntityCacheUtil.removeResult(UrlModelImpl.ENTITY_CACHE_ENABLED,
			UrlImpl.class, url.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(url);
	}

	@Override
	public void clearCache(List<Url> urls) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Url url : urls) {
			EntityCacheUtil.removeResult(UrlModelImpl.ENTITY_CACHE_ENABLED,
				UrlImpl.class, url.getPrimaryKey());

			clearUniqueFindersCache(url);
		}
	}

	protected void cacheUniqueFindersCache(Url url) {
		if (url.isNew()) {
			Object[] args = new Object[] {
					url.getUuid(), Long.valueOf(url.getGroupId())
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, url);

			args = new Object[] {
					Long.valueOf(url.getCompanyId()),
					Long.valueOf(url.getGroupId()),
					Long.valueOf(url.getUserId())
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_G_U, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_U, args, url);

			args = new Object[] {
					Long.valueOf(url.getCompanyId()),
					Long.valueOf(url.getGroupId()),
					
					url.getHash(), Boolean.valueOf(url.getPrivateUrl()),
					Boolean.valueOf(url.getArchived())
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_G_H_PRIVATE_A,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_H_PRIVATE_A,
				args, url);
		}
		else {
			UrlModelImpl urlModelImpl = (UrlModelImpl)url;

			if ((urlModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						url.getUuid(), Long.valueOf(url.getGroupId())
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, url);
			}

			if ((urlModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_G_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(url.getCompanyId()),
						Long.valueOf(url.getGroupId()),
						Long.valueOf(url.getUserId())
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_G_U, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_U, args, url);
			}

			if ((urlModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_G_H_PRIVATE_A.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(url.getCompanyId()),
						Long.valueOf(url.getGroupId()),
						
						url.getHash(), Boolean.valueOf(url.getPrivateUrl()),
						Boolean.valueOf(url.getArchived())
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_G_H_PRIVATE_A,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_H_PRIVATE_A,
					args, url);
			}
		}
	}

	protected void clearUniqueFindersCache(Url url) {
		UrlModelImpl urlModelImpl = (UrlModelImpl)url;

		Object[] args = new Object[] {
				url.getUuid(), Long.valueOf(url.getGroupId())
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((urlModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					urlModelImpl.getOriginalUuid(),
					Long.valueOf(urlModelImpl.getOriginalGroupId())
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				Long.valueOf(url.getCompanyId()), Long.valueOf(url.getGroupId()),
				Long.valueOf(url.getUserId())
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_U, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_U, args);

		if ((urlModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_G_U.getColumnBitmask()) != 0) {
			args = new Object[] {
					Long.valueOf(urlModelImpl.getOriginalCompanyId()),
					Long.valueOf(urlModelImpl.getOriginalGroupId()),
					Long.valueOf(urlModelImpl.getOriginalUserId())
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_U, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_U, args);
		}

		args = new Object[] {
				Long.valueOf(url.getCompanyId()), Long.valueOf(url.getGroupId()),
				
				url.getHash(), Boolean.valueOf(url.getPrivateUrl()),
				Boolean.valueOf(url.getArchived())
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_H_PRIVATE_A, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_H_PRIVATE_A, args);

		if ((urlModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_G_H_PRIVATE_A.getColumnBitmask()) != 0) {
			args = new Object[] {
					Long.valueOf(urlModelImpl.getOriginalCompanyId()),
					Long.valueOf(urlModelImpl.getOriginalGroupId()),
					
					urlModelImpl.getOriginalHash(),
					Boolean.valueOf(urlModelImpl.getOriginalPrivateUrl()),
					Boolean.valueOf(urlModelImpl.getOriginalArchived())
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_H_PRIVATE_A,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_H_PRIVATE_A,
				args);
		}
	}

	/**
	 * Creates a new url with the primary key. Does not add the url to the database.
	 *
	 * @param urlId the primary key for the new url
	 * @return the new url
	 */
	public Url create(long urlId) {
		Url url = new UrlImpl();

		url.setNew(true);
		url.setPrimaryKey(urlId);

		String uuid = PortalUUIDUtil.generate();

		url.setUuid(uuid);

		return url;
	}

	/**
	 * Removes the url with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param urlId the primary key of the url
	 * @return the url that was removed
	 * @throws hu.vilmospapp.urlshrinker.NoSuchUrlException if a url with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Url remove(long urlId) throws NoSuchUrlException, SystemException {
		return remove(Long.valueOf(urlId));
	}

	/**
	 * Removes the url with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the url
	 * @return the url that was removed
	 * @throws hu.vilmospapp.urlshrinker.NoSuchUrlException if a url with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Url remove(Serializable primaryKey)
		throws NoSuchUrlException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Url url = (Url)session.get(UrlImpl.class, primaryKey);

			if (url == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUrlException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(url);
		}
		catch (NoSuchUrlException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Url removeImpl(Url url) throws SystemException {
		url = toUnwrappedModel(url);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, url);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(url);

		return url;
	}

	@Override
	public Url updateImpl(hu.vilmospapp.urlshrinker.model.Url url, boolean merge)
		throws SystemException {
		url = toUnwrappedModel(url);

		boolean isNew = url.isNew();

		UrlModelImpl urlModelImpl = (UrlModelImpl)url;

		if (Validator.isNull(url.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			url.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, url, merge);

			url.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UrlModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((urlModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { urlModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { urlModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((urlModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_H.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(urlModelImpl.getOriginalCompanyId()),
						Long.valueOf(urlModelImpl.getOriginalGroupId()),
						
						urlModelImpl.getOriginalHash()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_H, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_H,
					args);

				args = new Object[] {
						Long.valueOf(urlModelImpl.getCompanyId()),
						Long.valueOf(urlModelImpl.getGroupId()),
						
						urlModelImpl.getHash()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_H, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_H,
					args);
			}

			if ((urlModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_H_P_P_A.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(urlModelImpl.getOriginalCompanyId()),
						Long.valueOf(urlModelImpl.getOriginalGroupId()),
						
						urlModelImpl.getOriginalHash(),
						Boolean.valueOf(urlModelImpl.getOriginalPrivateUrl()),
						Boolean.valueOf(urlModelImpl.getOriginalProtectedUrl()),
						Boolean.valueOf(urlModelImpl.getOriginalArchived())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_H_P_P_A,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_H_P_P_A,
					args);

				args = new Object[] {
						Long.valueOf(urlModelImpl.getCompanyId()),
						Long.valueOf(urlModelImpl.getGroupId()),
						
						urlModelImpl.getHash(),
						Boolean.valueOf(urlModelImpl.getPrivateUrl()),
						Boolean.valueOf(urlModelImpl.getProtectedUrl()),
						Boolean.valueOf(urlModelImpl.getArchived())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_H_P_P_A,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_H_P_P_A,
					args);
			}

			if ((urlModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_H_P_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(urlModelImpl.getOriginalCompanyId()),
						Long.valueOf(urlModelImpl.getOriginalGroupId()),
						
						urlModelImpl.getOriginalHash(),
						Boolean.valueOf(urlModelImpl.getOriginalPrivateUrl()),
						Boolean.valueOf(urlModelImpl.getOriginalProtectedUrl())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_H_P_P,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_H_P_P,
					args);

				args = new Object[] {
						Long.valueOf(urlModelImpl.getCompanyId()),
						Long.valueOf(urlModelImpl.getGroupId()),
						
						urlModelImpl.getHash(),
						Boolean.valueOf(urlModelImpl.getPrivateUrl()),
						Boolean.valueOf(urlModelImpl.getProtectedUrl())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_H_P_P,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_H_P_P,
					args);
			}
		}

		EntityCacheUtil.putResult(UrlModelImpl.ENTITY_CACHE_ENABLED,
			UrlImpl.class, url.getPrimaryKey(), url);

		clearUniqueFindersCache(url);
		cacheUniqueFindersCache(url);

		return url;
	}

	protected Url toUnwrappedModel(Url url) {
		if (url instanceof UrlImpl) {
			return url;
		}

		UrlImpl urlImpl = new UrlImpl();

		urlImpl.setNew(url.isNew());
		urlImpl.setPrimaryKey(url.getPrimaryKey());

		urlImpl.setUuid(url.getUuid());
		urlImpl.setUrlId(url.getUrlId());
		urlImpl.setUserId(url.getUserId());
		urlImpl.setCompanyId(url.getCompanyId());
		urlImpl.setGroupId(url.getGroupId());
		urlImpl.setHash(url.getHash());
		urlImpl.setOriginalUrl(url.getOriginalUrl());
		urlImpl.setPrivateUrl(url.isPrivateUrl());
		urlImpl.setProtectedUrl(url.isProtectedUrl());
		urlImpl.setPassword(url.getPassword());
		urlImpl.setCreatedDate(url.getCreatedDate());
		urlImpl.setModifiedDate(url.getModifiedDate());
		urlImpl.setArchived(url.isArchived());
		urlImpl.setCustomUrl(url.isCustomUrl());
		urlImpl.setQrcode(url.isQrcode());
		urlImpl.setStatistics(url.isStatistics());

		return urlImpl;
	}

	/**
	 * Returns the url with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the url
	 * @return the url
	 * @throws com.liferay.portal.NoSuchModelException if a url with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Url findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the url with the primary key or throws a {@link hu.vilmospapp.urlshrinker.NoSuchUrlException} if it could not be found.
	 *
	 * @param urlId the primary key of the url
	 * @return the url
	 * @throws hu.vilmospapp.urlshrinker.NoSuchUrlException if a url with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Url findByPrimaryKey(long urlId)
		throws NoSuchUrlException, SystemException {
		Url url = fetchByPrimaryKey(urlId);

		if (url == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + urlId);
			}

			throw new NoSuchUrlException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				urlId);
		}

		return url;
	}

	/**
	 * Returns the url with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the url
	 * @return the url, or <code>null</code> if a url with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Url fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the url with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param urlId the primary key of the url
	 * @return the url, or <code>null</code> if a url with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Url fetchByPrimaryKey(long urlId) throws SystemException {
		Url url = (Url)EntityCacheUtil.getResult(UrlModelImpl.ENTITY_CACHE_ENABLED,
				UrlImpl.class, urlId);

		if (url == _nullUrl) {
			return null;
		}

		if (url == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				url = (Url)session.get(UrlImpl.class, Long.valueOf(urlId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (url != null) {
					cacheResult(url);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(UrlModelImpl.ENTITY_CACHE_ENABLED,
						UrlImpl.class, urlId, _nullUrl);
				}

				closeSession(session);
			}
		}

		return url;
	}

	/**
	 * Returns all the urls where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching urls
	 * @throws SystemException if a system exception occurred
	 */
	public List<Url> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Url> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
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
	public List<Url> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Url> list = (List<Url>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Url url : list) {
				if (!Validator.equals(uuid, url.getUuid())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_URL_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				list = (List<Url>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public Url findByUuid_First(String uuid, OrderByComparator orderByComparator)
		throws NoSuchUrlException, SystemException {
		Url url = fetchByUuid_First(uuid, orderByComparator);

		if (url != null) {
			return url;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUrlException(msg.toString());
	}

	/**
	 * Returns the first url in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching url, or <code>null</code> if a matching url could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Url fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Url> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Url findByUuid_Last(String uuid, OrderByComparator orderByComparator)
		throws NoSuchUrlException, SystemException {
		Url url = fetchByUuid_Last(uuid, orderByComparator);

		if (url != null) {
			return url;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUrlException(msg.toString());
	}

	/**
	 * Returns the last url in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching url, or <code>null</code> if a matching url could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Url fetchByUuid_Last(String uuid, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUuid(uuid);

		List<Url> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Url[] findByUuid_PrevAndNext(long urlId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchUrlException, SystemException {
		Url url = findByPrimaryKey(urlId);

		Session session = null;

		try {
			session = openSession();

			Url[] array = new UrlImpl[3];

			array[0] = getByUuid_PrevAndNext(session, url, uuid,
					orderByComparator, true);

			array[1] = url;

			array[2] = getByUuid_PrevAndNext(session, url, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Url getByUuid_PrevAndNext(Session session, Url url, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_URL_WHERE);

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else {
			if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (uuid != null) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(url);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Url> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	public Url findByUUID_G(String uuid, long groupId)
		throws NoSuchUrlException, SystemException {
		Url url = fetchByUUID_G(uuid, groupId);

		if (url == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUrlException(msg.toString());
		}

		return url;
	}

	/**
	 * Returns the url where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching url, or <code>null</code> if a matching url could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Url fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
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
	public Url fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Url) {
			Url url = (Url)result;

			if (!Validator.equals(uuid, url.getUuid()) ||
					(groupId != url.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_URL_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_G_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_G_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Url> list = q.list();

				result = list;

				Url url = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					url = list.get(0);

					cacheResult(url);

					if ((url.getUuid() == null) || !url.getUuid().equals(uuid) ||
							(url.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, url);
					}
				}

				return url;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (Url)result;
			}
		}
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
	public Url findByC_G_U(long companyId, long groupId, long userId)
		throws NoSuchUrlException, SystemException {
		Url url = fetchByC_G_U(companyId, groupId, userId);

		if (url == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUrlException(msg.toString());
		}

		return url;
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
	public Url fetchByC_G_U(long companyId, long groupId, long userId)
		throws SystemException {
		return fetchByC_G_U(companyId, groupId, userId, true);
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
	public Url fetchByC_G_U(long companyId, long groupId, long userId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, groupId, userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_G_U,
					finderArgs, this);
		}

		if (result instanceof Url) {
			Url url = (Url)result;

			if ((companyId != url.getCompanyId()) ||
					(groupId != url.getGroupId()) ||
					(userId != url.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_URL_WHERE);

			query.append(_FINDER_COLUMN_C_G_U_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_C_G_U_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(userId);

				List<Url> list = q.list();

				result = list;

				Url url = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_U,
						finderArgs, list);
				}
				else {
					url = list.get(0);

					cacheResult(url);

					if ((url.getCompanyId() != companyId) ||
							(url.getGroupId() != groupId) ||
							(url.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_U,
							finderArgs, url);
					}
				}

				return url;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_U,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (Url)result;
			}
		}
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
	public List<Url> findByC_G_H(long companyId, long groupId, String hash)
		throws SystemException {
		return findByC_G_H(companyId, groupId, hash, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<Url> findByC_G_H(long companyId, long groupId, String hash,
		int start, int end) throws SystemException {
		return findByC_G_H(companyId, groupId, hash, start, end, null);
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
	public List<Url> findByC_G_H(long companyId, long groupId, String hash,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_H;
			finderArgs = new Object[] { companyId, groupId, hash };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_H;
			finderArgs = new Object[] {
					companyId, groupId, hash,
					
					start, end, orderByComparator
				};
		}

		List<Url> list = (List<Url>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Url url : list) {
				if ((companyId != url.getCompanyId()) ||
						(groupId != url.getGroupId()) ||
						!Validator.equals(hash, url.getHash())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_URL_WHERE);

			query.append(_FINDER_COLUMN_C_G_H_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_H_GROUPID_2);

			if (hash == null) {
				query.append(_FINDER_COLUMN_C_G_H_HASH_1);
			}
			else {
				if (hash.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_C_G_H_HASH_3);
				}
				else {
					query.append(_FINDER_COLUMN_C_G_H_HASH_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (hash != null) {
					qPos.add(hash);
				}

				list = (List<Url>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public Url findByC_G_H_First(long companyId, long groupId, String hash,
		OrderByComparator orderByComparator)
		throws NoSuchUrlException, SystemException {
		Url url = fetchByC_G_H_First(companyId, groupId, hash, orderByComparator);

		if (url != null) {
			return url;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", hash=");
		msg.append(hash);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUrlException(msg.toString());
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
	public Url fetchByC_G_H_First(long companyId, long groupId, String hash,
		OrderByComparator orderByComparator) throws SystemException {
		List<Url> list = findByC_G_H(companyId, groupId, hash, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Url findByC_G_H_Last(long companyId, long groupId, String hash,
		OrderByComparator orderByComparator)
		throws NoSuchUrlException, SystemException {
		Url url = fetchByC_G_H_Last(companyId, groupId, hash, orderByComparator);

		if (url != null) {
			return url;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", hash=");
		msg.append(hash);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUrlException(msg.toString());
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
	public Url fetchByC_G_H_Last(long companyId, long groupId, String hash,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_G_H(companyId, groupId, hash);

		List<Url> list = findByC_G_H(companyId, groupId, hash, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Url[] findByC_G_H_PrevAndNext(long urlId, long companyId,
		long groupId, String hash, OrderByComparator orderByComparator)
		throws NoSuchUrlException, SystemException {
		Url url = findByPrimaryKey(urlId);

		Session session = null;

		try {
			session = openSession();

			Url[] array = new UrlImpl[3];

			array[0] = getByC_G_H_PrevAndNext(session, url, companyId, groupId,
					hash, orderByComparator, true);

			array[1] = url;

			array[2] = getByC_G_H_PrevAndNext(session, url, companyId, groupId,
					hash, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Url getByC_G_H_PrevAndNext(Session session, Url url,
		long companyId, long groupId, String hash,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_URL_WHERE);

		query.append(_FINDER_COLUMN_C_G_H_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_H_GROUPID_2);

		if (hash == null) {
			query.append(_FINDER_COLUMN_C_G_H_HASH_1);
		}
		else {
			if (hash.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_G_H_HASH_3);
			}
			else {
				query.append(_FINDER_COLUMN_C_G_H_HASH_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (hash != null) {
			qPos.add(hash);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(url);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Url> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	public List<Url> findByC_G_H_P_P_A(long companyId, long groupId,
		String hash, boolean privateUrl, boolean protectedUrl, boolean archived)
		throws SystemException {
		return findByC_G_H_P_P_A(companyId, groupId, hash, privateUrl,
			protectedUrl, archived, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Url> findByC_G_H_P_P_A(long companyId, long groupId,
		String hash, boolean privateUrl, boolean protectedUrl,
		boolean archived, int start, int end) throws SystemException {
		return findByC_G_H_P_P_A(companyId, groupId, hash, privateUrl,
			protectedUrl, archived, start, end, null);
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
	public List<Url> findByC_G_H_P_P_A(long companyId, long groupId,
		String hash, boolean privateUrl, boolean protectedUrl,
		boolean archived, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_H_P_P_A;
			finderArgs = new Object[] {
					companyId, groupId, hash, privateUrl, protectedUrl, archived
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_H_P_P_A;
			finderArgs = new Object[] {
					companyId, groupId, hash, privateUrl, protectedUrl, archived,
					
					start, end, orderByComparator
				};
		}

		List<Url> list = (List<Url>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Url url : list) {
				if ((companyId != url.getCompanyId()) ||
						(groupId != url.getGroupId()) ||
						!Validator.equals(hash, url.getHash()) ||
						(privateUrl != url.getPrivateUrl()) ||
						(protectedUrl != url.getProtectedUrl()) ||
						(archived != url.getArchived())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(8 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(7);
			}

			query.append(_SQL_SELECT_URL_WHERE);

			query.append(_FINDER_COLUMN_C_G_H_P_P_A_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_H_P_P_A_GROUPID_2);

			if (hash == null) {
				query.append(_FINDER_COLUMN_C_G_H_P_P_A_HASH_1);
			}
			else {
				if (hash.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_C_G_H_P_P_A_HASH_3);
				}
				else {
					query.append(_FINDER_COLUMN_C_G_H_P_P_A_HASH_2);
				}
			}

			query.append(_FINDER_COLUMN_C_G_H_P_P_A_PRIVATEURL_2);

			query.append(_FINDER_COLUMN_C_G_H_P_P_A_PROTECTEDURL_2);

			query.append(_FINDER_COLUMN_C_G_H_P_P_A_ARCHIVED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (hash != null) {
					qPos.add(hash);
				}

				qPos.add(privateUrl);

				qPos.add(protectedUrl);

				qPos.add(archived);

				list = (List<Url>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public Url findByC_G_H_P_P_A_First(long companyId, long groupId,
		String hash, boolean privateUrl, boolean protectedUrl,
		boolean archived, OrderByComparator orderByComparator)
		throws NoSuchUrlException, SystemException {
		Url url = fetchByC_G_H_P_P_A_First(companyId, groupId, hash,
				privateUrl, protectedUrl, archived, orderByComparator);

		if (url != null) {
			return url;
		}

		StringBundler msg = new StringBundler(14);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", hash=");
		msg.append(hash);

		msg.append(", privateUrl=");
		msg.append(privateUrl);

		msg.append(", protectedUrl=");
		msg.append(protectedUrl);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUrlException(msg.toString());
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
	public Url fetchByC_G_H_P_P_A_First(long companyId, long groupId,
		String hash, boolean privateUrl, boolean protectedUrl,
		boolean archived, OrderByComparator orderByComparator)
		throws SystemException {
		List<Url> list = findByC_G_H_P_P_A(companyId, groupId, hash,
				privateUrl, protectedUrl, archived, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Url findByC_G_H_P_P_A_Last(long companyId, long groupId,
		String hash, boolean privateUrl, boolean protectedUrl,
		boolean archived, OrderByComparator orderByComparator)
		throws NoSuchUrlException, SystemException {
		Url url = fetchByC_G_H_P_P_A_Last(companyId, groupId, hash, privateUrl,
				protectedUrl, archived, orderByComparator);

		if (url != null) {
			return url;
		}

		StringBundler msg = new StringBundler(14);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", hash=");
		msg.append(hash);

		msg.append(", privateUrl=");
		msg.append(privateUrl);

		msg.append(", protectedUrl=");
		msg.append(protectedUrl);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUrlException(msg.toString());
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
	public Url fetchByC_G_H_P_P_A_Last(long companyId, long groupId,
		String hash, boolean privateUrl, boolean protectedUrl,
		boolean archived, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByC_G_H_P_P_A(companyId, groupId, hash, privateUrl,
				protectedUrl, archived);

		List<Url> list = findByC_G_H_P_P_A(companyId, groupId, hash,
				privateUrl, protectedUrl, archived, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Url[] findByC_G_H_P_P_A_PrevAndNext(long urlId, long companyId,
		long groupId, String hash, boolean privateUrl, boolean protectedUrl,
		boolean archived, OrderByComparator orderByComparator)
		throws NoSuchUrlException, SystemException {
		Url url = findByPrimaryKey(urlId);

		Session session = null;

		try {
			session = openSession();

			Url[] array = new UrlImpl[3];

			array[0] = getByC_G_H_P_P_A_PrevAndNext(session, url, companyId,
					groupId, hash, privateUrl, protectedUrl, archived,
					orderByComparator, true);

			array[1] = url;

			array[2] = getByC_G_H_P_P_A_PrevAndNext(session, url, companyId,
					groupId, hash, privateUrl, protectedUrl, archived,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Url getByC_G_H_P_P_A_PrevAndNext(Session session, Url url,
		long companyId, long groupId, String hash, boolean privateUrl,
		boolean protectedUrl, boolean archived,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_URL_WHERE);

		query.append(_FINDER_COLUMN_C_G_H_P_P_A_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_H_P_P_A_GROUPID_2);

		if (hash == null) {
			query.append(_FINDER_COLUMN_C_G_H_P_P_A_HASH_1);
		}
		else {
			if (hash.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_G_H_P_P_A_HASH_3);
			}
			else {
				query.append(_FINDER_COLUMN_C_G_H_P_P_A_HASH_2);
			}
		}

		query.append(_FINDER_COLUMN_C_G_H_P_P_A_PRIVATEURL_2);

		query.append(_FINDER_COLUMN_C_G_H_P_P_A_PROTECTEDURL_2);

		query.append(_FINDER_COLUMN_C_G_H_P_P_A_ARCHIVED_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (hash != null) {
			qPos.add(hash);
		}

		qPos.add(privateUrl);

		qPos.add(protectedUrl);

		qPos.add(archived);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(url);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Url> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	public List<Url> findByC_G_H_P_P(long companyId, long groupId, String hash,
		boolean privateUrl, boolean protectedUrl) throws SystemException {
		return findByC_G_H_P_P(companyId, groupId, hash, privateUrl,
			protectedUrl, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Url> findByC_G_H_P_P(long companyId, long groupId, String hash,
		boolean privateUrl, boolean protectedUrl, int start, int end)
		throws SystemException {
		return findByC_G_H_P_P(companyId, groupId, hash, privateUrl,
			protectedUrl, start, end, null);
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
	public List<Url> findByC_G_H_P_P(long companyId, long groupId, String hash,
		boolean privateUrl, boolean protectedUrl, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_H_P_P;
			finderArgs = new Object[] {
					companyId, groupId, hash, privateUrl, protectedUrl
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_H_P_P;
			finderArgs = new Object[] {
					companyId, groupId, hash, privateUrl, protectedUrl,
					
					start, end, orderByComparator
				};
		}

		List<Url> list = (List<Url>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Url url : list) {
				if ((companyId != url.getCompanyId()) ||
						(groupId != url.getGroupId()) ||
						!Validator.equals(hash, url.getHash()) ||
						(privateUrl != url.getPrivateUrl()) ||
						(protectedUrl != url.getProtectedUrl())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(7 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_URL_WHERE);

			query.append(_FINDER_COLUMN_C_G_H_P_P_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_H_P_P_GROUPID_2);

			if (hash == null) {
				query.append(_FINDER_COLUMN_C_G_H_P_P_HASH_1);
			}
			else {
				if (hash.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_C_G_H_P_P_HASH_3);
				}
				else {
					query.append(_FINDER_COLUMN_C_G_H_P_P_HASH_2);
				}
			}

			query.append(_FINDER_COLUMN_C_G_H_P_P_PRIVATEURL_2);

			query.append(_FINDER_COLUMN_C_G_H_P_P_PROTECTEDURL_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (hash != null) {
					qPos.add(hash);
				}

				qPos.add(privateUrl);

				qPos.add(protectedUrl);

				list = (List<Url>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public Url findByC_G_H_P_P_First(long companyId, long groupId, String hash,
		boolean privateUrl, boolean protectedUrl,
		OrderByComparator orderByComparator)
		throws NoSuchUrlException, SystemException {
		Url url = fetchByC_G_H_P_P_First(companyId, groupId, hash, privateUrl,
				protectedUrl, orderByComparator);

		if (url != null) {
			return url;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", hash=");
		msg.append(hash);

		msg.append(", privateUrl=");
		msg.append(privateUrl);

		msg.append(", protectedUrl=");
		msg.append(protectedUrl);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUrlException(msg.toString());
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
	public Url fetchByC_G_H_P_P_First(long companyId, long groupId,
		String hash, boolean privateUrl, boolean protectedUrl,
		OrderByComparator orderByComparator) throws SystemException {
		List<Url> list = findByC_G_H_P_P(companyId, groupId, hash, privateUrl,
				protectedUrl, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Url findByC_G_H_P_P_Last(long companyId, long groupId, String hash,
		boolean privateUrl, boolean protectedUrl,
		OrderByComparator orderByComparator)
		throws NoSuchUrlException, SystemException {
		Url url = fetchByC_G_H_P_P_Last(companyId, groupId, hash, privateUrl,
				protectedUrl, orderByComparator);

		if (url != null) {
			return url;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", hash=");
		msg.append(hash);

		msg.append(", privateUrl=");
		msg.append(privateUrl);

		msg.append(", protectedUrl=");
		msg.append(protectedUrl);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUrlException(msg.toString());
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
	public Url fetchByC_G_H_P_P_Last(long companyId, long groupId, String hash,
		boolean privateUrl, boolean protectedUrl,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_G_H_P_P(companyId, groupId, hash, privateUrl,
				protectedUrl);

		List<Url> list = findByC_G_H_P_P(companyId, groupId, hash, privateUrl,
				protectedUrl, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Url[] findByC_G_H_P_P_PrevAndNext(long urlId, long companyId,
		long groupId, String hash, boolean privateUrl, boolean protectedUrl,
		OrderByComparator orderByComparator)
		throws NoSuchUrlException, SystemException {
		Url url = findByPrimaryKey(urlId);

		Session session = null;

		try {
			session = openSession();

			Url[] array = new UrlImpl[3];

			array[0] = getByC_G_H_P_P_PrevAndNext(session, url, companyId,
					groupId, hash, privateUrl, protectedUrl, orderByComparator,
					true);

			array[1] = url;

			array[2] = getByC_G_H_P_P_PrevAndNext(session, url, companyId,
					groupId, hash, privateUrl, protectedUrl, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Url getByC_G_H_P_P_PrevAndNext(Session session, Url url,
		long companyId, long groupId, String hash, boolean privateUrl,
		boolean protectedUrl, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_URL_WHERE);

		query.append(_FINDER_COLUMN_C_G_H_P_P_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_H_P_P_GROUPID_2);

		if (hash == null) {
			query.append(_FINDER_COLUMN_C_G_H_P_P_HASH_1);
		}
		else {
			if (hash.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_G_H_P_P_HASH_3);
			}
			else {
				query.append(_FINDER_COLUMN_C_G_H_P_P_HASH_2);
			}
		}

		query.append(_FINDER_COLUMN_C_G_H_P_P_PRIVATEURL_2);

		query.append(_FINDER_COLUMN_C_G_H_P_P_PROTECTEDURL_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (hash != null) {
			qPos.add(hash);
		}

		qPos.add(privateUrl);

		qPos.add(protectedUrl);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(url);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Url> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	public Url findByC_G_H_Private_A(long companyId, long groupId, String hash,
		boolean privateUrl, boolean archived)
		throws NoSuchUrlException, SystemException {
		Url url = fetchByC_G_H_Private_A(companyId, groupId, hash, privateUrl,
				archived);

		if (url == null) {
			StringBundler msg = new StringBundler(12);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", hash=");
			msg.append(hash);

			msg.append(", privateUrl=");
			msg.append(privateUrl);

			msg.append(", archived=");
			msg.append(archived);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUrlException(msg.toString());
		}

		return url;
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
	public Url fetchByC_G_H_Private_A(long companyId, long groupId,
		String hash, boolean privateUrl, boolean archived)
		throws SystemException {
		return fetchByC_G_H_Private_A(companyId, groupId, hash, privateUrl,
			archived, true);
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
	public Url fetchByC_G_H_Private_A(long companyId, long groupId,
		String hash, boolean privateUrl, boolean archived,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, hash, privateUrl, archived
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_G_H_PRIVATE_A,
					finderArgs, this);
		}

		if (result instanceof Url) {
			Url url = (Url)result;

			if ((companyId != url.getCompanyId()) ||
					(groupId != url.getGroupId()) ||
					!Validator.equals(hash, url.getHash()) ||
					(privateUrl != url.getPrivateUrl()) ||
					(archived != url.getArchived())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_SELECT_URL_WHERE);

			query.append(_FINDER_COLUMN_C_G_H_PRIVATE_A_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_H_PRIVATE_A_GROUPID_2);

			if (hash == null) {
				query.append(_FINDER_COLUMN_C_G_H_PRIVATE_A_HASH_1);
			}
			else {
				if (hash.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_C_G_H_PRIVATE_A_HASH_3);
				}
				else {
					query.append(_FINDER_COLUMN_C_G_H_PRIVATE_A_HASH_2);
				}
			}

			query.append(_FINDER_COLUMN_C_G_H_PRIVATE_A_PRIVATEURL_2);

			query.append(_FINDER_COLUMN_C_G_H_PRIVATE_A_ARCHIVED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (hash != null) {
					qPos.add(hash);
				}

				qPos.add(privateUrl);

				qPos.add(archived);

				List<Url> list = q.list();

				result = list;

				Url url = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_H_PRIVATE_A,
						finderArgs, list);
				}
				else {
					url = list.get(0);

					cacheResult(url);

					if ((url.getCompanyId() != companyId) ||
							(url.getGroupId() != groupId) ||
							(url.getHash() == null) ||
							!url.getHash().equals(hash) ||
							(url.getPrivateUrl() != privateUrl) ||
							(url.getArchived() != archived)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_H_PRIVATE_A,
							finderArgs, url);
					}
				}

				return url;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_H_PRIVATE_A,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (Url)result;
			}
		}
	}

	/**
	 * Returns all the urls.
	 *
	 * @return the urls
	 * @throws SystemException if a system exception occurred
	 */
	public List<Url> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Url> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	public List<Url> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Url> list = (List<Url>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_URL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_URL;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Url>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Url>)QueryUtil.list(q, getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the urls where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (Url url : findByUuid(uuid)) {
			remove(url);
		}
	}

	/**
	 * Removes the url where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the url that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public Url removeByUUID_G(String uuid, long groupId)
		throws NoSuchUrlException, SystemException {
		Url url = findByUUID_G(uuid, groupId);

		return remove(url);
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
	public Url removeByC_G_U(long companyId, long groupId, long userId)
		throws NoSuchUrlException, SystemException {
		Url url = findByC_G_U(companyId, groupId, userId);

		return remove(url);
	}

	/**
	 * Removes all the urls where companyId = &#63; and groupId = &#63; and hash = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param hash the hash
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByC_G_H(long companyId, long groupId, String hash)
		throws SystemException {
		for (Url url : findByC_G_H(companyId, groupId, hash)) {
			remove(url);
		}
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
	public void removeByC_G_H_P_P_A(long companyId, long groupId, String hash,
		boolean privateUrl, boolean protectedUrl, boolean archived)
		throws SystemException {
		for (Url url : findByC_G_H_P_P_A(companyId, groupId, hash, privateUrl,
				protectedUrl, archived)) {
			remove(url);
		}
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
	public void removeByC_G_H_P_P(long companyId, long groupId, String hash,
		boolean privateUrl, boolean protectedUrl) throws SystemException {
		for (Url url : findByC_G_H_P_P(companyId, groupId, hash, privateUrl,
				protectedUrl)) {
			remove(url);
		}
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
	public Url removeByC_G_H_Private_A(long companyId, long groupId,
		String hash, boolean privateUrl, boolean archived)
		throws NoSuchUrlException, SystemException {
		Url url = findByC_G_H_Private_A(companyId, groupId, hash, privateUrl,
				archived);

		return remove(url);
	}

	/**
	 * Removes all the urls from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Url url : findAll()) {
			remove(url);
		}
	}

	/**
	 * Returns the number of urls where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching urls
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_URL_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of urls where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching urls
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_URL_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_G_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_G_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
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
	public int countByC_G_U(long companyId, long groupId, long userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, groupId, userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_G_U,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_URL_WHERE);

			query.append(_FINDER_COLUMN_C_G_U_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_C_G_U_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_G_U,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
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
	public int countByC_G_H(long companyId, long groupId, String hash)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, groupId, hash };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_G_H,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_URL_WHERE);

			query.append(_FINDER_COLUMN_C_G_H_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_H_GROUPID_2);

			if (hash == null) {
				query.append(_FINDER_COLUMN_C_G_H_HASH_1);
			}
			else {
				if (hash.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_C_G_H_HASH_3);
				}
				else {
					query.append(_FINDER_COLUMN_C_G_H_HASH_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (hash != null) {
					qPos.add(hash);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_G_H,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
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
	public int countByC_G_H_P_P_A(long companyId, long groupId, String hash,
		boolean privateUrl, boolean protectedUrl, boolean archived)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, hash, privateUrl, protectedUrl, archived
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_G_H_P_P_A,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(7);

			query.append(_SQL_COUNT_URL_WHERE);

			query.append(_FINDER_COLUMN_C_G_H_P_P_A_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_H_P_P_A_GROUPID_2);

			if (hash == null) {
				query.append(_FINDER_COLUMN_C_G_H_P_P_A_HASH_1);
			}
			else {
				if (hash.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_C_G_H_P_P_A_HASH_3);
				}
				else {
					query.append(_FINDER_COLUMN_C_G_H_P_P_A_HASH_2);
				}
			}

			query.append(_FINDER_COLUMN_C_G_H_P_P_A_PRIVATEURL_2);

			query.append(_FINDER_COLUMN_C_G_H_P_P_A_PROTECTEDURL_2);

			query.append(_FINDER_COLUMN_C_G_H_P_P_A_ARCHIVED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (hash != null) {
					qPos.add(hash);
				}

				qPos.add(privateUrl);

				qPos.add(protectedUrl);

				qPos.add(archived);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_G_H_P_P_A,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
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
	public int countByC_G_H_P_P(long companyId, long groupId, String hash,
		boolean privateUrl, boolean protectedUrl) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, hash, privateUrl, protectedUrl
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_G_H_P_P,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_URL_WHERE);

			query.append(_FINDER_COLUMN_C_G_H_P_P_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_H_P_P_GROUPID_2);

			if (hash == null) {
				query.append(_FINDER_COLUMN_C_G_H_P_P_HASH_1);
			}
			else {
				if (hash.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_C_G_H_P_P_HASH_3);
				}
				else {
					query.append(_FINDER_COLUMN_C_G_H_P_P_HASH_2);
				}
			}

			query.append(_FINDER_COLUMN_C_G_H_P_P_PRIVATEURL_2);

			query.append(_FINDER_COLUMN_C_G_H_P_P_PROTECTEDURL_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (hash != null) {
					qPos.add(hash);
				}

				qPos.add(privateUrl);

				qPos.add(protectedUrl);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_G_H_P_P,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
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
	public int countByC_G_H_Private_A(long companyId, long groupId,
		String hash, boolean privateUrl, boolean archived)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, groupId, hash, privateUrl, archived
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_G_H_PRIVATE_A,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_URL_WHERE);

			query.append(_FINDER_COLUMN_C_G_H_PRIVATE_A_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_H_PRIVATE_A_GROUPID_2);

			if (hash == null) {
				query.append(_FINDER_COLUMN_C_G_H_PRIVATE_A_HASH_1);
			}
			else {
				if (hash.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_C_G_H_PRIVATE_A_HASH_3);
				}
				else {
					query.append(_FINDER_COLUMN_C_G_H_PRIVATE_A_HASH_2);
				}
			}

			query.append(_FINDER_COLUMN_C_G_H_PRIVATE_A_PRIVATEURL_2);

			query.append(_FINDER_COLUMN_C_G_H_PRIVATE_A_ARCHIVED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (hash != null) {
					qPos.add(hash);
				}

				qPos.add(privateUrl);

				qPos.add(archived);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_G_H_PRIVATE_A,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of urls.
	 *
	 * @return the number of urls
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_URL);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the url persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.hu.vilmospapp.urlshrinker.model.Url")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Url>> listenersList = new ArrayList<ModelListener<Url>>();

				for (String listenerClassName : listenerClassNames) {
					Class<?> clazz = getClass();

					listenersList.add((ModelListener<Url>)InstanceFactory.newInstance(
							clazz.getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(UrlImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = UrlPersistence.class)
	protected UrlPersistence urlPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_URL = "SELECT url FROM Url url";
	private static final String _SQL_SELECT_URL_WHERE = "SELECT url FROM Url url WHERE ";
	private static final String _SQL_COUNT_URL = "SELECT COUNT(url) FROM Url url";
	private static final String _SQL_COUNT_URL_WHERE = "SELECT COUNT(url) FROM Url url WHERE ";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "url.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "url.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(url.uuid IS NULL OR url.uuid = ?)";
	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "url.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "url.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(url.uuid IS NULL OR url.uuid = ?) AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "url.groupId = ?";
	private static final String _FINDER_COLUMN_C_G_U_COMPANYID_2 = "url.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_U_GROUPID_2 = "url.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_U_USERID_2 = "url.userId = ?";
	private static final String _FINDER_COLUMN_C_G_H_COMPANYID_2 = "url.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_H_GROUPID_2 = "url.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_H_HASH_1 = "url.hash IS NULL";
	private static final String _FINDER_COLUMN_C_G_H_HASH_2 = "url.hash = ?";
	private static final String _FINDER_COLUMN_C_G_H_HASH_3 = "(url.hash IS NULL OR url.hash = ?)";
	private static final String _FINDER_COLUMN_C_G_H_P_P_A_COMPANYID_2 = "url.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_H_P_P_A_GROUPID_2 = "url.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_H_P_P_A_HASH_1 = "url.hash IS NULL AND ";
	private static final String _FINDER_COLUMN_C_G_H_P_P_A_HASH_2 = "url.hash = ? AND ";
	private static final String _FINDER_COLUMN_C_G_H_P_P_A_HASH_3 = "(url.hash IS NULL OR url.hash = ?) AND ";
	private static final String _FINDER_COLUMN_C_G_H_P_P_A_PRIVATEURL_2 = "url.privateUrl = ? AND ";
	private static final String _FINDER_COLUMN_C_G_H_P_P_A_PROTECTEDURL_2 = "url.protectedUrl = ? AND ";
	private static final String _FINDER_COLUMN_C_G_H_P_P_A_ARCHIVED_2 = "url.archived = ?";
	private static final String _FINDER_COLUMN_C_G_H_P_P_COMPANYID_2 = "url.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_H_P_P_GROUPID_2 = "url.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_H_P_P_HASH_1 = "url.hash IS NULL AND ";
	private static final String _FINDER_COLUMN_C_G_H_P_P_HASH_2 = "url.hash = ? AND ";
	private static final String _FINDER_COLUMN_C_G_H_P_P_HASH_3 = "(url.hash IS NULL OR url.hash = ?) AND ";
	private static final String _FINDER_COLUMN_C_G_H_P_P_PRIVATEURL_2 = "url.privateUrl = ? AND ";
	private static final String _FINDER_COLUMN_C_G_H_P_P_PROTECTEDURL_2 = "url.protectedUrl = ?";
	private static final String _FINDER_COLUMN_C_G_H_PRIVATE_A_COMPANYID_2 = "url.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_H_PRIVATE_A_GROUPID_2 = "url.groupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_H_PRIVATE_A_HASH_1 = "url.hash IS NULL AND ";
	private static final String _FINDER_COLUMN_C_G_H_PRIVATE_A_HASH_2 = "url.hash = ? AND ";
	private static final String _FINDER_COLUMN_C_G_H_PRIVATE_A_HASH_3 = "(url.hash IS NULL OR url.hash = ?) AND ";
	private static final String _FINDER_COLUMN_C_G_H_PRIVATE_A_PRIVATEURL_2 = "url.privateUrl = ? AND ";
	private static final String _FINDER_COLUMN_C_G_H_PRIVATE_A_ARCHIVED_2 = "url.archived = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "url.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Url exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Url exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UrlPersistenceImpl.class);
	private static Url _nullUrl = new UrlImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Url> toCacheModel() {
				return _nullUrlCacheModel;
			}
		};

	private static CacheModel<Url> _nullUrlCacheModel = new CacheModel<Url>() {
			public Url toEntityModel() {
				return _nullUrl;
			}
		};
}