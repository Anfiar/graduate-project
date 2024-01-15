package ui;

import driver.MyDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
//    @BeforeAll
//    public static void setUp(){
//        MyDriver.setUp();
//    }
    @AfterAll
    public static void quit(){
        MyDriver.closeDriver();
    }
}
