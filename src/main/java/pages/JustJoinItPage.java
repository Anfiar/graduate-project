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
    private String singInByEmail = "//button[text() = 'Sign in using address email']";
    private String emailInput = "//*[@id=':r1:']";
    private String passwordInput = "//*[@id=':r2:']";
    private String signInButton = "//button[@type='submit' and text() = 'Sign in']";
    private String signInError = "//div[@datacy='failed-login-via-mail-snack']//p";
    private String emailError = "//*[@id=':r1:-helper-text']";
    private String passwordError = "//*[@id=':r2:-helper-text']";
    private String searchInput = "//input[@placeholder='Search']";
    private WebDriver driver;
    private String getOfferSize = "//button[@tabindex='0' and @role='tab']/span";
    private String topCompaniesButton = "//a[@class='header_brandStory_link']";
    private String searchCompanyInput = "//input[@placeholder='Search company']";
    private String getListOfCompany = "//div[@data-page='1']";
    private String turnEmailNotification = "//button[@name=\"job_alerts_banner_save_button\"]";
    private String startupButton = "//button[text()='Startup']";
    private String getOfferRecord = "//div[@data-test-id=\"virtuoso-item-list\"]/div";
    private String getOfferRecordList = "//div[@style=\"display: block;\"]";
    private String getCompanyName = ".//h6";
    private String getPositionName = ".//h2";
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

    public void goToLoginPage() {
        getUrl();
        clickSignIn();
        clickCandidateProfileSignIn();
        clickSingInByEmail();
    }

    public String getGetOfferSize() {
        driver.findElement(By.xpath(turnEmailNotification));
        logger.info(driver.findElement(By.xpath(getOfferSize)).getText());
        return driver.findElement(By.xpath(getOfferSize)).getText();
    }

    public List<WebElement> getOfferSizeListByPositionSearch() {
        return driver.findElements(By.xpath(getOfferRecord));
    }

    public void clickTopCompaniesButton() {
        logger.info("startFind");
        driver.findElement(By.xpath(topCompaniesButton)).click();
    }

    public void sendKeySearchCompanyInput(String search) {
        //new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchCompanyInput))).sendKeys(search, Keys.ENTER);
        driver.findElement(By.xpath(searchCompanyInput)).sendKeys(search, Keys.ENTER);
    }

    public List<WebElement> getListOfCompanyByData() {

        driver.findElement(By.xpath(getOfferRecordList));
        return driver.findElements(By.xpath(getListOfCompany));
    }

    public void clickStartupAsListOfCompany() {
        driver.findElement(By.xpath(startupButton)).click();
    }

    public List<String> getListOfCompanyByName() {
        driver.findElement(By.xpath(getOfferRecordList));
        List<String> stringList = new ArrayList<>();
        for (WebElement wb : driver.findElements(By.xpath(getCompanyName))
        ) {
            stringList.add(wb.getText());
        }
        Collections.sort(stringList);
        return stringList;
    }

    public String getFirstCompanyName() {
        return getListOfCompanyByData().getFirst().findElement(By.xpath(getCompanyName)).getText();
    }

    public String getFirstPositionName() {
        return getOfferSizeListByPositionSearch().getFirst().findElement(By.xpath(getPositionName)).getText();

    }
}


