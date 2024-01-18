package test;

import bse_entity.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveFromCartTest extends BaseTestClass {

    @Test(dependsOnGroups = {"addToCart"})
    public void removeFromCart(){
        headBar.getCartBtn().click();
        cartPage.getRemoveFromCartBtn().click();
        Assert.assertTrue(headBar.isNumOfGoodsInvisible());
    }
}
