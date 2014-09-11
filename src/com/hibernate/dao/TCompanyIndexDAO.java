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
import com.hibernate.entity.TCompanyIndex;

/**
 * A data access object (DAO) providing persistence and search support for
 * TCompanyIndex entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.hibernate.entity.TCompanyIndex
 * @author MyEclipse Persistence Tools
 */

public class TCompanyIndexDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TCompanyIndexDAO.class);
	// property constants
	public static final String INDEX_VALUE = "indexValue";

	public void save(TCompanyIndex transientInstance) {
		log.debug("saving TCompanyIndex instance");
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

	public void delete(TCompanyIndex persistentInstance) {
		log.debug("deleting TCompanyIndex instance");
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
	
	public void update(TCompanyIndex persistentInstance) {
		log.debug("updating TCompanyIndex instance");
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
		return getSession().createCriteria(TCompanyIndex.class);
	}
	
	public List findByCriteria(Criteria criteria) {
		log.debug("finding TCompanyIndex instance by criteria");	
		
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

	public TCompanyIndex findById(com.hibernate.entity.TCompanyIndexId id) {
		log.debug("getting TCompanyIndex instance with id: " + id);
		try {
			TCompanyIndex instance = (TCompanyIndex) getSession().get(
					"com.hibernate.entity.TCompanyIndex", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TCompanyIndex instance) {
		log.debug("finding TCompanyIndex instance by example");
		try {
			List results = getSession().createCriteria(
					"com.hibernate.entity.TCompanyIndex").add(
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
		log.debug("finding TCompanyIndex instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TCompanyIndex as model where model."
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
		log.debug("finding all TCompanyIndex instances");
		try {
			String queryString = "from TCompanyIndex";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TCompanyIndex merge(TCompanyIndex detachedInstance) {
		log.debug("merging TCompanyIndex instance");
		try {
			TCompanyIndex result = (TCompanyIndex) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TCompanyIndex instance) {
		log.debug("attaching dirty TCompanyIndex instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TCompanyIndex instance) {
		log.debug("attaching clean TCompanyIndex instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}