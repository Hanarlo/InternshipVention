package api_tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/")
                .setContentType(ContentType.JSON)
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
