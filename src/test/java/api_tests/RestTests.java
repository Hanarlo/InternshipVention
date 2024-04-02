package api_tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.InvokedListener;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

@Epic("api get requests test")
public class RestTests extends BaseTest {



    @Story("get account information test")
    @Test
    public void getAccountInfo() {
        Specifications.installSpecification(Specifications.requestSpecification(), Specifications.responseSpecification200());
        given().header("X-Api-Key", key).when().get("account/me").then().body("email", equalTo("chichaevwork+qaz@gmail.com"), "firstName", equalTo("Yury"));
    }

    @Story("get test case by id")
    @Test
    public void getTestCaseInfoTest() {
        Specifications.installSpecification(Specifications.requestSpecification(), Specifications.responseSpecification200());
        given().header("X-Api-Key", key).when().get("testcase/39").then().body("title", equalTo("laf"), "$owner_name", equalTo("Yury ChiChaev"));
    }

    @Story("get test plan by id")
    @Test
    public void getTestPlanTest() {
        Specifications.installSpecification(Specifications.requestSpecification(), Specifications.responseSpecification200());
        given().header("X-Api-Key", key).when().get("testplan/1").then().body("title", equalTo("Smoketest"), "created_at", equalTo("2024-03-31T19:09:44.525Z"));
    }

    @Story("get test plan with incorrect ID")
    @Test
    public void getTestPlanWithIncorrectId() {
        Specifications.installSpecification(Specifications.requestSpecification(), Specifications.responseSpecification404());
        given().header("X-Api-Key", key).when().get("testplan/99").then().body("message", equalTo("The entity with id 99 was not found."));
    }

    @Story("Post request on get url")
    @Test
    public void postRequestOnGetUrlTest() {
        Specifications.installSpecification(Specifications.requestSpecification(), Specifications.responseSpecification404());
        given().header("X-Api-Key", key).when().post("testcase/85").then().body("message", equalTo("Api route to 'POST' for '/testcase/85' not found"));
    }

    @Story("Post request for Test Case create")
    @Test
    public void PostRequestForTestCaseCreateTest() {
        String today = LocalDate.now().toString();
        Specifications.installSpecification(Specifications.requestSpecification(), Specifications.responseSpecification200());
        given().header("X-Api-Key", key).body("{\n" + "    \"title\": \"CaseFromRest\",\n" + "    \"project_id\" : 1\n" + "}").when().post("testcase").then().body("title", equalTo("CaseFromRest"), "created_at", containsString(today));
    }
}
