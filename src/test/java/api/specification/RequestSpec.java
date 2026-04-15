package api.specification;

// 👉 This is like reusable setup (same as WebDriver setup in Selenium)

import api.utils.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

    public static RequestSpecification getRequestSpec() {

        return new RequestSpecBuilder()
                .setBaseUri(ConfigReader.getProperty("base.url"))
                .addHeader("Content-Type", "application/json")
                .build();
    }
}
