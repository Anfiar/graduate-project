package by.itacademy.kishkevich.justjoinitproject.ui;

import by.itacademy.kishkevich.justjoinitproject.domain.Candidate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import by.itacademy.kishkevich.justjoinitproject.pages.JustJoinItPage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JustJoinItTest extends BaseTest {
    private final String WRONG_CREDENTIALS_MESSAGE = "Wrong email, password or account not verified.";
    private final String THIS_FIELD_IS_REQUIRED = "This field is required.";
    private final String INVALID_EMAIL_ADDRESS = "Invalid email address.";
    private String sizeOfOfferByPositionSearchExpectedResult = "24 offers";
    private int sizeOfCompanyByKeyWordSearchExpectedResult = 7;
    private final String SENIOR_QA_AUTOMATION_ENGINEER_POSITION = "Senior QA Automation Engineer";
    private final String SENIOR_QA_ENGINEER_POSITION = "Senior QA Engineer";
    private final String SOFTWARE_COMPANY = "Software";
    private final String SOLUTION_COMPANY = "Solution";
    private final String BANK_COMPANY = "Bank";

    private static final Logger logger = LogManager.getLogger();

    @Test
    public void testCandidateLogin() {
        JustJoinItPage justJoinItPage = new JustJoinItPage();
        justJoinItPage.goToLoginPage();
        justJoinItPage.sendEmail(Candidate.getEmail());
        justJoinItPage.sendPassword(Candidate.getPassword());
        justJoinItPage.clickSignInButton();
        Assertions.assertEquals(WRONG_CREDENTIALS_MESSAGE, justJoinItPage.getSignInError());
    }

    @Test
    public void testCandidateLoginWithEmptyPassword() {
        JustJoinItPage justJoinItPage = new JustJoinItPage();
        justJoinItPage.goToLoginPage();
        justJoinItPage.sendEmail(Candidate.getEmail());
        justJoinItPage.clickSignInButton();
        Assertions.assertEquals(THIS_FIELD_IS_REQUIRED, justJoinItPage.getPasswordError());
    }

    @Test
    public void testCandidateLoginWithEmptyLogin() {
        JustJoinItPage justJoinItPage = new JustJoinItPage();
        justJoinItPage.goToLoginPage();
        justJoinItPage.sendPassword(Candidate.getPassword());
        justJoinItPage.clickSignInButton();
        Assertions.assertEquals(THIS_FIELD_IS_REQUIRED, justJoinItPage.getEmailError());
    }

    @Test
    public void testCandidateLoginWithWrongLogin() {
        JustJoinItPage justJoinItPage = new JustJoinItPage();
        justJoinItPage.goToLoginPage();
        justJoinItPage.sendEmail(Candidate.getWrongEmail());
        justJoinItPage.clickSignInButton();
        Assertions.assertEquals(INVALID_EMAIL_ADDRESS, justJoinItPage.getEmailError());
    }

    @Test
    public void testSizeOfOfferByPositionSearch() {
        JustJoinItPage justJoinItPage = new JustJoinItPage();
        justJoinItPage.getUrl();
        justJoinItPage.sendKeySearchInput(SENIOR_QA_ENGINEER_POSITION);
        Assertions.assertEquals(sizeOfOfferByPositionSearchExpectedResult, justJoinItPage.getOfferSize());
    }

    @Test
    public void testNameOfFirstOfferByPositionSearch() {
        JustJoinItPage justJoinItPage = new JustJoinItPage();
        justJoinItPage.getUrl();
        justJoinItPage.sendKeySearchInput(SENIOR_QA_AUTOMATION_ENGINEER_POSITION);
        justJoinItPage.getOffersListByPositionSearch();
        logger.info(justJoinItPage.getOffersListByPositionSearch().getFirst().getText());
        logger.info(justJoinItPage.getFirstPositionName());
        Assertions.assertTrue(justJoinItPage.getFirstPositionName().toLowerCase().contains(SENIOR_QA_AUTOMATION_ENGINEER_POSITION.toLowerCase()));
    }

    @Test
    public void testSizeOfCompanyByKeyWordSearch() {
        JustJoinItPage justJoinItPage = new JustJoinItPage();
        justJoinItPage.getUrl();
        justJoinItPage.clickTopCompaniesButton();
        justJoinItPage.sendKeySearchCompanyInput(SOLUTION_COMPANY);
        Assertions.assertEquals(sizeOfCompanyByKeyWordSearchExpectedResult, justJoinItPage.getListOfCompanyByData().size());
    }

    @Test
    public void testNameOfFirstCompanyByKeyWordSearch() {
        JustJoinItPage justJoinItPage = new JustJoinItPage();
        justJoinItPage.getUrl();
        justJoinItPage.clickTopCompaniesButton();
        justJoinItPage.sendKeySearchCompanyInput(BANK_COMPANY);
        justJoinItPage.clickStartupAsListOfCompany();
        Assertions.assertTrue(justJoinItPage.getFirstCompanyName().contains(BANK_COMPANY));
    }

    @Test
    public void testNameOfCompanyListByKeyWordSearch() {
        JustJoinItPage justJoinItPage = new JustJoinItPage();
        justJoinItPage.getUrl();
        justJoinItPage.clickTopCompaniesButton();
        justJoinItPage.sendKeySearchCompanyInput(SOFTWARE_COMPANY);
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
