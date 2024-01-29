package by.itacademy.kishkevich.justjoinitproject.api;

import by.itacademy.kishkevich.justjoinitproject.domain.JsonBodyGenerator;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    private static final String URL = "https://profile.justjoin.it/api/justjoinit/authentication/login";
    protected final JsonBodyGenerator jsonBodyGenerator;
    public BaseApiTest() {
        this.jsonBodyGenerator = new JsonBodyGenerator();
    }
    public static void loginMethod(String body, int statusCode) {
        given()
                .header("Content-type", "application/json")
                .body(body)
                .when()
                .post(URL)
                .then()
                .assertThat().statusCode(statusCode);
    }
}
