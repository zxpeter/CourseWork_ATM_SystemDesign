package com.park.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.park.model.Space;

/**
 * A data access object (DAO) providing persistence and search support for Space
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.park.dao.Space
 * @author MyEclipse Persistence Tools
 */
public class SpaceDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(SpaceDAO.class);
	// property constants
	public static final String SPACE_STATE = "spaceState";
	public static final String SPACE_TYPE = "spaceType";
	public static final String SPACE_PRICE = "spacePrice";
	public static final String SPACE_TEL = "spaceTel";

	public void save(Space transientInstance) {
		log.debug("saving Space instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Space persistentInstance) {
		log.debug("deleting Space instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Space findById(java.lang.String id) {
		log.debug("getting Space instance with id: " + id);
		try {
			Space instance = (Space) getSession()
					.get("com.park.model.Space", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Space instance) {
		log.debug("finding Space instance by example");
		try {
			List results = getSession().createCriteria("com.park.model.Space")
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
		log.debug("finding Space instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Space as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySpaceState(Object spaceState) {
		return findByProperty(SPACE_STATE, spaceState);
	}

	public List findBySpaceType(Object spaceType) {
		return findByProperty(SPACE_TYPE, spaceType);
	}

	public List findBySpacePrice(Object spacePrice) {
		return findByProperty(SPACE_PRICE, spacePrice);
	}

	public List findBySpaceTel(Object spaceTel) {
		return findByProperty(SPACE_TEL, spaceTel);
	}

	public List findAll() {
		log.debug("finding all Space instances");
		try {
			String queryString = "from Space";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Space merge(Space detachedInstance) {
		log.debug("merging Space instance");
		try {
			Space result = (Space) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Space instance) {
		log.debug("attaching dirty Space instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Space instance) {
		log.debug("attaching clean Space instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}