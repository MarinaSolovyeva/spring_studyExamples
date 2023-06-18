package com.soloveva.spring.springboot.spring_course_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan (basePackages = "com.soloveva.spring.springboot.spring_course_springboot")

@SpringBootApplication
public class SpringCourseSpringBootApplication {

    public static void main(String[] args)
    {

        SpringApplication.run(SpringCourseSpringBootApplication.class, args);
    }

}
