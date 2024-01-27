package by.itacademy.kishkevich.justjoinitproject.ui;

import by.itacademy.kishkevich.justjoinitproject.driver.Driver;
import by.itacademy.kishkevich.justjoinitproject.pages.JustJoinItPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    JustJoinItPage justJoinItPage;

    @BeforeEach
    public void testStart() {
        justJoinItPage = new JustJoinItPage();
    }

    @AfterAll
    public static void quit() {
        Driver.quitDriver();
    }
}
