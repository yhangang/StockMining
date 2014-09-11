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
import com.hibernate.entity.TIndustryIndexAverage;

/**
 * A data access object (DAO) providing persistence and search support for
 * TIndustryIndexAverage entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.hibernate.entity.TIndustryIndexAverage
 * @author MyEclipse Persistence Tools
 */

public class TIndustryIndexAverageDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory
			.getLog(TIndustryIndexAverageDAO.class);
	// property constants
	public static final String INDEX_VALUE = "indexValue";

	public void save(TIndustryIndexAverage transientInstance) {
		log.debug("saving TIndustryIndexAverage instance");
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

	public void delete(TIndustryIndexAverage persistentInstance) {
		log.debug("deleting TIndustryIndexAverage instance");
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
	public void update(TIndustryIndexAverage persistentInstance) {
		log.debug("updating TIndustryIndexAverage instance");
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
		return getSession().createCriteria(TIndustryIndexAverage.class);
	}
	
	public List findByCriteria(Criteria criteria) {
		log.debug("finding TIndustryIndexAverage instance by criteria");	
		
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
	public TIndustryIndexAverage findById(
			com.hibernate.entity.TIndustryIndexAverageId id) {
		log.debug("getting TIndustryIndexAverage instance with id: " + id);
		try {
			TIndustryIndexAverage instance = (TIndustryIndexAverage) getSession()
					.get("com.hibernate.entity.TIndustryIndexAverage", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TIndustryIndexAverage instance) {
		log.debug("finding TIndustryIndexAverage instance by example");
		try {
			List results = getSession().createCriteria(
					"com.hibernate.entity.TIndustryIndexAverage").add(
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
		log.debug("finding TIndustryIndexAverage instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TIndustryIndexAverage as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByIndexValue(Object indexValue) {
		return findByProperty(INDEX_VALUE, indexValue);
	}

	public List findAll() {
		log.debug("finding all TIndustryIndexAverage instances");
		try {
			String queryString = "from TIndustryIndexAverage";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TIndustryIndexAverage merge(TIndustryIndexAverage detachedInstance) {
		log.debug("merging TIndustryIndexAverage instance");
		try {
			TIndustryIndexAverage result = (TIndustryIndexAverage) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TIndustryIndexAverage instance) {
		log.debug("attaching dirty TIndustryIndexAverage instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TIndustryIndexAverage instance) {
		log.debug("attaching clean TIndustryIndexAverage instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}