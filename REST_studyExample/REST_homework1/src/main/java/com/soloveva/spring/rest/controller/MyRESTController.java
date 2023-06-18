package com.soloveva.spring.rest.controller;

import com.soloveva.spring.rest.entity.Employee;
import com.soloveva.spring.rest.exception_heading.EmployeeIncorrectData;
import com.soloveva.spring.rest.exception_heading.NoSuchEmployeeException;
import com.soloveva.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController //котроллер который управляет rest запросами и rest ответами
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List <Employee> showAllEmployees(){
        List <Employee> allEmployees = employeeService.getAllEmployees();

        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee (@PathVariable int id) { // используется для получения значения переменной из адреса запроса
        Employee employee = employeeService.getEmployee(id);

        if (employee == null) {throw new NoSuchEmployeeException("There is no employee with ID " +
                id  + " in Database");
        }

        return employee;
    }

    @PostMapping("/employees")
    //чтобы использовать тело метода POST используем в параметре аннотацию RequestBody
    public Employee addNewEmployee (@RequestBody Employee employee){
        employeeService.saveEmployee(employee);

        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee (@RequestBody Employee employee){
        employeeService.saveEmployee(employee);

        return employee;
    }
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){

        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {throw new NoSuchEmployeeException("There is no employee " +
                "with ID = " + id + " in Database.");}

        employeeService.deleteEmployee(id);
        return "Employee with ID "+ id + " was deleted.";
    }

}
