package com.soloveva.spring.rest.service;

import com.soloveva.spring.rest.dao.EmployeeDAO;
import com.soloveva.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDAO employeeDAO;
    @Override
    // тут просто вызываем метод из EmployeeDAOImpl. чтобы вызывать его, прописываем зависимость от DAO
    @Transactional //можем доверить спрингу открытие и закрытие транзакции с помощью данной аннотации
    //транзакционность соблюдается на уровне сервиса
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional //не забыть прописывать эту аннотацию
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);

    }
}
