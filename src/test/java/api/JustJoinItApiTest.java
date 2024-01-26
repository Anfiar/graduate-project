package api;

import domain.JsonBodyGenerator;
import org.junit.jupiter.api.Test;

public class JustJoinItApiTest extends BaseApiTest {
    @Test
    public void testLogin() {
        String requestBody = String.valueOf(JsonBodyGenerator.getRandomJsonByEmailAndPassword());
        int statusCode = 401;
        loginMethod(requestBody, statusCode);
    }

    @Test
    public void testLoginWithAdditionalField() {
        String requestBody = String.valueOf(JsonBodyGenerator.getRandomJsonWithAdditionalField());
        int statusCode = 401;
        loginMethod(requestBody, statusCode);
    }

    @Test
    public void testLoginWithEmptyBody() {
        String requestBody = "";
        int statusCode = 415;
        loginMethod(requestBody, statusCode);
    }

    @Test
    public void testLoginWithEmptyJsonBody() {
        String requestBody = String.valueOf(JsonBodyGenerator.getEmptyRandomJson());
        int statusCode = 422;
        loginMethod(requestBody, statusCode);
    }

    @Test
    public void testLoginOnlyWithPassword() {
        String requestBody = String.valueOf(JsonBodyGenerator.getRandomJsonByFields("password"));
        int statusCode = 422;
        loginMethod(requestBody, statusCode);
    }

    @Test
    public void testLoginWithWrongEmailAndPassword() {
        String requestBody = String.valueOf(JsonBodyGenerator.getRandomJsonWithIncorrectValueOfField());
        int statusCode = 401;
        loginMethod(requestBody, statusCode);
    }

    @Test
    public void testLoginWithIntegerEmailValue() {
        String requestBody = String.valueOf(JsonBodyGenerator.getRandomJsonWithIntegerValueOfField("email"));
        int statusCode = 415;
        loginMethod(requestBody, statusCode);
    }

    @Test
    public void testLoginWithIntegerValueOfField() {
        String requestBody = String.valueOf(JsonBodyGenerator.getRandomJsonWithIntegerValueOfField("both"));
        int statusCode = 415;
        loginMethod(requestBody, statusCode);
    }

    @Test
    public void testLoginWithNullValueOfField() {
        String requestBody = String.valueOf(JsonBodyGenerator.getRandomJsonWithNullValueOfField());
        int statusCode = 422;
        loginMethod(requestBody, statusCode);
    }

    @Test
    public void testLoginOnlyWithEmail() {
        String requestBody = String.valueOf(JsonBodyGenerator.getRandomJsonByFields("email"));
        int statusCode = 422;
        loginMethod(requestBody, statusCode);
    }

    @Test
    public void testLoginWithEmptyValue() {
        String requestBody = String.valueOf(JsonBodyGenerator.getRandomJsonWithSomeEmptyValueOfField("both"));
        int statusCode = 422;
        loginMethod(requestBody, statusCode);
    }

    @Test
    public void testLoginWithEmptyPassword() {
        String requestBody = String.valueOf(JsonBodyGenerator.getRandomJsonWithSomeEmptyValueOfField("password"));
        int statusCode = 422;
        loginMethod(requestBody, statusCode);
    }

    @Test
    public void testLoginWithEmptyEmail() {
        String requestBody = String.valueOf(JsonBodyGenerator.getRandomJsonWithSomeEmptyValueOfField("email"));
        int statusCode = 422;
        loginMethod(requestBody, statusCode);
    }
}
