package HibernateTest2.One_to_One.UniDirectional;


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
        try {
//        Session session = factory.getCurrentSession();
//        Employee employee = new Employee("Marina", "Soloveva", "IT", 700);
//        Detail detail = new Detail("Antalya", "8968", "soloveva@gmail.com");
//        employee.setEmpDetail(detail);
//
//            session.beginTransaction();
//            session.save(employee); // сейчас мне будет достаточно просто сохранить работника. вся связанная с ним инфа
//            //благодаря каскаду сохранится автоматически
//            session.getTransaction().commit();

            Session session = factory.getCurrentSession();

            session.beginTransaction();
            Employee emp = session.get(Employee.class, 1);
            System.out.println(emp.getEmpDetail());//получили работника, благодаря каскаду получем не только
            // работника, но и его детали


            session.getTransaction().commit();

            System.out.println("Done");
        } finally {
            factory.close();
        }
    }
}
