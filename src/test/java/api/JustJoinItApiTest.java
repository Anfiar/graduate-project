package api;

import domain.JsonBodyGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import pages.JustJoinItPage;

import static io.restassured.RestAssured.given;

public class JustJoinItApiTest extends BaseApiTest {
    private static final Logger logger = LogManager.getLogger(JustJoinItPage.class);
    @Test
    public void testLogin1() {
        String requestBody = String.valueOf(JsonBodyGenerator.getRandomJsonByEmailAndPassword());
        int statusCode = 401;
        logger.info("requestBody:" + requestBody);
        loginMethod(requestBody, statusCode);
    }

    @Test
    public void testLogin2() {
        String requestBody = "{\n" +
                "    \"email\": \"qwerwqer@mail.be\",\n" +
                "    \"password\": \"qwerqwer\",\n" +
                "    \"name\":\"testing\"\n" +
                "}";
        int statusCode = 401;
        loginMethod(requestBody, statusCode);
    }

    @Test
    public void testLogin3() {
        String requestBody = "";

        given()
                .header("Content-type", "application/json")
                .body(requestBody)
                .when()
                .post("https://profile.justjoin.it/api/justjoinit/authentication/login")
                .then()
                .assertThat().statusCode(415);
    }

    @Test
    public void testLogin4() {
        String requestBody = "{}";

        given()
                .header("Content-type", "application/json")
                .body(requestBody)
                .when()
                .post("https://profile.justjoin.it/api/justjoinit/authentication/login")
                .then()
                .assertThat().statusCode(422);
    }

    @Test
    public void testLogin5() {
//        String requestBody = "{\n" +
//                "    \"password\": \"qwerqwer\"\n" +
//                "}";
//
//        given()
//                .header("Content-type", "application/json")
//                .body(requestBody)
//                .when()
//                .post("https://profile.justjoin.it/api/justjoinit/authentication/login")
//                .then()
//                .assertThat().statusCode(422);

        String requestBody = String.valueOf(JsonBodyGenerator.getRandomJsonByFields("password"));
        int statusCode = 422;
        loginMethod(requestBody, statusCode);
    }

    @Test
    public void testLogin6() {
        String requestBody = "{\n" +
                "    \"email\": \"qwerwqer\",\n" +
                "    \"password\": \"qwerqwer\"\n" +
                "}";

        given()
                .header("Content-type", "application/json")
                .body(requestBody)
                .when()
                .post("https://profile.justjoin.it/api/justjoinit/authentication/login")
                .then()
                .assertThat().statusCode(401);
    }

    @Test
    public void testLogin7() {
        String requestBody = "{\n" +
                "    \"email\": 1234,\n" +
                "    \"password\": \"\"\n" +
                "}";

        given()
                .header("Content-type", "application/json")
                .body(requestBody)
                .when()
                .post("https://profile.justjoin.it/api/justjoinit/authentication/login")
                .then()
                .assertThat().statusCode(415);
    }

    @Test
    public void testLogin8() {
        String requestBody = "{\n" +
                "    \"email\": \"1234\",\n" +
                "    \"password\": 1234\n" +
                "}";

        given()
                .header("Content-type", "application/json")
                .body(requestBody)
                .when()
                .post("https://profile.justjoin.it/api/justjoinit/authentication/login")
                .then()
                .assertThat().statusCode(415);
    }

    @Test
    public void testLogin9() {
        String requestBody = "{\n" +
                "    \"email\": null,\n" +
                "    \"password\": null\n" +
                "}";

        given()
                .header("Content-type", "application/json")
                .body(requestBody)
                .when()
                .post("https://profile.justjoin.it/api/justjoinit/authentication/login")
                .then()
                .assertThat().statusCode(422);
    }

    @Test
    public void testLogin10() {
        String requestBody = "{\n" +
                "    \"email\": \"asrru@asdf.be\"\n" +
                "}";

        given()
                .header("Content-type", "application/json")
                .body(requestBody)
                .when()
                .post("https://profile.justjoin.it/api/justjoinit/authentication/login")
                .then()
                .assertThat().statusCode(422);
    }

    @Test
    public void testLogin11() {
        String requestBody = "{\n" +
                "    \"email\": \"\",\n" +
                "    \"password\": \"\"\n" +
                "}";

        given()
                .header("Content-type", "application/json")
                .body(requestBody)
                .when()
                .post("https://profile.justjoin.it/api/justjoinit/authentication/login")
                .then()
                .assertThat().statusCode(422);
        ;
    }

    @Test
    public void testLogin12() {
        String requestBody = "{\n" +
                "    \"email\": \"\",\n" +
                "    \"password\": \"qwerqwer\"\n" +
                "}";

        given()
                .header("Content-type", "application/json")
                .body(requestBody)
                .when()
                .post("https://profile.justjoin.it/api/justjoinit/authentication/login")
                .then()
                .assertThat().statusCode(422);
        ;
    }

    @Test
    public void testLogin13() {
        String requestBody = "{\n" +
                "    \"email\": \"qwerwqer@mail.be\",\n" +
                "    \"password\": \"\"\n" +
                "}";

        given()
                .header("Content-type", "application/json")
                .body(requestBody)
                .when()
                .post("https://profile.justjoin.it/api/justjoinit/authentication/login")
                .then()
                .assertThat().statusCode(422);
        ;
    }
}
