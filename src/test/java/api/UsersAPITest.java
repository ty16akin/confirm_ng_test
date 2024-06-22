package api;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class UsersAPITest {

        @Test
        public void testGetRequest() {
            // Set the base URI, using JSONPlaceholder as an example
            RestAssured.baseURI = "http://localhost:3001/users";
            // Send a GET request and save the response
            Response response = given()
                    .when()
                    .get("/")
                    .then()
                    .extract()
                    .response();
            // Print the JSON content of the response
            System.out.println("Response JSON: " + response.asString()); // Verify that the status code is 200.
            // Validate that the status code is 200
            response.then().statusCode(200); // validate that the response has a status code of 200.
            // Validate a specific field value in the response
            Assert.assertEquals(response.getStatusCode(), 200, "Response code mismatch");
        }

    @Test
    public void testPostRequest() {
        // Set the base URI, using JSONPlaceholder as an example
        RestAssured.baseURI = "http://localhost:3001/users";

        // Set a Map object, to insert data to the request body for the Post request
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("username", "Dotun");
        requestBody.put("email", "akinlabidotun732gmail.com");
        requestBody.put("password", "akinlabidotun");

        // Sends a POST request and save the response
        Response response = given().contentType(ContentType.JSON).body(requestBody)
                .when()
                .post("")
                .then()
                .extract()
                .response();
        // Print the JSON content of the response
        System.out.println("Response JSON: " + response.asString()); // Verify that the status code is 400.
        // Validate that the status code is 400
        response.then().statusCode(200); // validate that the response has a status code of 400.
        // Validate a specific field value in the response
        Assert.assertEquals(response.getStatusCode(), 200, "Response code mismatch");
    }

    @Test
    public void testPatchRequest() {
        // Set the base URI, using JSONPlaceholder as an example
        RestAssured.baseURI = "http://localhost:3001/users";

        // Set a Map object, to insert data to the request body for the Post request
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("username", "Dotun");
        requestBody.put("email", "akinlabidotunmail.com");

        // Sends a POST request and save the response
        Response response = given().contentType(ContentType.JSON).body(requestBody)
                .when()
                .patch("/666f190f0a9fbfdda8232602")
                .then()
                .extract()
                .response();
        // Print the JSON content of the response
        System.out.println("Response JSON: " + response.asString()); // Verify that the status code is 400.
        // Validate that the status code is 400
        response.then().statusCode(200);
        // Validate a specific field value in the response
        Assert.assertEquals(response.getStatusCode(), 400, "Response code mismatch");
    }

    @Test
    public void testDeleteRequest() {
        // Set the base URI, using JSONPlaceholder as an example
        RestAssured.baseURI = "http://localhost:3001/users";

        // Sends a POST request and save the response
        Response response = given()
                .when()
                .delete("/666ee8960a9fbfdda82325fe")
                .then()
                .extract()
                .response();
        // Print the JSON content of the response
        System.out.println("Response JSON: " + response.asString()); // Verify that the status code is 400.
        // Validate that the status code is 400
        response.then().statusCode(400);
        // Validate a specific field value in the response
           Assert.assertEquals(response.getStatusCode(), 400, "Response code mismatch");

    }
}
