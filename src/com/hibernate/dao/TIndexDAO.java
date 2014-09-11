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
import com.hibernate.entity.TIndex;

/**
 * A data access object (DAO) providing persistence and search support for
 * TIndex entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.hibernate.entity.TIndex
 * @author MyEclipse Persistence Tools
 */

public class TIndexDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TIndexDAO.class);
	// property constants
	public static final String INDEX_NAME = "indexName";
	public static final String INDEX_TYPE = "indexType";

	public void save(TIndex transientInstance) {
		log.debug("saving TIndex instance");
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

	public void delete(TIndex persistentInstance) {
		log.debug("deleting TIndex instance");
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
	
	public void update(TIndex persistentInstance) {
		log.debug("updating TIndex instance");
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
		return getSession().createCriteria(TIndex.class);
	}
	
	public List findByCriteria(Criteria criteria) {
		log.debug("finding TIndex instance by criteria");	
		
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
	public TIndex findById(java.lang.String id) {
		log.debug("getting TIndex instance with id: " + id);
		try {
			TIndex instance = (TIndex) getSession().get(
					"com.hibernate.entity.TIndex", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TIndex instance) {
		log.debug("finding TIndex instance by example");
		try {
			List results = getSession().createCriteria(
					"com.hibernate.entity.TIndex")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TIndex instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TIndex as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByIndexName(Object indexName) {
		return findByProperty(INDEX_NAME, indexName);
	}

	public List findByIndexType(Object indexType) {
		return findByProperty(INDEX_TYPE, indexType);
	}

	public List findAll() {
		log.debug("finding all TIndex instances");
		try {
			String queryString = "from TIndex";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TIndex merge(TIndex detachedInstance) {
		log.debug("merging TIndex instance");
		try {
			TIndex result = (TIndex) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TIndex instance) {
		log.debug("attaching dirty TIndex instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TIndex instance) {
		log.debug("attaching clean TIndex instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}