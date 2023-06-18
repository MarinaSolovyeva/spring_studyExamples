package spring.springIntroduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext contex =
                new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Pet pet = contex.getBean("myPet", Pet.class);
        pet.say();

        contex.close();
    }
}
