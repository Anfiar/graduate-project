package by.itacademy.kishkevich.justjoinitproject.ui;

import by.itacademy.kishkevich.justjoinitproject.driver.Driver;
import by.itacademy.kishkevich.justjoinitproject.pages.JustJoinItPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    protected JustJoinItPage justJoinItPage;

    @BeforeEach
    public void setUp() {
        justJoinItPage = new JustJoinItPage();
    }

    @AfterEach
    public void quit() {
        Driver.quitDriver();
    }
}
