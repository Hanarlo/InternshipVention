package api_tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {

    private final static String key = System.getProperty("apiKey");

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri("https://app.testiny.io/api/v1/")
                .setContentType(ContentType.JSON)
                .addHeader("X-Api-Key", key)
                .build();
    }

    public static void installSpecification(RequestSpecification req, ResponseSpecification res) {
        RestAssured.requestSpecification = req;
        RestAssured.responseSpecification = res;
    }

    public static ResponseSpecification responseSpecification200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    public static ResponseSpecification responseSpecification404() {
        return new ResponseSpecBuilder()
                .expectStatusCode(404)
                .build();
    }
}
