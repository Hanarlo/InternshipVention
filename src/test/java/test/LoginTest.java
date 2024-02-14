package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.InventoryPage;
import page.LoginPage;
import utils.BaseTest;

public class LoginTest extends BaseTest {


    @Test
    public void loginTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginInput.sendKeys("standard_user");
        loginPage.passwordInput.sendKeys("secret_sauce");
        loginPage.loginButton.click();
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.items.size(), 6);
    }
}
