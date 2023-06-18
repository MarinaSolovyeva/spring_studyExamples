package spring.springIntroduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {


    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext2.xml");

    Dog myDog = context.getBean("myPet", Dog.class);
    Dog yourDog = context.getBean("myPet", Dog.class);
}}
