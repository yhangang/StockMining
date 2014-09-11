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
import com.hibernate.entity.TCompany;
import com.hibernate.entity.TUser;

/**
 * A data access object (DAO) providing persistence and search support for
 * TCompany entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.hibernate.entity.TCompany
 * @author MyEclipse Persistence Tools
 */

public class TCompanyDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TCompanyDAO.class);
	// property constants
	public static final String STOCK_SHORT_NAME = "stockShortName";
	public static final String COMPANY_NAME = "companyName";
	public static final String AREA = "area";
	public static final String CLASSIFICATION_OF_CSRC = "classificationOfCsrc";
	public static final String CLASSIFICATION_OF_GICS = "classificationOfGics";
	public static final String COMMENTS = "comments";

	public void save(TCompany transientInstance) {
		log.debug("saving TCompany instance");
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

	public void delete(TCompany persistentInstance) {
		log.debug("deleting TCompany instance");
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
	
	public void update(TCompany persistentInstance) {
		log.debug("updating TCompany instance");
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
		return getSession().createCriteria(TCompany.class);
	}
	
	public List findByCriteria(Criteria criteria) {
		log.debug("finding TCompany instance by criteria");	
		
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
	
	public TCompany findById(java.lang.String id) {
		log.debug("getting TCompany instance with id: " + id);
		try {
			TCompany instance = (TCompany) getSession().get(
					"com.hibernate.entity.TCompany", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TCompany instance) {
		log.debug("finding TCompany instance by example");
		try {
			List results = getSession().createCriteria(
					"com.hibernate.entity.TCompany").add(
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
		log.debug("finding TCompany instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TCompany as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStockShortName(Object stockShortName) {
		return findByProperty(STOCK_SHORT_NAME, stockShortName);
	}

	public List findByCompanyName(Object companyName) {
		return findByProperty(COMPANY_NAME, companyName);
	}

	public List findByArea(Object area) {
		return findByProperty(AREA, area);
	}

	public List findByClassificationOfCsrc(Object classificationOfCsrc) {
		return findByProperty(CLASSIFICATION_OF_CSRC, classificationOfCsrc);
	}

	public List findByClassificationOfGics(Object classificationOfGics) {
		return findByProperty(CLASSIFICATION_OF_GICS, classificationOfGics);
	}

	public List findByComments(Object comments) {
		return findByProperty(COMMENTS, comments);
	}

	public List findAll() {
		log.debug("finding all TCompany instances");
		try {
			String queryString = "from TCompany";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TCompany merge(TCompany detachedInstance) {
		log.debug("merging TCompany instance");
		try {
			TCompany result = (TCompany) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TCompany instance) {
		log.debug("attaching dirty TCompany instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TCompany instance) {
		log.debug("attaching clean TCompany instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}