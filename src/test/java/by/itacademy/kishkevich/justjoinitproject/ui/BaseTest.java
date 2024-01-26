package by.itacademy.kishkevich.justjoinitproject.ui;

import by.itacademy.kishkevich.justjoinitproject.driver.MyDriver;
import org.junit.jupiter.api.AfterAll;

public class BaseTest {
    @AfterAll
    public static void quit() {
        MyDriver.closeDriver();
    }
}
