import domain.Employer;
import org.junit.jupiter.api.Test;
import pages.JustJoinItPage;

public class JustJoinItTest {
    @Test
    public void testEmployerLogin(){
        JustJoinItPage justJoinItPage = new JustJoinItPage();
        justJoinItPage.getUrl();
        justJoinItPage.clickSignIn();
        justJoinItPage.clickEmployerProfileSignIn();
        justJoinItPage.clickSingInByEmail();
        justJoinItPage.sendEmail(Employer.getEmail());
        justJoinItPage.sendPassword(Employer.getPassword());
        justJoinItPage.clickSignInButton();
    }
}
