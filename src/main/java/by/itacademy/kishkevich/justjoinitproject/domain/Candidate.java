package by.itacademy.kishkevich.justjoinitproject.domain;

import com.github.javafaker.Faker;

public class Candidate {
    public static String getEmail() {
        return new Faker().internet().emailAddress();
    }

    public static String getWrongEmail() {
        return new Faker().name().username();
    }

    public static String getPassword() {
        return new Faker().internet().password();
    }

    public static int getNumber() {
        return new Faker().random().nextInt(1000);
    }
}
