package com.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            session.beginTransaction();

            session.createQuery("delete Employee " + " where name = 'Elena'").executeUpdate();

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}


