package com.mycompany.app;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;


public class ExampleGetTest extends BaseSetup {

    // Api Get method test
    @Test
    public void getRequest() {

        Response response = given()
                .header("Content-type", "application/json; charset=utf-8")
                .when()
                .get("comments")
                .then()
                .extract()
                .response();

        logger.info("*****Test Started*****");

        int statusCode = response.getStatusCode();
        // Check if the status code is 200
        if (statusCode == 200) {
            // Log the status code as successful
            logger.info("Status code is 200: Successful");
            // Get the body of the response as a string
            String body = response.getBody().toString();
            // Check if the body contains the expected data
            if (body.contains("[{\"userId\": 1, \"id\": 1, \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\", \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"}]")) {
                // Log the body as valid
                logger.info("Body is valid: Contains expected data");
            } else {
                // Log the body as invalid
                logger.error("Body is invalid: Does not contain expected data");
            }
            long responseTime = response.getTime();
            // Log the response time
            logger.info("Response time: " + responseTime + " ms");
            // Compare the response time with 500 milliseconds
            if (responseTime > 500) {
                // Log the response time as slow
                logger.warn("Response time is greater than 500 ms: Slow");
            } else {
                // Log the response time as normal
                logger.info("Response time is less than or equal to 500 ms: Normal");
            }

        } else {
            // Log the status code as failed
            logger.error("Status code is not 200: Failed" + statusCode);
        }

        logger.info("***** Test Finished *****");

    }

}