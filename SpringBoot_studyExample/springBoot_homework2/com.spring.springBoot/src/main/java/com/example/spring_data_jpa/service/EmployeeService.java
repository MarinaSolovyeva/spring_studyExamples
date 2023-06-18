package com.example.spring_data_jpa.service;


import com.example.spring_data_jpa.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List <Employee> getAllEmployees ();//лучше называть метод в сервисе и в DAO одинаково

    public void saveEmployee(Employee employee);
    public Employee getEmployee (int id);
    public void deleteEmployee (int id);

    public List <Employee> findAllByName (String name);
}
