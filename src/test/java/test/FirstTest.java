package test;


import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPage;

public class FirstTest extends BaseTest {

    @Test
    public void firstTest(){
        LoginPage loginPage = new LoginPage();
        Assert.assertEquals(loginPage.open().login().getUrl(), "https://www.saucedemo.com/inventory.html");
    }
}
