package test.guokao.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import test.guokao.model.JobInfo;

/**
 * 为了将Excel数据导入数据库
 * @author lyt
 *
 */

public class DBUtil {
	
	private static Configuration configuration = null;
	private static SessionFactory sessionFactory = null;
	private static ServiceRegistry serviceRegistry = null;
	private static Session session = null;
	
	static {
		try {
			configuration = new Configuration().configure();
			serviceRegistry = new ServiceRegistryBuilder().applySettings(
					configuration.getProperties()).buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
			session=sessionFactory.openSession();

			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	
	
	public void save(JobInfo jobInfo,int i) {
		
	
		Transaction tx=session.beginTransaction();
		
		session.save(jobInfo);//保存后customer对象处于持久化状态
		
		if(i%500==0) //以每500个数据作为一个处理单元
			{
			session.flush(); //保持与数据库数据的同步
			session.clear(); //清除内部缓存的全部数据，及时释放出占用的内存
			} 
		
		
		tx.commit();
		//session.close();
	}
}
