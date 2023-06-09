package com.jocata.utils;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.jocata.entity.Country;
import com.jocata.entity.Employee;

public class HibernateUtils {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory == null) {
			try {
				Configuration  configuration = new Configuration();
				Properties sessionProperty = new Properties();
				sessionProperty.put(Environment.DRIVER,"oracle.jdbc.driver.OracleDriver");
				sessionProperty.put(Environment.URL,"jdbc:oracle:thin:@localhost:1521:xe");
				sessionProperty.put(Environment.USER, "system");
				sessionProperty.put(Environment.PASS, "root");
				sessionProperty.put(Environment.DIALECT, "org.hibernate.dialect.Oracle10gDialect");
				sessionProperty.put(Environment.SHOW_SQL, "true");
				sessionProperty.put(Environment.FORMAT_SQL,"true");
				sessionProperty.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				sessionProperty.put(Environment.HBM2DDL_AUTO, "update");
				configuration.setProperties(sessionProperty);
				configuration.addAnnotatedClass(Country.class);
				configuration.addAnnotatedClass(Employee.class);
				ServiceRegistry serviceRegistry =new StandardServiceRegistryBuilder().
						                        applySettings(configuration.getProperties()).build();
				
				sessionFactory=configuration.buildSessionFactory(serviceRegistry);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return sessionFactory;
	}
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
