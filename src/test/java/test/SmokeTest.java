package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.DashboardPage;
import page.LoginPage;
import utils.BaseTest;

public class SmokeTest extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @Test
    public void smoke() {
        driver.get("url");
        loginPage = new LoginPage();
        loginPage.getloginInput().sendKeys("email");
        loginPage.getPassInput().sendKeys("pass");
        loginPage.getLoginButton().click();

        dashboardPage = new DashboardPage();
        Assert.assertEquals(dashboardPage.isOpened(), true);
    }
}
