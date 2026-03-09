import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

class PostmanEchoRequestMethodsTest {
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGetRequest() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                    .get("/get")
                .then()
                     .statusCode(200)
                     .contentType(ContentType.JSON)
                     .body("args.foo1", equalTo("bar1"))
                     .body("args.foo2", equalTo("bar2"))
                     .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }
    @Test
    public void testPostRawText() {
        String requestBody = "{\"test\":\"value\"}";
        given()
                .contentType("text/plain")
                .body(requestBody)
                .when()
                    .post("/post")
                .then()
                      .statusCode(200)
                      .contentType(ContentType.JSON)
                .body("data", containsString("test"))
                .body("data", containsString("value"))
                .body("headers.content-type", containsString("text/plain"))
                .body("url", equalTo("https://postman-echo.com/post"));

    }
    @Test
    public void testPostFormData() {
        given()
                .contentType(ContentType.MULTIPART)
                .multiPart("foo1", "bar1")
                .multiPart("foo2", "bar2")
                .when()
                   .post("/post")
                   .then()
                   .statusCode(200)
                   .contentType(ContentType.JSON)
                   .body("form.foo1", equalTo("bar1"))
                   .body("form.foo2", equalTo("bar2"))
                   .body("url", equalTo("https://postman-echo.com/post"));
    }
    @Test
    public void testPutRequest () {
        String requestBody = "This is expected to be sent back as part of response body.";
        given()
                .contentType("text/plain")
                .body(requestBody)
                .when()
                   .put("/put")
                .then()
                    .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", equalTo(requestBody))
                .body("url", equalTo("https://postman-echo.com/put"));
    }
    @Test
    public void testPatchRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";
        given()
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", equalTo(requestBody))
                .body("url", equalTo("https://postman-echo.com/patch"));
    }
    @Test
    public void testDeleteRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";
        given()
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .delete("/delete")
                .then()
                   .statusCode(200)
                   .contentType(ContentType.JSON)
                .body("data", equalTo(requestBody))
                .body("url", equalTo("https://postman-echo.com/delete"));
    }
    }