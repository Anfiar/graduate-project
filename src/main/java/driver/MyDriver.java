package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MyDriver {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        driver = new ChromeDriver();
        setUp();
        return driver;
    }

    public static void setUp() {
        if (driver != null){
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        }
    }

    public static void closeDriver() {
        driver.close();
        driver.quit();
    }


}
