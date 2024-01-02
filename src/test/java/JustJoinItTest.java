import domain.Candidate;
import org.junit.jupiter.api.Test;
import pages.JustJoinItPage;

public class JustJoinItTest {
    @Test
    public void testEmployerLogin(){
        JustJoinItPage justJoinItPage = new JustJoinItPage();
        justJoinItPage.getUrl();
        justJoinItPage.clickSignIn();
        justJoinItPage.clickCandidateProfileSignIn();
        justJoinItPage.clickSingInByEmail();
        justJoinItPage.sendEmail(Candidate.getEmail());
        justJoinItPage.sendPassword(Candidate.getPassword());
        justJoinItPage.clickSignInButton();
    }
}
