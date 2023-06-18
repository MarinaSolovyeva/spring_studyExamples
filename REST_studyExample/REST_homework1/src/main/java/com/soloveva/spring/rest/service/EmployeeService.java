package com.soloveva.spring.rest.service;

import com.soloveva.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List <Employee> getAllEmployees ();//лучше называть метод в сервисе и в DAO одинаково

    public void saveEmployee(Employee employee);

    public Employee getEmployee (int id);

    public void deleteEmployee (int id);
}
