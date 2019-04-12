package operator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Hibernate;
import org.hibernate.Query;

import shiti.User;

public class UserOperator {
	public int id;
	public static SessionFactory sessionFactory;
	static {
		Configuration config = new Configuration().configure();
		sessionFactory = config.buildSessionFactory();
	}
	
	public void saveUser(User u) {  //保存用户
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx=session.beginTransaction();
			session.save(u);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	public void updateUser(User u) {  //保存用户
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx=session.beginTransaction();
			session.update(u);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	public User getUserById(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		User user=null;
		try {
			tx=session.beginTransaction();			
			user=(User)session.get(User.class, id);
			Hibernate.initialize(user.getCarts());
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}
	public User initUser(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		User user=null;
		try {
			tx=session.beginTransaction();			
			user=(User)session.load(User.class, id);
			
			Hibernate.initialize(user.getOrders());
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}
	public boolean register(User u) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean hasUser=true;
		try {
			tx=session.beginTransaction();
			Query query=session.createQuery("from User as u where u.email=:userEmail or u.phone=:userPhone");
			query.setString("userEmail",u.getEmail());
			query.setString("userPhone", u.getPhone());
			
			User user=(User)query.setMaxResults(1).uniqueResult();
			if(user==null) {
				hasUser=false;
				session.save(u);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return hasUser;
	}
	public boolean Login(String email,String password) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean isUser=false;
		try {
			tx=session.beginTransaction();
			Query query=session.createQuery("from User as u where u.email=:userEmail and u.password=:userPassword");
			query.setString("userEmail",email);
			query.setString("userPassword", password);
			
			User u=(User)query.setMaxResults(1).uniqueResult();
			if(u!=null) {
				isUser=true;
				id=u.getId();
			}
			
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isUser;
	}

}
