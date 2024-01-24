package ui;

import driver.MyDriver;
import org.junit.jupiter.api.AfterAll;

public class BaseTest {
    @AfterAll
    public static void quit() {
        MyDriver.closeDriver();
    }
}
