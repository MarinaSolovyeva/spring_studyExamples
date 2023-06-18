package com.soloveva.spring.springboot.spring_course_springboot.dao;


import com.soloveva.spring.springboot.spring_course_springboot.entity.Employee;

import java.util.List;
// сначала создаем интерфейс DAO

public interface EmployeeDAO {
    public Employee getEmployee(int id);

    public List <Employee> getAllEmployees ();

    public void saveEmployee(Employee employee);

    public void deleteEmployee(int id);
}
