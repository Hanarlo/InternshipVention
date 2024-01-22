package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.LoginPage;
import step.LoginStep;
import utils.BaseTest;

public class LoginTest extends BaseTest {

    private LoginStep loginStep;

    @BeforeMethod
    public void setUpMethod(){
        loginStep = new LoginStep(new LoginPage());
        driver.get("https://uyfiytfuyl.testrail.io/index.php?/auth/login/LWZhMDA0NWExYzgyM2UyNWUzMDVjMjE3ZmRjNzU1ZWEzMjJkOTZmNWY1MWEwODk0MDNjZDJhN2E1NTQ2YTEzM2Y:");
    }

    @Parameters({"email", "psw"})
    @Test(groups = {"login"})
    public void loginTest(String email, String psw) throws InterruptedException {
        loginStep.performLogin(email, psw);
        Assert.assertEquals(driver.getCurrentUrl(), "https://uyfiytfuyl.testrail.io/index.php?/dashboard");
    }
}
