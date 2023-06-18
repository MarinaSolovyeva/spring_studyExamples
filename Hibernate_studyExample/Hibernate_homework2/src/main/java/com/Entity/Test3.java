package com.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
        Session session = factory.getCurrentSession();

            session.beginTransaction();
            List<Employee> emps = session.createQuery("from Employee " + "where name = 'Marina'")
                    .getResultList();
            //обратить внимание что здесь пишем не имя таблицы, а имя класса.name - название поля

            for (Employee e : emps) {
                System.out.println(e);
            }
            session.getTransaction().commit();


        } finally {
            factory.close();
        }
    }

}
