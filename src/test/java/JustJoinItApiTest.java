import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class JustJoinItApiTest {

    @Test
    public void testLogin() {
        String requestBody = "{\n" +
                "    \"email\": \"qwerwqer@mail.be\",\n" +
                "    \"password\": \"qwerqwer\"\n" +
                "}";

        given()
                .header("Content-type", "application/json")
                .body(requestBody)
                .when()
                .post("https://profile.justjoin.it/api/justjoinit/authentication/login")
                .then()
                .assertThat().statusCode(401);;
    }
}
