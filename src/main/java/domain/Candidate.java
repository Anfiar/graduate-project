package domain;

import com.github.javafaker.Faker;

public class Candidate {
    public static String getEmail(){
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }
    public static String getPassword(){
        Faker faker = new Faker();
        return faker.internet().password();
    }
}
