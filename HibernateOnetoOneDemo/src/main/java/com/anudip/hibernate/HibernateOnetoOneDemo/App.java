package com.anudip.hibernate.HibernateOnetoOneDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.anudip.hibernate.HibernateOnetoOneDemo.entity.Husband;
import com.anudip.hibernate.HibernateOnetoOneDemo.entity.Wife;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 
    	 Configuration cfg = new Configuration();
    	  
         cfg.configure("hibernate.cfg.xml");
         SessionFactory sessionFactory = cfg.buildSessionFactory();
         Session session = sessionFactory.openSession();
         Transaction tx = session.beginTransaction();
         
         Husband h1 = new Husband();
         Wife w1 = new Wife();
         h1.setHid(1);
         h1.sethName("Amitabh");
         h1.setWife(w1);
         
         w1.setWid(1);
         w1.setwName("Jaya");
         w1.setHusband(h1);
         
         session.save(w1);
     	session.save(h1);
     	
     	tx.commit();
        /* 
    	Configuration cfg=new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	
    	SessionFactory sessionFactory=cfg.buildSessionFactory();
    	Session session=sessionFactory.openSession();
    	Transaction tx=session.beginTransaction();
    	
    	Husband h1=new Husband();
    	Wife w1=new Wife();
    	
    	//h1.sethId(1);
    	h1.sethName("Ranveer");
    	h1.setWife(w1);
    	
    	//w1.setwId(1);
    	w1.setwName("Aliya");
    	w1.setHusband(h1);
    	
    	session.save(w1);
    	session.save(h1);
    	
    	tx.commit();
    	*/
    }
}
