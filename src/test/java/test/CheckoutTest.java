package test;

import bse_entity.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckoutTest extends BaseTestClass {

    @Test(dependsOnGroups = {"addToCart"})
    public void checkoutStep(){
        headBar.getCartBtn().click();
        cartPage.getcheckoutBtn().click();
        checkout.getFirstNameInput().sendKeys("TestName");
        checkout.getLastNameInput().sendKeys("TestSurname");
        checkout.getPostalCodeInput().sendKeys("12345");
        checkout.getContinueBtn().click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");
        Assert.assertTrue(checkout.isItemInCheckout());

        checkout.getFinishBtn().click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html");
        Assert.assertEquals(checkout.getCompleteBanner().getText(), "Thank you for your order!");
    }
}
