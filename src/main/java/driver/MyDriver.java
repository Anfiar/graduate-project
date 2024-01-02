package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyDriver {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        driver = new ChromeDriver();
        return driver;
    }

    public static void setUp(){
        driver.manage().window().maximize();
    }
    public static void closeDriver(){
        driver.close();
        driver.quit();
    }



}
