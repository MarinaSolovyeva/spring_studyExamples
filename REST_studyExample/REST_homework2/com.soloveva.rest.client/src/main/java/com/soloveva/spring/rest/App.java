package com.soloveva.spring.rest;

import com.soloveva.spring.rest.configuration.MyConfig;
import com.soloveva.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication", Communication.class);


        communication.deleteEmployee(7);
    }
}
