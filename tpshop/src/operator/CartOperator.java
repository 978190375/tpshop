package operator;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import shiti.Cart;
import shiti.Good;

public class CartOperator {
	public static SessionFactory sessionFactory;
	static {
		Configuration config=new Configuration().configure();
		sessionFactory=config.buildSessionFactory();
	}
	
	public void saveCart(Cart cart) {
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(cart);
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

	public void deleteCart(Cart cart) {
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.delete(cart);
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
	public List getCartByUser(int user_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		List cart=null;
		try {
			tx=session.beginTransaction();
			cart=session.createQuery("from Cart as c where c.user.id="+user_id).list();
			tx.commit();
		}catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return cart;		
	}
	public Cart getCartByUserAndGood(int user_id,int good_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		Cart cart=null;
		try {
			tx=session.beginTransaction();
			cart=(Cart)session.createQuery("from Cart as c where c.user.id="+user_id+" and c.good.id="+good_id).setMaxResults(1).uniqueResult();
			tx.commit();
		}catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return cart;		
	}
	public void updateCart(Cart cart) {
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.update(cart);
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
	public Cart getCartById(int cart_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		Cart cart=null;
		try {
			tx=session.beginTransaction();
			cart=(Cart)session.get(Cart.class, cart_id);
			tx.commit();
		}catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return cart;
	}

}
