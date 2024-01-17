package ui;

import domain.Candidate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.JustJoinItPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JustJoinItTest extends BaseTest{
    private final String testCandidateLoginExpectedResult = "Wrong email, password or account not verified.";
    private final String testCandidateLoginWithEmptyFieldsExpectedResult = "This field is required.";
    private final String testCandidateLoginWithWrongEmailExpectedResult = "Invalid email address.";

    private final String testPositionSearch = "Senior QA Automation Engineer";
    private final String testCompanySearch = "Software";


    @Test
    public void testCandidateLogin() {
        JustJoinItPage justJoinItPage = new JustJoinItPage();
        justJoinItPage.getUrl();
        justJoinItPage.clickSignIn();
        justJoinItPage.clickCandidateProfileSignIn();
        justJoinItPage.clickSingInByEmail();
        justJoinItPage.sendEmail(Candidate.getEmail());
        justJoinItPage.sendPassword(Candidate.getPassword());
        justJoinItPage.clickSignInButton();
        Assertions.assertEquals(testCandidateLoginExpectedResult, justJoinItPage.getSignInError());
    }

    @Test
    public void testCandidateLoginWithEmptyPassword() {
        JustJoinItPage justJoinItPage = new JustJoinItPage();
        justJoinItPage.getUrl();
        justJoinItPage.clickSignIn();
        justJoinItPage.clickCandidateProfileSignIn();
        justJoinItPage.clickSingInByEmail();
        justJoinItPage.sendEmail(Candidate.getEmail());
        justJoinItPage.clickSignInButton();
        Assertions.assertEquals(testCandidateLoginWithEmptyFieldsExpectedResult, justJoinItPage.getPasswordError());
    }

    @Test
    public void testCandidateLoginWithEmptyLogin() {
        JustJoinItPage justJoinItPage = new JustJoinItPage();
        justJoinItPage.getUrl();
        justJoinItPage.clickSignIn();
        justJoinItPage.clickCandidateProfileSignIn();
        justJoinItPage.clickSingInByEmail();
        justJoinItPage.sendPassword(Candidate.getPassword());
        justJoinItPage.clickSignInButton();
        Assertions.assertEquals(testCandidateLoginWithEmptyFieldsExpectedResult, justJoinItPage.getEmailError());
    }

    @Test
    public void testCandidateLoginWithWrongLogin() {
        JustJoinItPage justJoinItPage = new JustJoinItPage();
        justJoinItPage.getUrl();
        justJoinItPage.clickSignIn();
        justJoinItPage.clickCandidateProfileSignIn();
        justJoinItPage.clickSingInByEmail();
        justJoinItPage.sendEmail(Candidate.getWrongEmail());
        justJoinItPage.clickSignInButton();
        Assertions.assertEquals(testCandidateLoginWithWrongEmailExpectedResult, justJoinItPage.getEmailError());
    }

    @Test
    public void testSearch1() throws InterruptedException {
        JustJoinItPage justJoinItPage = new JustJoinItPage();
        justJoinItPage.getUrl();
        justJoinItPage.sendKeySearchInput(testPositionSearch);
        Thread.sleep(1000);
        Assertions.assertEquals("52 offers", justJoinItPage.getOfferSize());
    }

    @Test
    public void testSearch2() {
        JustJoinItPage justJoinItPage = new JustJoinItPage();
        justJoinItPage.getUrl();
        justJoinItPage.clickTopCompaniesButton();
        justJoinItPage.sendKeySearchCompanyInput(testCompanySearch);
        Assertions.assertEquals(10, justJoinItPage.listOfCompany().size());
    }
    @Test
    public void testSearch3() {
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
        Assertions.assertEquals(expectedList, justJoinItPage.listOfCompany2());
    }
}
