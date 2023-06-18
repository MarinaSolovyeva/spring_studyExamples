package com.soloveva.spring.mvc_hibernate_aop.controller;

import com.soloveva.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.soloveva.spring.mvc_hibernate_aop.entity.Employee;
import com.soloveva.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    /*чтобы вручную не создавать объект dao, работаем через внедрение зависимостей */
    private EmployeeService employeeService; //теперь работаем через Employee Service,а не напрямую с DAO

    @RequestMapping("/")
    /* из этого метода вызываем метод DAO , чтобы тот вернул список работников. Чтобы вью смог отобразить
    значение полей работников,  мы должны в методе контроллера создать модель, и добавить работников в качестве аттрибутов
    этой модели*/
    public String showAllEmployees(Model model) {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);
        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    //создаем нового работника и добавляем в аттрибут модели, когда будем заполнять форму данными
    // мы будем добавлять эти данные данному работнику
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        //получили из формы наш аттрибут employee и сохраняем его в базе
        employeeService.saveEmployee(employee);
        return "redirect:/"; //нам нужен обновленный список всех работников. слэш отвечает за вью
        // который выводит всех работников
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee (@RequestParam("empId") int id, Model model) {
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee (@RequestParam("empId") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}
