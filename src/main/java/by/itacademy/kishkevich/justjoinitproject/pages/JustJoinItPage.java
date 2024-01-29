package by.itacademy.kishkevich.justjoinitproject.pages;

import by.itacademy.kishkevich.justjoinitproject.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class JustJoinItPage {
    private WebDriver driver;
    private String url = "https://justjoin.it/";
    private String signIn = "//button[text() ='Sign in']";
    private String candidateProfileSignIn = "//p[text() =\"Sign in to Candidate's profile\"]";
    private String singInByEmail = "//button[text() = 'Sign in using address email']";
    private String emailInput = "//*[@id=':r1:']";
    private String passwordInput = "//*[@id=':r2:']";
    private String signInToAccountButton = "//button[@type='submit' and text() = 'Sign in']";
    private String signInError = "//div[@datacy='failed-login-via-mail-snack']//p";
    private String emailError = "//*[@id=':r1:-helper-text']";
    private String passwordError = "//*[@id=':r2:-helper-text']";
    private String searchInput = "//input[@placeholder='Search']";
    private String offerSize = "//button[@tabindex='0' and @role='tab']/span";
    private String topCompaniesButton = "//a[@class='header_brandStory_link']";
    private String searchCompanyInput = "//input[@placeholder='Search company']";
    private String listOfCompany = "//div[@data-page='1']";
    private String turnEmailNotification = "//button[@name='job_alerts_banner_save_button']";
    private String startupButton = "//button[text()='Startup']";
    private String offerRecord = "//div[@data-test-id='virtuoso-item-list']/div";
    private String afterSearchCompanyDiv = "//div[@style='display: block;']";
    private String companyName = ".//h6";
    private String positionName = ".//h2";
    private static final Logger logger = LogManager.getLogger();

    public JustJoinItPage() {
        this.driver = Driver.getDriver();
        logger.info("Create WebDriver");
    }

    public void getUrl() {
        logger.info("Open URL:" + url);
        driver.get(url);
    }

    public void clickSignIn() {
        logger.info("Click sign in");
        driver.findElement(By.xpath(signIn)).click();
    }

    public void clickCandidateProfileSignIn() {
        logger.info("Click Sign in to candidate's profile");
        driver.findElement(By.xpath(candidateProfileSignIn)).click();
    }

    public void clickSingInByEmail() {
        logger.info("Click Sign in using email");
        driver.findElement(By.xpath(singInByEmail)).click();
    }

    public void sendEmail(String email) {
        logger.info("Input Email:" + email);
        driver.findElement(By.xpath(emailInput)).sendKeys(email);
    }

    public void sendPassword(String password) {
        logger.info("Input Password:" + password);
        driver.findElement(By.xpath(passwordInput)).sendKeys(password);
    }

    public void clickSignInButton() {
        Driver.waiter(signInToAccountButton);
        logger.info("Click Sign in to account");
        driver.findElement(By.xpath(signInToAccountButton)).click();

    }

    public String getSignInError() {
        Driver.waiter(signInError);
        String errorMessage = driver.findElement(By.xpath(signInError)).getText();
        logger.info("Get SignIn error:" + errorMessage);
        return errorMessage;
    }

    public String getEmailError() {
        return driver.findElement(By.xpath(emailError)).getText();
    }

    public String getPasswordError() {
        return driver.findElement(By.xpath(passwordError)).getText();
    }

    public void sendKeyPositionSearchInput(String position) {
        logger.info("Input Position:" + position);
        driver.findElement(By.xpath(searchInput)).sendKeys(position, Keys.ENTER);
    }

    public void goToLoginPage() {
        getUrl();
        clickSignIn();
        clickCandidateProfileSignIn();
        clickSingInByEmail();
    }

    public String getOfferSize() {
        driver.findElement(By.xpath(turnEmailNotification));
        return driver.findElement(By.xpath(offerSize)).getText();
    }

    public List<WebElement> getOffersListByPositionSearch() {
        logger.info("Get offer list");
        driver.findElement(By.xpath(turnEmailNotification));
        return driver.findElements(By.xpath(offerRecord));
    }

    public void clickTopCompaniesButton() {
        logger.info("Click Top companies button");
        driver.findElement(By.xpath(topCompaniesButton)).click();
    }

    public void sendKeySearchCompanyInput(String keyword) {
        logger.info("Input Company name by keyword:" + keyword);
        driver.findElement(By.xpath(searchCompanyInput)).sendKeys(keyword, Keys.ENTER);
    }

    public List<WebElement> getListOfCompanyByKeyword() {
        driver.findElement(By.xpath(afterSearchCompanyDiv));
        logger.info("Get list of Company by keyword");
        return driver.findElements(By.xpath(listOfCompany));
    }

    public void clickStartupButton() {
        Driver.waiter(startupButton);
        logger.info("Click Startup button");
        driver.findElement(By.xpath(startupButton)).click();
    }

    public List<String> getListOfCompanyByName() {
        driver.findElement(By.xpath(afterSearchCompanyDiv));
        List<String> stringList = new ArrayList<>();
        logger.info("Start add element to Company list");
        for (WebElement wb : driver.findElements(By.xpath(companyName))
        ) {
            stringList.add(wb.getText());
            logger.info(wb.getText());
        }
        Collections.sort(stringList);
        logger.info("Get list of company by name");
        return stringList;
    }

    public String getFirstCompanyName() {
        logger.info("Find first element by company name");
        String firstCompanyName = getListOfCompanyByKeyword().getFirst().findElement(By.xpath(companyName)).getText();
        logger.info(firstCompanyName);
        return firstCompanyName;
    }

    public String getFirstPositionName() {
        logger.info("Find first element by position name");
        String firstPositionName = getOffersListByPositionSearch().getFirst().findElement(By.xpath(positionName)).getText();
        logger.info(firstPositionName);
        return firstPositionName;

    }
}


