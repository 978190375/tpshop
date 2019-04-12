package operator;

import java.util.List;

import shiti.Image;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ImageOperator {


	public static SessionFactory sessionFactory;
	static {
		Configuration config=new Configuration().configure();
		sessionFactory=config.buildSessionFactory();
	}
	public Image getImage(int id) {
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		Image image=null;
		try {
			tx=session.beginTransaction();
			image=(Image)session.get(Image.class, id);
			
			tx.commit();
		}catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return image;
	}
	public int getImageCount() {
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		List images=null;
		try {
			tx=session.beginTransaction();
			Query query=session.createQuery("from Image");
			images=query.list();
			tx.commit();
		}catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return images.size();
	}
	public List findImage(int first,int size) {
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		List images=null;
		try {
			tx=session.beginTransaction();
			Query query=session.createQuery("from Image as i order by i.id desc");
			query.setFirstResult(first);
			query.setMaxResults(size);
			images=query.list();
			tx.commit();
		}catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return images;
	}
	public void saveImage(Image	image) {     
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(image);
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
}
