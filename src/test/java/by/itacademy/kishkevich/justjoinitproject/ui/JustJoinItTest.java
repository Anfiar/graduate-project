package by.itacademy.kishkevich.justjoinitproject.ui;

import by.itacademy.kishkevich.justjoinitproject.domain.Candidate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JustJoinItTest extends BaseTest {
    private final String WRONG_CREDENTIALS_MESSAGE = "Wrong email, password or account not verified.";
    private final String THIS_FIELD_IS_REQUIRED = "This field is required.";
    private final String INVALID_EMAIL_ADDRESS = "Invalid email address.";
    private final String AUTOMATION_ENGINEER_POSITION = "Automation Engineer";
    private final String SENIOR_QA_ENGINEER_POSITION = "Senior QA Engineer";
    private final String SOFTWARE_COMPANY_KEY_WORD = "Software";
    private final String SOLUTION_COMPANY_KEY_WORD = "Solution";
    private final String BANK_COMPANY_KEY_WORD = "Bank";
    private String sizeOfOfferByPositionSearchExpectedResult = "23 offers";
    private int sizeOfCompanyByKeyWordSearchExpectedResult = 7;

    @Test
    public void testCandidateLogin() {
        justJoinItPage.goToLoginPage();
        justJoinItPage.sendEmail(Candidate.getEmail());
        justJoinItPage.sendPassword(Candidate.getPassword());
        justJoinItPage.clickSignInButton();
        Assertions.assertEquals(WRONG_CREDENTIALS_MESSAGE, justJoinItPage.getSignInError());
    }

    @Test
    public void testCandidateLoginWithEmptyPassword() {
        justJoinItPage.goToLoginPage();
        justJoinItPage.sendEmail(Candidate.getEmail());
        justJoinItPage.clickSignInButton();
        Assertions.assertEquals(THIS_FIELD_IS_REQUIRED, justJoinItPage.getPasswordError());
    }

    @Test
    public void testCandidateLoginWithEmptyLogin() {
        justJoinItPage.goToLoginPage();
        justJoinItPage.sendPassword(Candidate.getPassword());
        justJoinItPage.clickSignInButton();
        Assertions.assertEquals(THIS_FIELD_IS_REQUIRED, justJoinItPage.getEmailError());
    }

    @Test
    public void testCandidateLoginWithWrongLogin() {
        justJoinItPage.goToLoginPage();
        justJoinItPage.sendEmail(Candidate.getWrongEmail());
        justJoinItPage.clickSignInButton();
        Assertions.assertEquals(INVALID_EMAIL_ADDRESS, justJoinItPage.getEmailError());
    }

    @Test
    public void testSizeOfOfferByPositionSearch() {
        justJoinItPage.getUrl();
        justJoinItPage.sendKeyPositionSearchInput(SENIOR_QA_ENGINEER_POSITION);
        Assertions.assertEquals(sizeOfOfferByPositionSearchExpectedResult, justJoinItPage.getOfferSize());
    }

    @Test
    public void testNameOfFirstOfferByPositionSearch() {
        justJoinItPage.getUrl();
        justJoinItPage.sendKeyPositionSearchInput(AUTOMATION_ENGINEER_POSITION);
        Assertions.assertTrue(justJoinItPage.getFirstPositionName().toLowerCase().contains(AUTOMATION_ENGINEER_POSITION.toLowerCase()));
    }

    @Test
    public void testSizeOfCompanyByKeyWordSearch() {
        justJoinItPage.getUrl();
        justJoinItPage.clickTopCompaniesButton();
        justJoinItPage.sendKeySearchCompanyInput(SOLUTION_COMPANY_KEY_WORD);
        Assertions.assertEquals(sizeOfCompanyByKeyWordSearchExpectedResult, justJoinItPage.getListOfCompanyByKeyword().size());
    }

    @Test
    public void testNameOfFirstStartUpCompanyByKeyWordSearch() {
        justJoinItPage.getUrl();
        justJoinItPage.clickTopCompaniesButton();
        justJoinItPage.sendKeySearchCompanyInput(SOFTWARE_COMPANY_KEY_WORD);
        justJoinItPage.clickStartupButton();
        Assertions.assertTrue(justJoinItPage.getFirstCompanyName().contains(SOFTWARE_COMPANY_KEY_WORD));
    }

    @Test
    public void testNameOfCompanyListByKeyWordSearch() {
        justJoinItPage.getUrl();
        justJoinItPage.clickTopCompaniesButton();
        justJoinItPage.sendKeySearchCompanyInput(BANK_COMPANY_KEY_WORD);
        List<String> expectedList = new ArrayList<>();
        expectedList.add("Nest Bank S.A.");
        expectedList.add("Bank Millennium");
        expectedList.add("mBank");
        expectedList.add("PKO Bank Polski");
        Collections.sort(expectedList);
        Assertions.assertEquals(expectedList, justJoinItPage.getListOfCompanyByName());
    }
}
