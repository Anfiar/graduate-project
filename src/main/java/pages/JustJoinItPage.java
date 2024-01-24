package pages;

import driver.MyDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

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
    private String getOfferSize = "//button[@tabindex=\"0\" and @role=\"tab\"]/span";
    private String topCompaniesButton = ".//*[@id=\"__next\"]/div[2]/div[1]/header/div/div/div[3]/li[2]/div";
    private String searchCompanyInput = "//input[@placeholder=\"Search company\"]";
    private String getListOfCompany = "//div[@data-page=\"1\"]";

    private static final Logger logger = LogManager.getLogger(JustJoinItPage.class);

    public JustJoinItPage() {
        this.driver = MyDriver.getDriver();
    }

    public void getUrl() {
        logger.info("getURL");
        driver.get(url);
        logger.info("sendURL");
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
        logger.info("Find xpath: {}", searchInput);
        driver.findElement(By.xpath(searchInput)).sendKeys(search, Keys.ENTER);
    }

    public void goToLoginPage() {
        getUrl();
        clickSignIn();
        clickCandidateProfileSignIn();
        clickSingInByEmail();
    }

    public String getGetOfferSize() {
        driver.findElement(By.xpath("//button[text()=\"Subscribe\"]"));
        logger.warn(driver.findElement(By.xpath(getOfferSize)).getText());
        return driver.findElement(By.xpath(getOfferSize)).getText();
    }
    public List<WebElement> getOfferSize2() {
        return driver.findElements(By.xpath("//div[@data-test-id=\"virtuoso-item-list\"]/div"));
    }

    public void clickTopCompaniesButton() throws InterruptedException {
        logger.info("startFind");
        logger.info(driver.findElement(By.xpath(topCompaniesButton)).getText());
        Thread.sleep(400);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(topCompaniesButton)));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.findElement(By.xpath(topCompaniesButton)).click();
        //new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(topCompaniesButton))).click();
        //new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(topCompaniesButton)));
        //driver.findElement(By.xpath(topCompaniesButton)).click();
    }

    public void sendKeySearchCompanyInput(String search) {
        driver.findElement(By.xpath(searchCompanyInput)).sendKeys(search, Keys.ENTER);
    }
    public List<WebElement> getListOfCompanyByData() {
        driver.findElement(By.xpath("//div[@style=\"display: block;\"]"));
        return driver.findElements(By.xpath(getListOfCompany));
    }
    public void clickStartupAsListOfCompany() {
        driver.findElement(By.xpath("//button[text()=\"Startup\"]")).click();
    }
    public List<String> getListOfCompanyByName() {
        driver.findElement(By.xpath("//div[@style=\"display: block;\"]"));
        List<String> stringList = new ArrayList<>();
        for (WebElement wb:driver.findElements(By.xpath("//h6"))
             ) {
            stringList.add(wb.getText());
        }
        Collections.sort(stringList);
        return stringList;
    }
}
