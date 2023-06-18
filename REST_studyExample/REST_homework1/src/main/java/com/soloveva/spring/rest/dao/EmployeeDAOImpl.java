package com.soloveva.spring.rest.dao;

import com.soloveva.spring.rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository /* при ее создании использовалась аннотация component */
public class EmployeeDAOImpl implements EmployeeDAO {
    /* для того чтобы дао мог подключаться к БД с помощью Hibernate, DAO
   должен иметь доступ к session factory  . в апплик контекст мы создали бин локалсессион фэктору.
   он зависит от бина datasourse. в бине datasourse прописаны все параметры для подключения к БД.


   Внедряем в наш класс зависимость от нашего бина. Теперь при запуске приложения в нашем spring контейнере
   будут созданы бины из application context, session bean. transaction bean, data sourse , и в employee dao с помощью
   нашего поля будет автоматически внедрена зависимость от session factory. */
    @Autowired
    private SessionFactory sessionFactory;


    @Override

    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        session.get(Employee.class, 1);

        List<Employee> allEmployees = session.createQuery("from Employee", Employee.class).getResultList();

        return allEmployees;
    }

    @Override

    public void saveEmployee(Employee employee) {// прописываем логику добавления работника в базу данных
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);

    }

    @Override

    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("delete from Employee where id = :employeeId");
        query.setParameter("employeeId", id);//в нашем выражении произойдет замена названия параметра на само значение параметра
        query.executeUpdate();
    }
}
