package fr.dawan.reseauSoc.dao;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Dao {

	protected static SessionFactory sessionFactory;
	private static Session session;
	
	public static <T> void save(T bean) {
		Transaction tx = session().beginTransaction();

		session.save(bean);
		
		tx.commit();
	}
		
	public static Session session() {
		if (session == null) {
			try {
				sessionFactory = new Configuration().configure("/hibernate.cfg.xml")
						.buildSessionFactory();
				session = sessionFactory.openSession();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return session;
	}
	
	public static void closeSession() {
		session.close();
	}
	
	public static String MySQLPassword(String password) throws UnsupportedEncodingException {
        byte[] utf8 = password.getBytes("UTF-8");
        return "*" + DigestUtils.sha1Hex(DigestUtils.sha1(utf8)).toUpperCase();
	}
}
