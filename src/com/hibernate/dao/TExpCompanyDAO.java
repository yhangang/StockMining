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
import com.hibernate.entity.TExpCompany;

/**
 * A data access object (DAO) providing persistence and search support for
 * TExpCompany entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.hibernate.entity.TExpCompany
 * @author MyEclipse Persistence Tools
 */

public class TExpCompanyDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TExpCompanyDAO.class);

	// property constants

	public void save(TExpCompany transientInstance) {
		log.debug("saving TExpCompany instance");
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

	public void delete(TExpCompany persistentInstance) {
		log.debug("deleting TExpCompany instance");
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
	
	public void update(TExpCompany persistentInstance) {
		log.debug("updating TExpCompany instance");
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
		return getSession().createCriteria(TExpCompany.class);
	}
	
	public List findByCriteria(Criteria criteria) {
		log.debug("finding TExpCompany instance by criteria");	
		
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

	public TExpCompany findById(com.hibernate.entity.TExpCompanyId id) {
		log.debug("getting TExpCompany instance with id: " + id);
		try {
			TExpCompany instance = (TExpCompany) getSession().get(
					"com.hibernate.entity.TExpCompany", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TExpCompany instance) {
		log.debug("finding TExpCompany instance by example");
		try {
			List results = getSession().createCriteria(
					"com.hibernate.entity.TExpCompany").add(
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
		log.debug("finding TExpCompany instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TExpCompany as model where model."
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
		log.debug("finding all TExpCompany instances");
		try {
			String queryString = "from TExpCompany";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TExpCompany merge(TExpCompany detachedInstance) {
		log.debug("merging TExpCompany instance");
		try {
			TExpCompany result = (TExpCompany) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TExpCompany instance) {
		log.debug("attaching dirty TExpCompany instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TExpCompany instance) {
		log.debug("attaching clean TExpCompany instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}