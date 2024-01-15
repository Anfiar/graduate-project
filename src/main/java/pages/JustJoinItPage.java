package pages;

import driver.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.time.Duration;

public class JustJoinItPage {
    private final String url = "https://justjoin.it/";
    private String signIn = "//button[text() ='Sign in']";
    private String candidateProfileSignIn = "//p[text() =\"Sign in to Candidate's profile\"]";
    private String employerProfileSignIn = "//p[text() =\"Sign in to Employer's panel\"]";

    private String singInByEmail = "//button[text() = 'Sign in using address email']";

    private String emailInput = "//*[@id=\":r1:\"]";
    private String passwordInput = "//*[@id=\":r2:\"]";
    private String signInButton = "//button[@type=\"submit\" and text() = \"Sign in\"]";
    private String signInError = "//div[@datacy='failed-login-via-mail-snack']//p";
    private String emailError = "//*[@id=\":r1:-helper-text\"]";
    private String passwordError = "//*[@id=\":r2:-helper-text\"]";
    private String searchInput = "//input[@placeholder=\"Search\"]";
    private WebDriver driver;

    public JustJoinItPage() {
        this.driver = MyDriver.getDriver();
    }

    public void getUrl() {
        driver.get(url);
    }

    public void clickSignIn() {
        driver.findElement(By.xpath(signIn)).click();
    }

    public void clickCandidateProfileSignIn() {
        driver.findElement(By.xpath(candidateProfileSignIn)).click();
    }

    public void clickEmployerProfileSignIn() {
        driver.findElement(By.xpath(employerProfileSignIn)).click();
    }

    public void clickSingInByEmail() {
        driver.findElement(By.xpath(singInByEmail)).click();
    }

    public void sendEmail(String email) {
        driver.findElement(By.xpath(emailInput)).sendKeys(email);
    }

    public void sendPassword(String password) {
        driver.findElement(By.xpath(passwordInput)).sendKeys(password);
    }

    public void clickSignInButton() {
        driver.findElement(By.xpath(signInButton)).click();
    }

    public String getSignInError() {
        return driver.findElement(By.xpath(signInError)).getText();
    }

    public String getEmailError() {
        return driver.findElement(By.xpath(emailError)).getText();
    }

    public String getPasswordError() {
        return driver.findElement(By.xpath(passwordError)).getText();
    }

    public void sendKeySearchInput(String search) {
        driver.findElement(By.xpath(searchInput)).sendKeys(search, Keys.ENTER);
    }

    public String getOfferSize() {
        return driver.findElement(By.xpath("//span[text()=\"52 offers\"]")).getText();
    }
}
