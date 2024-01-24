package api;

import domain.JsonBodyGenerator;
import org.junit.jupiter.api.Test;

public class JustJoinItApiTest extends BaseApiTest {
    @Test
    public void testLogin1() {
        String requestBody = String.valueOf(JsonBodyGenerator.getRandomJsonByEmailAndPassword());
        int statusCode = 401;
        loginMethod(requestBody, statusCode);
    }

    @Test
    public void testLogin2() {
        String requestBody = String.valueOf(JsonBodyGenerator.getRandomJsonWithAdditionalField());
        int statusCode = 401;
        loginMethod(requestBody, statusCode);
    }

    @Test
    public void testLogin3() {
        String requestBody = "";
        int statusCode = 415;
        loginMethod(requestBody, statusCode);
    }

    @Test
    public void testLogin4() {
        String requestBody = String.valueOf(JsonBodyGenerator.getEmptyRandomJson());
        int statusCode = 422;
        loginMethod(requestBody, statusCode);
    }

    @Test
    public void testLogin5() {
        String requestBody = String.valueOf(JsonBodyGenerator.getRandomJsonByFields("password"));
        int statusCode = 422;
        loginMethod(requestBody, statusCode);
    }

    @Test
    public void testLogin6() {
        String requestBody = String.valueOf(JsonBodyGenerator.getRandomJsonWithIncorrectValueOfField());
        int statusCode = 401;
        loginMethod(requestBody, statusCode);
    }

    @Test
    public void testLogin7() {
        String requestBody = String.valueOf(JsonBodyGenerator.getRandomJsonWithIntegerValueOfField("email"));
        int statusCode = 415;
        loginMethod(requestBody, statusCode);
    }

    @Test
    public void testLogin8() {
        String requestBody = String.valueOf(JsonBodyGenerator.getRandomJsonWithIntegerValueOfField("both"));
        int statusCode = 415;
        loginMethod(requestBody, statusCode);
    }

    @Test
    public void testLogin9() {
        String requestBody = String.valueOf(JsonBodyGenerator.getRandomJsonWithNullValueOfField());
        int statusCode = 422;
        loginMethod(requestBody, statusCode);
    }

    @Test
    public void testLogin10() {
        String requestBody = String.valueOf(JsonBodyGenerator.getRandomJsonByFields("email"));
        int statusCode = 422;
        loginMethod(requestBody, statusCode);
    }

    @Test
    public void testLogin11() {
        String requestBody = String.valueOf(JsonBodyGenerator.getRandomJsonWithSomeEmptyValueOfField("both"));
        int statusCode = 422;
        loginMethod(requestBody, statusCode);
    }

    @Test
    public void testLogin12() {
        String requestBody = String.valueOf(JsonBodyGenerator.getRandomJsonWithSomeEmptyValueOfField("password"));
        int statusCode = 422;
        loginMethod(requestBody, statusCode);
    }

    @Test
    public void testLogin13() {
        String requestBody = String.valueOf(JsonBodyGenerator.getRandomJsonWithSomeEmptyValueOfField("email"));
        int statusCode = 422;
        loginMethod(requestBody, statusCode);
    }
}
