package com.soloveva.spring.springboot.spring_course_springboot.service;
import com.soloveva.spring.springboot.spring_course_springboot.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List <Employee> getAllEmployees ();//лучше называть метод в сервисе и в DAO одинаково

    public void saveEmployee(Employee employee);
    public Employee getEmployee (int id);
    public void deleteEmployee (int id);
}
