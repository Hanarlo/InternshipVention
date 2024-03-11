package rest_test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import specs.Specification;
import utils.Data;
import utils.SuccessCreate;
import utils.User;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.proxy;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItems;

@Log
public class RestTest {

    @Test
    @Parameters("text")
    public void textFromJenkinsTest(String text){
        System.out.println(text);
    }

    @Test
    public void createUserTest(){
        Specification.installSpecification(Specification.requestSpecification(), Specification.responseSpecification201());
        User user = new User("morpheus", "leader");
        SuccessCreate successCreate = given()
                .when()
                .body(user)
                .post("api/users")
                .then()
                .extract().as(SuccessCreate.class);
        Assert.assertEquals(successCreate.getName(), "morpheus");
    }

    @Test
    public void getUserTest(){
        Specification.installSpecification(Specification.requestSpecification(), Specification.responseSpecification200());
        Data data = given()
                .when()
                .get("api/users/2")
                .then()
                .log().all()
                .extract().body().jsonPath().getObject("data", Data.class);
        Assert.assertEquals(data.getFirst_name(), "Janet");
    }

    @Test
    public void unSuccessfulRegistration(){
        Specification.installSpecification(Specification.requestSpecification(), Specification.responseSpecification400());
        given()
                .when()
                .body("{\n" +
                        "    \"email\": \"sydney@fife\"\n" +
                        "}")
                .post("api/register")
                .then()
                .log().all();
    }

    @Test
    public void GetListOfUsersTest(){
        Specification.installSpecification(Specification.requestSpecification(), Specification.responseSpecification200());
        List<Data> data = given()
                .when()
                .get("\n" +
                        "/api/users?page=2")
                .then()
                .log().all()
                .extract().body().jsonPath().getList("data", Data.class);
        Assert.assertEquals(data.get(0).getId(), "7");
    }
}
