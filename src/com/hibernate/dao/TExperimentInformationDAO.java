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
import com.hibernate.entity.TExperimentInformation;

/**
 * A data access object (DAO) providing persistence and search support for
 * TExperimentInformation entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.hibernate.entity.TExperimentInformation
 * @author MyEclipse Persistence Tools
 */

public class TExperimentInformationDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory
			.getLog(TExperimentInformationDAO.class);
	// property constants
	public static final String USER_ID = "userId";
	public static final String EXP_NAME = "expName";
	public static final String POWER = "power";

	public void save(TExperimentInformation transientInstance) {
		log.debug("saving TExperimentInformation instance");
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

	public void delete(TExperimentInformation persistentInstance) {
		log.debug("deleting TExperimentInformation instance");
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

	public void update(TExperimentInformation persistentInstance) {
		log.debug("updating TExperimentInformation instance");
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
		return getSession().createCriteria(TExperimentInformation.class);
	}
	
	public List findByCriteria(Criteria criteria) {
		log.debug("finding TExperimentInformation instance by criteria");	
		
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
	
	public TExperimentInformation findById(java.lang.Integer id) {
		log.debug("getting TExperimentInformation instance with id: " + id);
		try {
			TExperimentInformation instance = (TExperimentInformation) getSession()
					.get("com.hibernate.entity.TExperimentInformation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TExperimentInformation instance) {
		log.debug("finding TExperimentInformation instance by example");
		try {
			List results = getSession().createCriteria(
					"com.hibernate.entity.TExperimentInformation").add(
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
		log.debug("finding TExperimentInformation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TExperimentInformation as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List findByExpName(Object expName) {
		return findByProperty(EXP_NAME, expName);
	}

	public List findByPower(Object power) {
		return findByProperty(POWER, power);
	}

	public List findAll() {
		log.debug("finding all TExperimentInformation instances");
		try {
			String queryString = "from TExperimentInformation";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TExperimentInformation merge(TExperimentInformation detachedInstance) {
		log.debug("merging TExperimentInformation instance");
		try {
			TExperimentInformation result = (TExperimentInformation) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TExperimentInformation instance) {
		log.debug("attaching dirty TExperimentInformation instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TExperimentInformation instance) {
		log.debug("attaching clean TExperimentInformation instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}