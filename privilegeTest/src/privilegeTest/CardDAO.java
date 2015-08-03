package privilegeTest;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Card
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see privilegeTest.Card
 * @author MyEclipse Persistence Tools
 */
public class CardDAO extends BaseHibernateDAO {
    private static final Logger log = LoggerFactory.getLogger(CardDAO.class);

    private Session session = null;

    
    void closeSession(Session session){
	if (session!=null) {
	    session.close();
	}
    }
    public void save(Card transientInstance) {
	log.debug("saving Card instance");
	Session session = null;
	try {
	    session = getSession();
	    Transaction beginTransaction = session.beginTransaction();
	    session.save(transientInstance);
	    beginTransaction.commit();
	    log.debug("save successful");
	} catch (RuntimeException re) {
	    log.error("save failed", re);
	    throw re;
	} finally {
	    closeSession(session);
	}
    }

    public void delete(Card persistentInstance) {
	log.debug("deleting Card instance");
	Session session = null;
	try {
	    session = getSession();
	    Transaction beginTransaction = session.beginTransaction();

	    session.delete(persistentInstance);
	    beginTransaction.commit();
	    
	    log.debug("delete successful");
	} catch (RuntimeException re) {
	    log.error("delete failed", re);
	    throw re;
	}finally{
	    closeSession(session);
	}
    }

    public Card findById(java.lang.Long id) {
	log.debug("getting Card instance with id: " + id);
	Session session = null;
	try {
	    session=getSession();
	    Card instance = (Card) session.get("privilegeTest.Card", id);
	    return instance;
	} catch (RuntimeException re) {
	    log.error("get failed", re);
	    throw re;
	} finally {
	    closeSession(session);
	}
    }

    public List<Card> findByExample(Card instance) {
	log.debug("finding Card instance by example");
	Session session = null;
	try {
	    session = getSession();
	    List<Card> results = (List<Card>) session
		    .createCriteria("privilegeTest.Card").add(create(instance))
		    .list();
	    log.debug("find by example successful, result size: "
		    + results.size());
	    return results;
	} catch (RuntimeException re) {
	    log.error("find by example failed", re);
	    throw re;
	}finally{
	    closeSession(session);
	}
    }

    public List findByProperty(String propertyName, Object value) {
	log.debug("finding Card instance with property: " + propertyName
		+ ", value: " + value);
	Session session = null;
	try {
	    session = getSession();
	    String queryString = "from Card as model where model."
		    + propertyName + "= ?";
	    Query queryObject = session.createQuery(queryString);
	    queryObject.setParameter(0, value);
	    return queryObject.list();
	} catch (RuntimeException re) {
	    log.error("find by property name failed", re);
	    throw re;
	}finally{
	    closeSession(session);
	}
    }

    public List<Card> findAll() {
	log.debug("finding all Card instances");
	Session session = null;
	try {
	    session = getSession();
	    String queryString = "from Card";
	    Query queryObject = session.createQuery(queryString);
	    return queryObject.list();
	} catch (RuntimeException re) {
	    log.error("find all failed", re);
	    throw re;
	} finally{
	    closeSession(session);
	}
    }

    public Card merge(Card detachedInstance) {
	log.debug("merging Card instance");
	Session session = null;
	try {
	    session = getSession();
	    Card result = (Card) session.merge(detachedInstance);
	    log.debug("merge successful");
	    return result;
	} catch (RuntimeException re) {
	    log.error("merge failed", re);
	    throw re;
	}finally{
	    closeSession(session);
	}
    }

    public void attachDirty(Card instance) {
	log.debug("attaching dirty Card instance");
	Session session = null;
	try {
	    session = getSession();
	    Transaction beginTransaction = session.beginTransaction();
	    session.saveOrUpdate(instance);
	    log.debug("attach successful");
	    beginTransaction.commit();
	} catch (RuntimeException re) {
	    log.error("attach failed", re);
	    throw re;
	}finally{
	    closeSession(session);
	}
    }

    public void attachClean(Card instance) {
	log.debug("attaching clean Card instance");
	Session session = null;
	try {
	    session = getSession();
	    session.buildLockRequest(LockOptions.NONE).lock(instance);
	    log.debug("attach successful");
	} catch (RuntimeException re) {
	    log.error("attach failed", re);
	    throw re;
	}finally{
	    closeSession(session);
	}
    }

    public void deleteCardAll() {
	Session session = null;
	try {
	    session = getSession();
	    Transaction beginTransaction = session.beginTransaction();
	    System.out.println("delete all");
	    String queryString = "delete from Card";
	    Query queryObject = getSession().createQuery(queryString);
	    queryObject.executeUpdate();
	    beginTransaction.commit();
	} catch (RuntimeException re) {
	    log.error("delete all failed", re);
	    throw re;
	} finally {
	    closeSession(session);
	}

    }
}