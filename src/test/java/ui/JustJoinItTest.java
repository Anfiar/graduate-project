package ui;

import domain.Candidate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.JustJoinItPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JustJoinItTest extends BaseTest {
    private final String testCandidateLoginExpectedResult = "Wrong email, password or account not verified.";
    private final String testCandidateLoginWithEmptyFieldsExpectedResult = "This field is required.";
    private final String testCandidateLoginWithWrongEmailExpectedResult = "Invalid email address.";
    private final String testSizeOfOfferByPositionSearchExpectedResult = "62 offers";
    private final int testSizeOfCompanyByKeyWordSearchExpectedResult = 10;
    private final String testPositionSearch = "Senior QA Automation Engineer";
    private final String testCompanySearch = "Software";
    private static final Logger logger = LogManager.getLogger(JustJoinItTest.class);

    @Test
    public void testCandidateLogin() {
        JustJoinItPage justJoinItPage = new JustJoinItPage();
        justJoinItPage.goToLoginPage();
        justJoinItPage.sendEmail(Candidate.getEmail());
        justJoinItPage.sendPassword(Candidate.getPassword());
        justJoinItPage.clickSignInButton();
        Assertions.assertEquals(testCandidateLoginExpectedResult, justJoinItPage.getSignInError());
    }

    @Test
    public void testCandidateLoginWithEmptyPassword() {
        JustJoinItPage justJoinItPage = new JustJoinItPage();
        justJoinItPage.goToLoginPage();
        justJoinItPage.sendEmail(Candidate.getEmail());
        justJoinItPage.clickSignInButton();
        Assertions.assertEquals(testCandidateLoginWithEmptyFieldsExpectedResult, justJoinItPage.getPasswordError());
    }

    @Test
    public void testCandidateLoginWithEmptyLogin() {
        JustJoinItPage justJoinItPage = new JustJoinItPage();
        justJoinItPage.goToLoginPage();
        justJoinItPage.sendPassword(Candidate.getPassword());
        justJoinItPage.clickSignInButton();
        Assertions.assertEquals(testCandidateLoginWithEmptyFieldsExpectedResult, justJoinItPage.getEmailError());
    }

    @Test
    public void testCandidateLoginWithWrongLogin() {
        JustJoinItPage justJoinItPage = new JustJoinItPage();
        justJoinItPage.goToLoginPage();
        justJoinItPage.sendEmail(Candidate.getWrongEmail());
        justJoinItPage.clickSignInButton();
        Assertions.assertEquals(testCandidateLoginWithWrongEmailExpectedResult, justJoinItPage.getEmailError());
    }

    @Test
    public void testSizeOfOfferByPositionSearch() {
        JustJoinItPage justJoinItPage = new JustJoinItPage();
        justJoinItPage.getUrl();
        justJoinItPage.sendKeySearchInput(testPositionSearch);
        Assertions.assertEquals(testSizeOfOfferByPositionSearchExpectedResult, justJoinItPage.getGetOfferSize());
    }

    @Test
    public void testNameOfFirstOfferByPositionSearch() {
        JustJoinItPage justJoinItPage = new JustJoinItPage();
        justJoinItPage.getUrl();
        justJoinItPage.sendKeySearchInput(testPositionSearch);
        justJoinItPage.getOfferSizeListByPositionSearch();
        logger.info(justJoinItPage.getOfferSizeListByPositionSearch().getFirst().getText());
        logger.info(justJoinItPage.getFirstPositionName());
        Assertions.assertTrue(justJoinItPage.getFirstPositionName().toLowerCase().contains(testPositionSearch.toLowerCase()));
    }

    @Test
    public void testSizeOfCompanyByKeyWordSearch() {
        JustJoinItPage justJoinItPage = new JustJoinItPage();
        justJoinItPage.getUrl();
        justJoinItPage.clickTopCompaniesButton();
        justJoinItPage.sendKeySearchCompanyInput(testCompanySearch);
        Assertions.assertEquals(testSizeOfCompanyByKeyWordSearchExpectedResult, justJoinItPage.getListOfCompanyByData().size());
    }

    @Test
    public void testNameOfFirstCompanyByKeyWordSearch() {
        JustJoinItPage justJoinItPage = new JustJoinItPage();
        justJoinItPage.getUrl();
        justJoinItPage.clickTopCompaniesButton();
        justJoinItPage.sendKeySearchCompanyInput(testCompanySearch);
        justJoinItPage.clickStartupAsListOfCompany();
        Assertions.assertTrue(justJoinItPage.getFirstCompanyName().contains(testCompanySearch));
    }

    @Test
    public void testNameOfCompanyListByKeyWordSearch() {
        JustJoinItPage justJoinItPage = new JustJoinItPage();
        justJoinItPage.getUrl();
        justJoinItPage.clickTopCompaniesButton();
        justJoinItPage.sendKeySearchCompanyInput(testCompanySearch);
        List<String> expectedList = new ArrayList<>();
        expectedList.add("Rumble Fish Software Development");
        expectedList.add("Software Mansion");
        expectedList.add("SoftwareOne");
        expectedList.add("The Software House");
        expectedList.add("BCF Software Sp. z o.o.");
        expectedList.add("Montrose Software( Polska) Sp.z.o.o");
        expectedList.add("Sigma Software");
        expectedList.add("Carl Zeiss IQS Software R&D Center Sp. z o.o.");
        expectedList.add("MUG Software");
        expectedList.add("DO OK • Life-changing software services");
        Collections.sort(expectedList);
        Assertions.assertEquals(expectedList, justJoinItPage.getListOfCompanyByName());
    }
}
