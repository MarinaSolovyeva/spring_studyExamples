package spring.springIntroduction;

public class Person {
    private Pet pet;
    private String surname;
    private int age;

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        System.out.println("Class Person : get surname");
        return surname;
    }

    public int getAge() {
        System.out.println("Class Person : get age");
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //    public Person(Pet pet) {
//        this.pet = pet;
//    }
    public Person() { System.out.println("Person is created"); }

    public void setPet(Pet pet) {
        System.out.println("Class Person : set Pet");
        this.pet = pet; }
    public void callYourPet () {
        System.out.println("Hello my lovely pet!");
        pet.say();
    }
}
