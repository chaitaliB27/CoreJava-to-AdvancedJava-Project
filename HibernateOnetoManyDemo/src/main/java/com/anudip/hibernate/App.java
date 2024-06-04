package com.anudip.hibernate;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
    
    	Configuration cfg = new Configuration(); // ServiceRegistry
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
        Parent p1 = new Parent();
        p1.setPid(1);
        p1.setpName("Amitabh");
     
        Child c1 = new Child();
        c1.setCid(1);
        c1.setcName("Sakshi");
        
        Child c2 = new Child();
        c2.setCid(2);
        c2.setcName("Abhishek");
        
        session.save(c1);
        session.save(c2);
        
        HashSet<Child> childSet = new HashSet<Child>();
        childSet.add(c1);
        childSet.add(c2);
        
        p1.setChild(childSet);

        session.save(p1);
        
        tx.commit();
        session.close();
        System.out.println("Data added successfully");
    }    
    
}