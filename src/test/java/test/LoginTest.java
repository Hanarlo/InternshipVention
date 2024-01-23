package test;

import bse_entity.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.DataProvider;

public class LoginTest extends BaseTestClass {

    @BeforeMethod
    public void setUrl() {
        driver.get("https://www.saucedemo.com/");
    }

    @Test(dataProvider = "standart login", dataProviderClass = DataProvider.class, groups = "login")
    public void standartLoginTest(String login, String pass) {
        loginPage.enterCredentials(login, pass);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test(dataProvider = "locked out login", dataProviderClass = DataProvider.class)
    public void lockedLoginTest(String login, String pass) {
        loginPage.enterCredentials(login, pass);
        Assert.assertEquals(loginPage.geterrorMesage().getText(),
                "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test(dataProvider = "problem login", dataProviderClass = DataProvider.class)
    public void problemLoginTest(String login, String pass) {
        loginPage.enterCredentials(login, pass);
        Assert.assertEquals(collectionPage.getImageSrc(),
                "https://www.saucedemo.com/static/media/sl-404.168b1cce.jpg");
    }
}
