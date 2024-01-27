package by.itacademy.kishkevich.justjoinitproject.ui;

import by.itacademy.kishkevich.justjoinitproject.driver.Driver;
import org.junit.jupiter.api.AfterAll;

public class BaseTest {
    @AfterAll
    public static void quit() {
        Driver.closeDriver();
    }
}
