package spring.springIntroduction;

public class Cat implements Pet{
    @Override
    public void say () {
        System.out.printf("Meow-meow");
    }
}
