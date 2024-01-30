package by.itacademy.kishkevich.justjoinitproject.api;

import org.junit.jupiter.api.Test;

public class JustJoinItApiTest extends BaseApiTest {
    @Test
    public void testLogin() {
        String requestBody = String.valueOf(jsonBodyGenerator.getRandomJsonByEmailAndPassword());
        int statusCode = 401;
        loginMethodCheckStatusCode(requestBody, statusCode);
    }

    @Test
    public void testLoginWithAdditionalField() {
        String requestBody = String.valueOf(jsonBodyGenerator.getRandomJsonWithAdditionalField());
        int statusCode = 401;
        loginMethodCheckStatusCode(requestBody, statusCode);
    }

    @Test
    public void testLoginWithEmptyBody() {
        String requestBody = "";
        int statusCode = 415;
        loginMethodCheckStatusCode(requestBody, statusCode);
    }

    @Test
    public void testLoginWithEmptyJsonBody() {
        String requestBody = String.valueOf(jsonBodyGenerator.getEmptyRandomJson());
        loginMethodCheckResponse(requestBody);
    }

    @Test
    public void testLoginOnlyWithPassword() {
        String requestBody = String.valueOf(jsonBodyGenerator.getRandomJsonWithOneField("password"));
        int statusCode = 422;
        loginMethodCheckStatusCode(requestBody, statusCode);
    }

    @Test
    public void testLoginWithWrongEmailAndPassword() {
        String requestBody = String.valueOf(jsonBodyGenerator.getRandomJsonWithIncorrectValueOfField());
        int statusCode = 401;
        loginMethodCheckStatusCode(requestBody, statusCode);
    }

    @Test
    public void testLoginWithIntegerEmailValue() {
        String requestBody = String.valueOf(jsonBodyGenerator.getRandomJsonWithIntegerValueOfField("email"));
        int statusCode = 415;
        loginMethodCheckStatusCode(requestBody, statusCode);
    }

    @Test
    public void testLoginWithIntegerValueOfField() {
        String requestBody = String.valueOf(jsonBodyGenerator.getRandomJsonWithIntegerValueOfField("both"));
        int statusCode = 415;
        loginMethodCheckStatusCode(requestBody, statusCode);
    }

    @Test
    public void testLoginWithNullValueOfField() {
        String requestBody = String.valueOf(jsonBodyGenerator.getRandomJsonWithNullValueOfField());
        loginMethodCheckResponse(requestBody);
    }

    @Test
    public void testLoginOnlyWithEmail() {
        String requestBody = String.valueOf(jsonBodyGenerator.getRandomJsonWithOneField("email"));
        int statusCode = 422;
        loginMethodCheckStatusCode(requestBody, statusCode);
    }

    @Test
    public void testLoginWithEmptyValue() {
        String requestBody = String.valueOf(jsonBodyGenerator.getRandomJsonWithSomeEmptyValueOfField("both"));
        loginMethodCheckResponse(requestBody);
    }

    @Test
    public void testLoginWithEmptyPassword() {
        String requestBody = String.valueOf(jsonBodyGenerator.getRandomJsonWithSomeEmptyValueOfField("password"));
        int statusCode = 422;
        loginMethodCheckStatusCode(requestBody, statusCode);
    }

    @Test
    public void testLoginWithEmptyEmail() {
        String requestBody = String.valueOf(jsonBodyGenerator.getRandomJsonWithSomeEmptyValueOfField("email"));
        int statusCode = 422;
        loginMethodCheckStatusCode(requestBody, statusCode);
    }
}
