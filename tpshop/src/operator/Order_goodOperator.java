package operator;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import shiti.Order_good;

public class Order_goodOperator {
	public static SessionFactory sessionFactory;
	static {
		Configuration config=new Configuration().configure();
		sessionFactory=config.buildSessionFactory();
	}
	public void saveOrder_good(Order_good order_good) {
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(order_good);
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
	public List getOrder_goodByOrderId(int order_id) {     
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		List order_goods=null;
		try {
			tx=session.beginTransaction();
			order_goods=session.createQuery("from Order_good as og where og.order.id="+order_id).list();
			tx.commit();
		}catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return order_goods;
	}
}
