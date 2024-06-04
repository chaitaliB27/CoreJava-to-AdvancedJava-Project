package com.anudip.hibernate.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.anudip.hibernate.entity.Employee;

public class HibernateUtil {

	public static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory == null) {
			
			Properties settings = new Properties();
			settings.put(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
			settings.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
			settings.put(Environment.URL,"jdbc:mysql://localhost:3306/anudip2");
			settings.put(Environment.USER,"root");
			settings.put(Environment.PASS,"0624");
			settings.put(Environment.HBM2DDL_AUTO,"create");
			settings.put(Environment.SHOW_SQL,"true");
			
			Configuration configuration = new Configuration();
			configuration.setProperties(settings);
			configuration.addAnnotatedClass(Employee.class);
			
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
					applySettings(configuration.getProperties()).build();
			
			sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}
}
