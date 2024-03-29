package by.itacademy.kishkevich.justjoinitproject.pages;

import by.itacademy.kishkevich.justjoinitproject.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.List;

public class JustJoinItPage {
    private WebDriver driver;
    private String url = "https://justjoin.it/";
    private By signInButton = By.xpath("//button[text()='Sign in']");
    private By candidateProfileSignInButton = By.xpath("//p[text()=\"Sign in to Candidate's profile\"]");
    private By signInByEmailButton = By.xpath("//button[text()='Sign in using address email']");
    private By emailInput = By.xpath("//*[@id=':r1:']");
    private By passwordInput = By.xpath("//*[@id=':r2:']");
    private By signInToAccountButton = By.xpath("//button[@tabindex='0' and @type='submit' and text()='Sign in']");
    private By subscribeButton = By.xpath("//button[@name='job_alerts_switcher_popup_button']");
    private By signInError = By.xpath("//p[text()='Wrong email, password or account not verified.']");
    private By emailError = By.xpath("//*[@id=':r1:-helper-text']");
    private By passwordError = By.xpath("//*[@id=':r2:-helper-text']");
    private By searchInput = By.xpath("//input[@placeholder='Search']");
    private By offerSize = By.xpath("//button[@tabindex='0' and @role='tab']/span");
    private By topCompaniesButton = By.xpath("//a[@class='header_brandStory_link']");
    private By getStartedButton = By.xpath("//button[text()='Get started']");
    private By searchCompanyInput = By.xpath("//input[@placeholder='Search company']");
    private By listOfCompany = By.xpath("//div[@data-page='1']");
    private By turnEmailNotificationButton = By.xpath("//span[text()='Add an e-mail notification, and we will inform you about new job offers according to the given criteria.']");
    private By startupButton = By.xpath("//button[text()='Startup']");
    private By checkStartupSearchEnd = By.xpath("//iframe[5]");
    private By startupSpanAvailible = By.xpath("//span[text()='Startup']");
    private By offerRecord = By.xpath("//div[@data-test-id='virtuoso-item-list']/div");
    private By afterSearchCompanyDiv = By.xpath("//div[@style='display: block;']");
    private By companyName = By.xpath(".//h6");
    private By positionName = By.xpath(".//h2");
    private static final Logger LOGGER = LogManager.getLogger();

    public JustJoinItPage() {
        this.driver = Driver.getDriver();
        LOGGER.info("Start new case and create WebDriver");
    }

    public void getUrl() {
        LOGGER.info("Open URL: " + url);
        driver.get(url);
    }

    public void clickSignIn() {
        LOGGER.info("Clicking on Sign in button");
        driver.findElement(signInButton).click();
    }

    public void clickCandidateProfileSignIn() {
        LOGGER.info("Clicking on Sign in to Candidate's profile");
        driver.findElement(candidateProfileSignInButton).click();
    }

    public void clickSignInByEmail() {
        LOGGER.info("Clicking on Sign in using email address");
        driver.findElement(signInByEmailButton).click();
    }

    public void sendEmail(String email) {
        LOGGER.info("Input Email: " + email);
        driver.findElement(emailInput).sendKeys(email);
    }

    public void sendPassword(String password) {
        LOGGER.info("Input Password: " + password);
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickSignInButton() {
        LOGGER.info("Clicking on Sign in button");
        driver.findElement(signInToAccountButton).click();
    }

    public String getSignInError() {
        driver.findElement(signInError).click();
        String errorMessage = driver.findElement(signInError).getText();
        LOGGER.info("Get Sign in error: " + errorMessage);
        return errorMessage;
    }

    public String getEmailError() {
        return driver.findElement(emailError).getText();
    }

    public String getPasswordError() {
        return driver.findElement(passwordError).getText();
    }

    public void sendKeyPositionSearchInput(String position) {
        LOGGER.info("Input Position: " + position);
        driver.findElement(searchInput).sendKeys(position, Keys.ENTER);
    }

    public void goToLoginPage() {
        getUrl();
        clickSignIn();
        clickCandidateProfileSignIn();
        clickSignInByEmail();
    }

    public void checkPageUpdateAfterSearch() {
        driver.findElement(turnEmailNotificationButton);
        driver.findElement(subscribeButton);
    }

    public String getOfferSize() {
        checkPageUpdateAfterSearch();
        LOGGER.info("Get offer size");
        return driver.findElement(offerSize).getText();
    }

    public List<WebElement> getOffersListByPositionSearch() {
        checkPageUpdateAfterSearch();
        LOGGER.info("Get offer list");
        return driver.findElements(offerRecord);
    }

    public void clickTopCompaniesButton() {
        LOGGER.info("Clicking on Top companies button");
        driver.findElement(topCompaniesButton).click();
        driver.findElement(getStartedButton);
    }

    public void sendKeySearchCompanyInput(String keyword) {
        LOGGER.info("Input Company name keyword: " + keyword);
        driver.findElement(searchCompanyInput).sendKeys(keyword, Keys.ENTER);
    }

    public List<WebElement> getListOfCompanyByKeyword() {
        driver.findElement(afterSearchCompanyDiv);
        LOGGER.info("Get list of Company by keyword");
        return driver.findElements(listOfCompany);
    }

    public void clickStartupButton() {
        LOGGER.info("Clicking on Startup button");
        driver.findElement(startupButton).click();
        driver.findElement(checkStartupSearchEnd);
    }

    public SortedSet<String> getListOfCompanyByName() {
        driver.findElement(afterSearchCompanyDiv);
        SortedSet<String> stringList = new TreeSet<>();
        LOGGER.info("Start adding elements to Company list");
        for (WebElement wb : driver.findElements(companyName)) {
            stringList.add(wb.getText());
            LOGGER.info(wb.getText());
        }
        LOGGER.info("Get list of companies by name");
        return stringList;
    }

    public String getFirstCompanyName() {
        driver.findElement(startupSpanAvailible);
        LOGGER.info("Find first element by company name");
        String firstCompanyName = getListOfCompanyByKeyword().getFirst().findElement(companyName).getText();
        LOGGER.info(firstCompanyName);
        return firstCompanyName;
    }

    public String getFirstPositionName() {
        LOGGER.info("Find first element by position name");
        String firstPositionName = getOffersListByPositionSearch().getFirst().findElement(positionName).getText();
        LOGGER.info(firstPositionName);
        return firstPositionName;
    }
}