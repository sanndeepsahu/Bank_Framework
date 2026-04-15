package api.base;

//  WebDriver setup → BaseTest
//  Page Object → Routes/Payload
//  Reusable methods → Spec classes

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void setup()
    {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
}
