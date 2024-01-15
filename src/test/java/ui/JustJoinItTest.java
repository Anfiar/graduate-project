package ui;

import domain.Candidate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.JustJoinItPage;

public class JustJoinItTest extends BaseTest{
    private final String testCandidateLoginExpectedResult = "Wrong email, password or account not verified.";
    private final String testCandidateLoginWithEmptyFieldsExpectedResult = "This field is required.";
    private final String testCandidateLoginWithWrongEmailExpectedResult = "Invalid email address.";

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
    public void testSearch1() {
        JustJoinItPage justJoinItPage = new JustJoinItPage();
        justJoinItPage.getUrl();
        justJoinItPage.sendKeySearchInput("Senior QA Automation Engineer");
        String actual = justJoinItPage.getOfferSize();
        Assertions.assertEquals("52 offers", actual);
    }

    @Test
    public void testSearch2() {
        JustJoinItPage justJoinItPage = new JustJoinItPage();
        justJoinItPage.getUrl();
        justJoinItPage.clickTopCompaniesButton();
        justJoinItPage.sendKeySearchCompanyInput("Software");
        justJoinItPage.listOfCompany();
        //Assertions.assertEquals("52 offers", actual);

    }

}
