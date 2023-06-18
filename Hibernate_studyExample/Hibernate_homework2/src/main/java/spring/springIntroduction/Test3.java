package spring.springIntroduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Pet pet = context.getBean("myPet", Cat.class);
        Person person = context.getBean("myPerson", Person.class);

        person.callYourPet();

        person.getAge();
        person.getSurname();

        context.close();
    }
}
