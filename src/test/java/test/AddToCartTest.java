package test;

import bse_entity.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTestClass {

    @Test(dependsOnGroups = {"login"}, groups = "addToCart")
    public void addToCartTest() {
        collectionPage.addBackPackToCart();
        Assert.assertEquals(headBar.getNumOfGoodsInCart().getText(), "1");
    }
}
