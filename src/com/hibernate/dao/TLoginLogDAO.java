package com.hibernate.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.hibernate.entity.BaseHibernateDAO;
import com.hibernate.entity.TLoginLog;

/**
 * A data access object (DAO) providing persistence and search support for
 * TLoginLog entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.hibernate.entity.TLoginLog
 * @author MyEclipse Persistence Tools
 */

public class TLoginLogDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TLoginLogDAO.class);
	// property constants
	public static final String USERNAME = "username";
	public static final String REALNAME = "realname";
	public static final String LOGIN_IP = "loginIp";
	public static final String LOGIN_HOST = "loginHost";

	public void save(TLoginLog transientInstance) {
		log.debug("saving TLoginLog instance");
		try {
			Transaction tx = getSession().beginTransaction();
			getSession().save(transientInstance);
			tx.commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TLoginLog persistentInstance) {
		log.debug("deleting TLoginLog instance");
		try {
			Transaction tx = getSession().beginTransaction();
			getSession().delete(persistentInstance);
			tx.commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public void update(TLoginLog persistentInstance) {
		log.debug("updatting TLoginLog instance");
		try {
			Transaction tx = getSession().beginTransaction();
			getSession().update(persistentInstance);
			tx.commit();
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	public Criteria getCriteria() {
		return getSession().createCriteria(TLoginLog.class);
	}

	public List findByCriteria(Criteria criteria) {
		log.debug("finding TUser instance by criteria");

		try {
			List results = criteria.list();
			log.debug("find by criteria successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by criteria failed", re);
			throw re;
		}
	}

	public TLoginLog findById(java.lang.Integer id) {
		log.debug("getting TLoginLog instance with id: " + id);
		try {
			TLoginLog instance = (TLoginLog) getSession().get(
					"com.hibernate.entity.TLoginLog", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TLoginLog instance) {
		log.debug("finding TLoginLog instance by example");
		try {
			List results = getSession().createCriteria(
					"com.hibernate.entity.TLoginLog").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TLoginLog instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TLoginLog as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List findByRealname(Object realname) {
		return findByProperty(REALNAME, realname);
	}

	public List findByLoginIp(Object loginIp) {
		return findByProperty(LOGIN_IP, loginIp);
	}

	public List findByLoginHost(Object loginHost) {
		return findByProperty(LOGIN_HOST, loginHost);
	}

	public List findAll() {
		log.debug("finding all TLoginLog instances");
		try {
			String queryString = "from TLoginLog";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TLoginLog merge(TLoginLog detachedInstance) {
		log.debug("merging TLoginLog instance");
		try {
			TLoginLog result = (TLoginLog) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TLoginLog instance) {
		log.debug("attaching dirty TLoginLog instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TLoginLog instance) {
		log.debug("attaching clean TLoginLog instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}