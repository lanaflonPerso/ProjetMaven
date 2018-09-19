package fr.dawan.reseauSoc.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private SessionFactory sessionFactory;
	
	private SessionFactory buildSessionFactory() {
        try {
        	sessionFactory = new Configuration()
        			.configure("/hibernate.cfg.xml")
        			.buildSessionFactory();        	
            return sessionFactory;
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }
	
	public SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			sessionFactory = buildSessionFactory();
		}
        return sessionFactory;
	}
}