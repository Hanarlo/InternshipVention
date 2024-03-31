package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.DashboardStep;
import steps.LoginStep;
import utils.BaseTest;

@Epic("Login testing")
public class LoginTest extends BaseTest {
    private LoginStep loginStep;
    private DashboardStep dashboardStep;

    @BeforeMethod
    private void setUpMethod() {
        dashboardStep = new DashboardStep();
        loginStep = new LoginStep();
        driver.get("https://app.testiny.io/login");
    }

    @Story("login attempt")
    @Test
    public void loginTest() {
        loginStep.performLogin(System.getProperty("email"), System.getProperty("pass"));
        Assert.assertEquals(dashboardStep.getGreetingsText(), "Hey Yury ChiChaev");
    }
}
