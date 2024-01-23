package bse_entity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeadBar extends BasePage {

    private By numOfGoodsInCartLocator = By.className("shopping_cart_badge");
    private By cartBtnLocator = By.id("shopping_cart_container");

    public WebElement getNumOfGoodsInCart() {
        return service.waitForVisibilityByLocator(numOfGoodsInCartLocator);
    }
    private WebElement getCartBtn() {return service.waitForVisibilityByLocator(cartBtnLocator);}

    public HeadBar(WebDriver driver) {
        super(driver);
    }

    public Boolean isNumOfGoodsInvisible(){
        return service.waitForInvisibility(numOfGoodsInCartLocator);
    }

    public void goToCart() {
        getCartBtn().click();
    }
}
