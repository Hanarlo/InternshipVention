package test;

import org.testng.Assert;
import org.testng.annotations.*;
import page.LoginPage;
import step.LoginStep;
import io.qameta.allure.*;
import utils.BaseTest;
import utils.Listener;

@Epic("loginEpic")
public class LoginTest extends BaseTest {

    private LoginStep loginStep;

    @BeforeMethod
    @BeforeGroups
    public void setUpMethod(){
        loginStep = new LoginStep(new LoginPage());
        driver.get("https://kuyfkutful.testrail.io/index.php?/auth/login/LWZhMDA0NWExYzgyM2UyNWUzMDVjMjE3ZmRjNzU1ZWEzMjJkOTZmNWY1MWEwODk0MDNjZDJhN2E1NTQ2YTEzM2Y:");
    }

    @Test(groups = {"login"}, description = "this is testngDescription")

    @Parameters({"login", "pass"})
    @Description("this is allure description")
    @Step("loginStep")
    public void loginTest(String login, String pass) throws InterruptedException {
        loginStep.performLogin(login, pass);
        Assert.assertEquals(driver.getCurrentUrl(), "https://kuyfkutful.testrail.io/index.php?/dashboard");
    }
}
