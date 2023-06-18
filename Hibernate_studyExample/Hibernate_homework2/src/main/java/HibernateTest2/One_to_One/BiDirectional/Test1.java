package HibernateTest2.One_to_One.BiDirectional;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;
        try {session = factory.getCurrentSession();


        Employee employee = new Employee("Mike", "Klim", "HR", 500);
        Detail detail = new Detail("New-York", "7666", "Klim@gmail.com");

        employee.setEmpDetail(detail); // если не написать эту строку, код прекрасно сработает, но в таблице
            //employee в колонке details_id - не подсоединится номер
        detail.setEmployee(employee);
            session.beginTransaction();
            session.save(detail);

            session.getTransaction().commit();

            System.out.println("Done");
        } finally {
            session.close();
            factory.close();
        }
    }
}
