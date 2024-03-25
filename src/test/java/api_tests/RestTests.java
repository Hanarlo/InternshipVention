package api_tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.InvokedListener;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

@Epic("api get requests test")
@Listeners(InvokedListener.class)
public class RestTests {

    @Story("get account information test")
    @Test
    public void getAccountInfo() {
        Specifications.installSpecification(Specifications.requestSpecification(), Specifications.responseSpecification200());
        given().when().get("account/me").then().body("email", equalTo("chichaevwork@gmail.com"), "firstName", equalTo("Yury"));
    }

    @Story("get test case by id")
    @Test
    public void getTestCaseInfoTest() {
        Specifications.installSpecification(Specifications.requestSpecification(), Specifications.responseSpecification200());
        given().when().get("testcase/81").then().body("title", equalTo("ghf"), "$owner_name", equalTo("Yury ChyChayeu"));
    }

    @Story("get test plan by id")
    @Test
    public void getTestPlanTest() {
        Specifications.installSpecification(Specifications.requestSpecification(), Specifications.responseSpecification200());
        given().when().get("testplan/1").then().body("title", equalTo("Smoketest"), "created_at", equalTo("2024-03-15T09:12:28.189Z"));
    }

    @Story("get test plan with incorrect ID")
    @Test
    public void getTestPlanWithIncorrectId() {
        Specifications.installSpecification(Specifications.requestSpecification(), Specifications.responseSpecification404());
        given().when().get("testplan/99").then().body("message", equalTo("The entity with id 99 was not found."));
    }

    @Story("Post request on get url")
    @Test
    public void postRequestOnGetUrlTest() {
        Specifications.installSpecification(Specifications.requestSpecification(), Specifications.responseSpecification404());
        given().when().post("testcase/85").then().body("message", equalTo("Api route to 'POST' for '/testcase/85' not found"));
    }

    @Story("Post request for Test Case create")
    @Test
    public void PostRequestForTestCaseCreateTest() {
        String today = LocalDate.now().toString();
        Specifications.installSpecification(Specifications.requestSpecification(), Specifications.responseSpecification200());
        given().body("{\n" + "    \"title\": \"TestCaseFromRest\",\n" + "    \"project_id\" : 1\n" + "}").when().post("testcase").then().body("title", equalTo("TestCaseFromRest"), "created_at", containsString(today));
    }
}
