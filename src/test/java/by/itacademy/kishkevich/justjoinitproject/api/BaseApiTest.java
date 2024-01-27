package by.itacademy.kishkevich.justjoinitproject.api;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    private static final String URL = "https://profile.justjoin.it/api/justjoinit/authentication/login";

    public static void loginMethod(String getBody, int getStatusCode) {
        given()
                .header("Content-type", "application/json")
                .body(getBody)
                .when()
                .post(URL)
                .then()
                .assertThat().statusCode(getStatusCode);
    }
}
