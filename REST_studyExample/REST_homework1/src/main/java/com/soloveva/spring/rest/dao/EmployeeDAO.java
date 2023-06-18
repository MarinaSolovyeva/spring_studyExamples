package com.soloveva.spring.rest.dao;

import com.soloveva.spring.rest.entity.Employee;

import java.util.List;
// сначала создаем интерфейс DAO

public interface EmployeeDAO {
    public Employee getEmployee(int id);

    public List <Employee> getAllEmployees ();

    public void saveEmployee(Employee employee);

    public void deleteEmployee(int id);
}
