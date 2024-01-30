package by.itacademy.kishkevich.justjoinitproject.api;

import by.itacademy.kishkevich.justjoinitproject.domain.JsonBodyGenerator;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BaseApiTest {
    private static final String URL = "https://profile.justjoin.it/api/justjoinit/authentication/login";
    protected final JsonBodyGenerator jsonBodyGenerator;

    public BaseApiTest() {
        this.jsonBodyGenerator = new JsonBodyGenerator();
    }

    public static void loginMethodCheckStatusCode(String body, int statusCode) {
        given()
                .header("Content-type", "application/json")
                .body(body)
                .when()
                .post(URL)
                .then()
                .assertThat().statusCode(statusCode);
    }

    public static void loginMethodCheckResponse(String body) {
        given()
                .header("Content-type", "application/json")
                .body(body)
                .when()
                .post(URL)
                .then()
                .assertThat()
                .body("error[0]", equalTo("'Email' must not be empty."))
                .body("error[1]", equalTo("'Password' must not be empty."));
    }
}
