package pages;

import driver.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JustJoinItPage {
    private final String url = "https://justjoin.it/";
    private String signIn = "//button[text() ='Sign in']";
    private String candidateProfileSignIn = "//p[text() ='Sign in to Candidate's profile']";
    private String employerProfileSignIn = "//p[text() ='Sign in to Employer's panel']";

    private String singInByEmail = "//button[text() = 'Sign in using address email']";

    private String emailInput = "//*[@id=':r1:']";
    private String passwordInput = "//*[@id=':r2:']";
    private String signInButton = "//button[@type='submit' and text() = 'Sign in']";


    private WebDriver driver;

    public JustJoinItPage() {
        this.driver = MyDriver.getDriver();
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

    public void clickSignInButton() {
        driver.findElement(By.xpath(signInButton)).click();

    }
}
