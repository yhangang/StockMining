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
import com.hibernate.entity.TExpPeriod;

/**
 * A data access object (DAO) providing persistence and search support for
 * TExpPeriod entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.hibernate.entity.TExpPeriod
 * @author MyEclipse Persistence Tools
 */

public class TExpPeriodDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TExpPeriodDAO.class);
	// property constants
	public static final String START_YEAR = "startYear";
	public static final String END_YEAR = "endYear";

	public void save(TExpPeriod transientInstance) {
		log.debug("saving TExpPeriod instance");
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

	public void delete(TExpPeriod persistentInstance) {
		log.debug("deleting TExpPeriod instance");
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
	
	public void update(TExpPeriod persistentInstance) {
		log.debug("updating TExpPeriod instance");
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
	
	public Criteria getCriteria(){
		return getSession().createCriteria(TExpPeriod.class);
	}
	
	public List findByCriteria(Criteria criteria) {
		log.debug("finding TExpPeriod instance by criteria");	
		
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

	public TExpPeriod findById(java.lang.Integer id) {
		log.debug("getting TExpPeriod instance with id: " + id);
		try {
			TExpPeriod instance = (TExpPeriod) getSession().get(
					"com.hibernate.entity.TExpPeriod", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TExpPeriod instance) {
		log.debug("finding TExpPeriod instance by example");
		try {
			List results = getSession().createCriteria(
					"com.hibernate.entity.TExpPeriod").add(
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
		log.debug("finding TExpPeriod instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TExpPeriod as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStartYear(Object startYear) {
		return findByProperty(START_YEAR, startYear);
	}

	public List findByEndYear(Object endYear) {
		return findByProperty(END_YEAR, endYear);
	}

	public List findAll() {
		log.debug("finding all TExpPeriod instances");
		try {
			String queryString = "from TExpPeriod";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TExpPeriod merge(TExpPeriod detachedInstance) {
		log.debug("merging TExpPeriod instance");
		try {
			TExpPeriod result = (TExpPeriod) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TExpPeriod instance) {
		log.debug("attaching dirty TExpPeriod instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TExpPeriod instance) {
		log.debug("attaching clean TExpPeriod instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}