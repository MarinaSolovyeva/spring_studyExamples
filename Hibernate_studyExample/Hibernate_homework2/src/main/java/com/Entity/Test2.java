package com.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()

                .addAnnotatedClass(Employee.class)

                .buildSessionFactory();
        try {
        Session session = factory.getCurrentSession();//создаем сессию
        Employee emp = new Employee("Elena", "Urina", "Acc", 300);

            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();


//            session = factory.getCurrentSession(); // получаем новую сессию
//            session.beginTransaction();// запускаем сессию
//            session.createQuery("update Employee set salary= 1000 " + " where id >= 2").executeUpdate();
//            //с помощью метода execute update запускаем
            session.getTransaction().commit();//завершаем транзакцию





        } finally {
            factory.close();
        }
    }

}
