package com.soloveva.spring.mvc_hibernate_aop.dao;

import com.soloveva.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;
// сначала создаем интерфейс DAO

public interface EmployeeDAO {
    public Employee getEmployee(int id);

    public List <Employee> getAllEmployees ();

    public void saveEmployee(Employee employee);

    public void deleteEmployee(int id);
}
