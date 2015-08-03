package privilegeTest;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import privilegeTest.MainPresenter.privilegeType;

/**
 * A data access object (DAO) providing persistence and search support for Task
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see privilegeTest.Task
 * @author MyEclipse Persistence Tools
 */
public class TaskDAO extends BaseHibernateDAO {
    private static final Logger log = LoggerFactory.getLogger(TaskDAO.class);

    void closeSession(Session session){
	if (session!=null) {
	    session.close();
	}
    }
    public void save(Task transientInstance) {
	log.debug("saving Task instance");
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
	}finally{
	    closeSession(session);
	}
    }

    public void delete(Task persistentInstance) {
	log.debug("deleting Task instance");
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

    public Task findById(java.lang.Long id) {
	log.debug("getting Task instance with id: " + id);
	Session session = null;
	try {
	    session = getSession();
	    Task instance = (Task) session.get("privilegeTest.Task", id);
	    return instance;
	} catch (RuntimeException re) {
	    log.error("get failed", re);
	    throw re;
	}finally{
	    closeSession(session);
	}
    }

    public List<Task> findByExample(Task instance) {
	log.debug("finding Task instance by example");
	Session session = null;
	try {
	    session = getSession();
	    List<Task> results = (List<Task>) session
		    .createCriteria("privilegeTest.Task").add(create(instance))
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
	log.debug("finding Task instance with property: " + propertyName
		+ ", value: " + value);
	Session session = null;
	try {
	    session = getSession();
	    String queryString = "from Task as model where model."
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

    public List findAll() {
	log.debug("finding all Task instances");
	Session session = null;
	try {
	    session = getSession();
	    String queryString = "from Task";
	    Query queryObject = session.createQuery(queryString);
	    return queryObject.list();
	} catch (RuntimeException re) {
	    log.error("find all failed", re);
	    throw re;
	}finally{
	    closeSession(session);
	}
    }

    public Task merge(Task detachedInstance) {
	log.debug("merging Task instance");
	Session session = null;
	try {
	    session = getSession();
	    Task result = (Task) session.merge(detachedInstance);
	    log.debug("merge successful");
	    return result;
	} catch (RuntimeException re) {
	    log.error("merge failed", re);
	    throw re;
	}finally{
	    closeSession(session);
	}
    }

    public void attachDirty(Task instance) {
	log.debug("attaching dirty Task instance");
	Session session = null;
	try {
	    session = getSession();
	    Transaction beginTransaction = session.beginTransaction();
	    session.saveOrUpdate(instance);
	    beginTransaction.commit();
	    log.debug("attach successful");
	} catch (RuntimeException re) {
	    log.error("attach failed", re);
	    throw re;
	}finally{
	    closeSession(session);
	}
    }

    public void attachClean(Task instance) {
	log.debug("attaching clean Task instance");
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

	public List<Task> findTaskList(String ip, privilegeType waitupload) {
	Session session = null;
	try {
	    session = getSession();
	    Criteria c = session.createCriteria("privilegeTest.Task");
	    c.add(Restrictions.eq("ip", ip));
	    c.add(Restrictions.eq("statustype", waitupload.name()));

	    return c.list();
	} catch (RuntimeException re) {
	    log.error("find by example failed", re);
	    throw re;
	}finally{
	    closeSession(session);
	}
    }

    public void deleteTask(String string) {
	log.debug("deleting Task instance");
	Session session = null;
	try {
	    session = getSession();
	    Query createQuery = session.createQuery("update from Task set statustype='"
		    + privilegeType.waitdelete + "' where ip=" + string);
	    createQuery.executeUpdate();
	    log.debug("delete successful");
	} catch (RuntimeException re) {
	    log.error("delete failed", re);
	    throw re;
	}finally{
	    closeSession(session);
	}

    }
}