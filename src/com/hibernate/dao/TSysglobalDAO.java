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
import com.hibernate.entity.TSysglobal;

/**
 * A data access object (DAO) providing persistence and search support for
 * TSysglobal entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.hibernate.entity.TSysglobal
 * @author MyEclipse Persistence Tools
 */

public class TSysglobalDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TSysglobalDAO.class);

	// property constants

	public void save(TSysglobal transientInstance) {
		log.debug("saving TSysglobal instance");
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

	public void delete(TSysglobal persistentInstance) {
		log.debug("deleting TSysglobal instance");
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
	
	public void update(TSysglobal persistentInstance) {
		log.debug("updating TSysglobal instance");
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
		return getSession().createCriteria(TSysglobal.class);
	}
	
	public List findByCriteria(Criteria criteria) {
		log.debug("finding TSysglobal instance by criteria");	
		
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

	public TSysglobal findById(com.hibernate.entity.TSysglobalId id) {
		log.debug("getting TSysglobal instance with id: " + id);
		try {
			TSysglobal instance = (TSysglobal) getSession().get(
					"com.hibernate.entity.TSysglobal", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TSysglobal instance) {
		log.debug("finding TSysglobal instance by example");
		try {
			List results = getSession().createCriteria(
					"com.hibernate.entity.TSysglobal").add(
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
		log.debug("finding TSysglobal instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TSysglobal as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TSysglobal instances");
		try {
			String queryString = "from TSysglobal";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TSysglobal merge(TSysglobal detachedInstance) {
		log.debug("merging TSysglobal instance");
		try {
			TSysglobal result = (TSysglobal) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TSysglobal instance) {
		log.debug("attaching dirty TSysglobal instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TSysglobal instance) {
		log.debug("attaching clean TSysglobal instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}