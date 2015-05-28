package com.park.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.park.model.Reservation;

/**
 * A data access object (DAO) providing persistence and search support for
 * Reservation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.park.dao.Reservation
 * @author MyEclipse Persistence Tools
 */
public class ReservationDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ReservationDAO.class);
	// property constants
	public static final String RNAME = "rname";
	public static final String RTEL = "rtel";
	public static final String SPACE_TYPE = "spaceType";
	public static final String DAYS = "days";

	public void save(Reservation transientInstance) {
		log.debug("saving Reservation instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Reservation persistentInstance) {
		log.debug("deleting Reservation instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Reservation findById(java.sql.Timestamp id) {
		log.debug("getting Reservation instance with id: " + id);
		try {
			Reservation instance = (Reservation) getSession().get(
					"com.park.model.Reservation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Reservation instance) {
		log.debug("finding Reservation instance by example");
		try {
			List results = getSession()
					.createCriteria("com.park.model.Reservation")
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
		log.debug("finding Reservation instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Reservation as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByRname(Object rname) {
		return findByProperty(RNAME, rname);
	}

	public List findByRtel(Object rtel) {
		return findByProperty(RTEL, rtel);
	}

	public List findBySpaceType(Object spaceType) {
		return findByProperty(SPACE_TYPE, spaceType);
	}

	public List findByDays(Object days) {
		return findByProperty(DAYS, days);
	}

	public List findAll() {
		log.debug("finding all Reservation instances");
		try {
			String queryString = "from Reservation";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Reservation merge(Reservation detachedInstance) {
		log.debug("merging Reservation instance");
		try {
			Reservation result = (Reservation) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Reservation instance) {
		log.debug("attaching dirty Reservation instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Reservation instance) {
		log.debug("attaching clean Reservation instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}