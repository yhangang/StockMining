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
import com.hibernate.entity.TExpIndex;

/**
 * A data access object (DAO) providing persistence and search support for
 * TExpIndex entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.hibernate.entity.TExpIndex
 * @author MyEclipse Persistence Tools
 */

public class TExpIndexDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TExpIndexDAO.class);
	// property constants
	public static final String GUIYUE_DEPTH = "guiyueDepth";
	public static final String WEIGH_DEPTH = "weighDepth";

	public void save(TExpIndex transientInstance) {
		log.debug("saving TExpIndex instance");
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

	public void delete(TExpIndex persistentInstance) {
		log.debug("deleting TExpIndex instance");
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
	
	public void update(TExpIndex persistentInstance) {
		log.debug("updating TExpIndex instance");
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
		return getSession().createCriteria(TExpIndex.class);
	}
	
	public List findByCriteria(Criteria criteria) {
		log.debug("finding TExpIndex instance by criteria");	
		
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
	
	public TExpIndex findById(com.hibernate.entity.TExpIndexId id) {
		log.debug("getting TExpIndex instance with id: " + id);
		try {
			TExpIndex instance = (TExpIndex) getSession().get(
					"com.hibernate.entity.TExpIndex", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TExpIndex instance) {
		log.debug("finding TExpIndex instance by example");
		try {
			List results = getSession().createCriteria(
					"com.hibernate.entity.TExpIndex").add(
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
		log.debug("finding TExpIndex instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TExpIndex as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByGuiyueDepth(Object guiyueDepth) {
		return findByProperty(GUIYUE_DEPTH, guiyueDepth);
	}

	public List findByWeighDepth(Object weighDepth) {
		return findByProperty(WEIGH_DEPTH, weighDepth);
	}

	public List findAll() {
		log.debug("finding all TExpIndex instances");
		try {
			String queryString = "from TExpIndex";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TExpIndex merge(TExpIndex detachedInstance) {
		log.debug("merging TExpIndex instance");
		try {
			TExpIndex result = (TExpIndex) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TExpIndex instance) {
		log.debug("attaching dirty TExpIndex instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TExpIndex instance) {
		log.debug("attaching clean TExpIndex instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}