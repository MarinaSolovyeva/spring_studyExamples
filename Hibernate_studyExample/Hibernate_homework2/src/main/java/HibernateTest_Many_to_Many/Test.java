package HibernateTest_Many_to_Many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.cglib.proxy.Factory;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();

            Child child1 = new Child("Masha", 6);
            Child child2 = new Child("Misha", 7);
            Child child3 = new Child("Pasha", 3);
            Child child4 = new Child("Kostya", 5);
            Child child5 = new Child("Dasha", 6);

            Section section1 = new Section("Football");
            Section section2 = new Section("Basketball");
            Section section3 = new Section("Dance");

            section1.addChildToSection(child1);
            section1.addChildToSection(child2);
            section1.addChildToSection(child3);

            child4.addSectionToChild(section2);
            child4.addSectionToChild(section3);

            child5.addSectionToChild(section2);

            session.beginTransaction();

            session.persist(child4);
            session.persist(child5);

            session.getTransaction().commit();

        }

        finally {
            session.close();
            factory.close();

        }
    }

}
