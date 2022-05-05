package lesson2;

import org.junit.jupiter.api.Test;

public class First {
    @Test
    public void first() {
        int a = 3;
        int b = 16;
        int c = sum(a, b);

        System.out.println("Sum is: " + c);

        a = 22;
        b = 15;
        sum(a, b);
        System.out.println(sum(25, 25));
    }

    private int sum(int a, int b) {
        System.out.println("First digit is: " + a + " Second digit is: " + b);
        int c = a + b;
        return c;
    }

    @Test
    public void usingObjects() {
        Student renars = new Student();
        renars.setFirstName("Renārs");
        renars.setLastName("Kravcovs");
        renars.setAge(32);
        renars.setPersonalCode("151179-10529");

        Student dima = new Student();
        dima.setFirstName("Dima");
        dima.setLastName("QA");
        dima.setAge(23);
        dima.setPersonalCode("181636-2122");

        System.out.println(renars.getFirstName() + " " + renars.getLastName());
        System.out.println(dima.getFirstName() + " " + dima.getLastName());
    }
}
