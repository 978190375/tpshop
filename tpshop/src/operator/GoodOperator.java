package operator;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import shiti.Cdkey;
import shiti.Good;

public class GoodOperator {
	public static SessionFactory sessionFactory;
	static {
		Configuration config=new Configuration().configure();
		sessionFactory=config.buildSessionFactory();
	}
	
	public void saveGood(Good good) {
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(good);
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
	

	public void update(Good good) {
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.update(good);
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
	
	public int getGoodCount() {
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		List goods=null;
		try {
			tx=session.beginTransaction();
			goods=session.createQuery("from Good").list();
			tx.commit();
		}catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return goods.size();
	}
	public Good getGood(int id) {
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		Good good=null;
		try {
			tx=session.beginTransaction();
			good=(Good)session.get(Good.class, id);

			 Hibernate.initialize(good.getCdkeys());
			tx.commit();
		}catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return good;
	}
	
	public List SearchGood(int first,int size,String key) {
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		List goods=null;
		try {
			tx=session.beginTransaction();
			Query query=session.createQuery("from Good as g where g.name like '%"+key+"%'");
			query.setFirstResult(first);
			query.setMaxResults(size);
			goods=query.list();
			tx.commit();
		}catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return goods;
	}
	
	public List findGood(int first,int size) {
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		List goods=null;
		try {
			tx=session.beginTransaction();
			Query query=session.createQuery("from Good as g order by g.id ");
			query.setFirstResult(first);
			query.setMaxResults(size);
			goods=query.list();
			tx.commit();
		}catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return goods;
	}
}
