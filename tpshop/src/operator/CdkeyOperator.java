package operator;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import shiti.Cdkey;
import shiti.Good;

public class CdkeyOperator {

	public static SessionFactory sessionFactory;
	static {
		Configuration config=new Configuration().configure();
		sessionFactory=config.buildSessionFactory();
	}
	/*
	 * 保存一条cdkey
	 * */
	public void saveCdkey(Cdkey cdkey) {     
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(cdkey);
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
	
	/*
	 * 保存多条cdkey
	 * */
	public void saveCdkeys(Cdkey [] cdkeys) {
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			for(int i=0;i<cdkeys.length;i++) {
				session.save(cdkeys[i]);
			}
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
	
	/*
	 * 根据ID 查找cdkey
	 * */
	public Cdkey getCdkey(int id) {
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		Cdkey cdkey=null;
		try {
			tx=session.beginTransaction();
			cdkey=(Cdkey)session.get(Cdkey.class, id);
			tx.commit();
		}catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return cdkey;
	}
	
	/*
	 * 更新修改Cdkey
	 * */
	public void update(Cdkey cdkey) {
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.update(cdkey);
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
	
	/*
	 * 根据商品id来获取cdkey总数量
	 * good_id 商品id
	 * */
	public int getCdkeyCount(int good_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		List cdkeyList=null;
		try {
			tx=session.beginTransaction();
			Query query=session.createQuery("from Cdkey as c where c.state=0 and c.good.id=:good_id");
			query.setInteger("good_id", good_id);
			cdkeyList=query.list();
			tx.commit();
		}catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return cdkeyList.size();
	}
	
	/*
	 * 根据商品ID查找cdkey
	 * 分页查询
	 * */
	public List findCdkey(int first,int size,int good_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		List cdkeys=null;
		try {
			tx=session.beginTransaction();
			Query query=session.createQuery("from Cdkey as c where c.good.id=:good_id and c.state=0 order by c.id asc");
			query.setInteger("good_id", good_id);
			query.setFirstResult(first);
			query.setMaxResults(size);
			cdkeys=query.list();
			tx.commit();
		}catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}		
		return cdkeys;
	}
	public Cdkey getOneCdkeyByGoodId(int good_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		Cdkey cdkey=null;
		try {
			tx=session.beginTransaction();
			cdkey=(Cdkey) session.createQuery("from Cdkey as c where c.good.id="+good_id+" and c.state=0 order by c.id asc").setMaxResults(1).uniqueResult();
			tx.commit();
		}catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}		
		return cdkey;
	}
}
