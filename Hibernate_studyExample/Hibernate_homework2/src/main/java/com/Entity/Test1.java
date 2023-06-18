package com.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure() //sessionfactory чтобы смог прочитать файл.
                // если файл называется именно так, тогда можно его не писать.но лучше писать

                .addAnnotatedClass(Employee.class)//указываем класс, который имеет аннотации для работы с БД

                .buildSessionFactory(); //метод который session factory строит
        try {
        Session session = factory.getCurrentSession();//создаем сессию
        Employee emp = new Employee("Denis", "Savateev", "IT", 600);//обратить внимание,
        // что id не пишем, он генерируется автоматом

            session.beginTransaction();//открываем транзакцию. В Java в отличии от БД мы должны самостоятельно открывать
            // и закрывать транзакции
            session.save(emp); // с помощью сессии сохраняем имеющийся объект
            session.getTransaction().commit();//закрываем транзакцию
            //эти строчки кода могут выбрасывать exception, а factory нам нужно закрывать, помещаем в try block
        } finally {
            factory.close();//теперь даже если выбросится exception, session factory будет закрыт
        }
    }

}
