package operator;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import shiti.Order;


public class OrderOperator {
	public static SessionFactory sessionFactory;
	static {
		Configuration config=new Configuration().configure();
		sessionFactory=config.buildSessionFactory();
	}
	public List getOrdersByUserId(int first,int size,int user_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		List orders=null;
		try {
			tx=session.beginTransaction();
			Query query=session.createQuery("from Order as o where o.user.id="+user_id);
			query.setFirstResult(first);
			query.setMaxResults(size);
			orders=query.list();
			tx.commit();
		}catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return orders;
	}
	public void saveOrder(Order order) {
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(order);
			tx.commit();
		}catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	public int getOrderCount(int user_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		List orderList=null;
		try {
			tx=session.beginTransaction();
			Query query=session.createQuery("from Order as o where o.user.id="+user_id);
			orderList=query.list();
			tx.commit();
		}catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return orderList.size();
	}
	public Order getOrderById(int id) {
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		Order order=null;
		try {
			tx=session.beginTransaction();
			order=(Order)session.get(Order.class, id);
			tx.commit();
		}catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return order;
	}
}
