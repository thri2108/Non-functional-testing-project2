package RestAssured.CRUDoperations;

import org.testng.annotations.Test;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class AppTest {
	private static final Logger logger = LoggerFactory.getLogger(AppTest.class);

   
    @Test(priority = 1)
    public void testGetUsers() {
        baseURI = "https://reqres.in/";

        given()
            .get("api/users?page=2")
        .then()
            .statusCode(200);

        logger.info("Test case 'testGetUsers' executed");
    }

    @Test(priority = 2)
    public void testCreateUser() {
        JSONObject request = new JSONObject();
        request.putOnce("first_name", "Thrinadh");
        request.putOnce("last_name", "Yerabolu");

        baseURI = "https://reqres.in/";

        given()
            .body(request.toString())
        .when()
            .post("api/users")
        .then()
            .statusCode(201);

        logger.info("Test case 'testCreateUser' executed");
    }
}