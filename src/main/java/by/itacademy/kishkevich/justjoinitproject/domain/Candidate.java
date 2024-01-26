package by.itacademy.kishkevich.justjoinitproject.domain;

import com.github.javafaker.Faker;

public class Candidate {
    public static String getEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static String getWrongEmail() {
        Faker faker = new Faker();
        return faker.name().username();
    }

    public static String getPassword() {
        Faker faker = new Faker();
        return faker.internet().password();
    }

    public static int getNumber() {
        Faker faker = new Faker();
        return faker.random().nextInt(1000);
    }
}
