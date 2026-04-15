package api.tests;

import api.base.BaseTest;
import api.endpoints.Routes;
import api.payload.UserPayload;
import api.specification.RequestSpec;
import api.specification.ResponseSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import listeners.TestListener;
import com.aventstack.extentreports.ExtentTest;

//  given() is used to prepare the request (headers, body, base URI).
//  when() is used to send the request to the server.
//  then() is used to validate the response like status code and body.

@Listeners(TestListener.class)
public class UserTests extends BaseTest {

    @Test
    public void testGetUsers() {
        ExtentTest test = TestListener.getTest();
        test.info("Calling GET Users API");

        Response response = RestAssured
                .given()
                .spec(RequestSpec.getRequestSpec())
                .log().all()
                .when()
                .get(Routes.GET_USERS)
                .then()
                .log().all()
                .spec(ResponseSpec.getResponseSpec())
                .extract()
                .response();

        test.info("Response: " + response.asPrettyString());
        Assert.assertTrue(response.getTime() < 3000, "Response time is too high");
        String name = response.jsonPath().getString("[0].name");
        Assert.assertEquals(name, "Leanne Graham");
    }

    @Test
    public void testCreateUser()
        {
            ExtentTest test = TestListener.getTest();
            test.info("Calling Create Users API");

            String body = UserPayload.createUserPayload("Sandeep", "thesandyboi",
                    "test@gmail.com");

            Response response = RestAssured.given().spec(RequestSpec.getRequestSpec()).body(body)
                    .when().post(Routes.CREATE_USER);

            test.info("Response: " + response.asPrettyString());
            Assert.assertEquals(response.getStatusCode(), 201);
            test.info("Status Code: " + response.getStatusCode());
        }

    @Test
    public void testUpdateUser() {

        ExtentTest test = TestListener.getTest();
        test.info("Calling Update Users API");

        String body = "{ \"name\": \"Updated Name\" }";

        Response response = RestAssured
                .given()
                .spec(RequestSpec.getRequestSpec())
                .body(body)
                .pathParam("id", 1)
                .when()
                .put(Routes.UPDATE_USER);

        test.info("Response: " + response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
        test.info("Status Code: " + response.getStatusCode());

    }

    @Test
    public void testDeleteUser() {

        ExtentTest test = TestListener.getTest();
        test.info("Calling Delete Users API");

        Response response = RestAssured
                .given()
                .spec(RequestSpec.getRequestSpec())
                .pathParam("id", 1)
                .when()
                .delete(Routes.DELETE_USER);

        test.info("Response: " + response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
        test.info("Status Code: " + response.getStatusCode());
    }

    }
