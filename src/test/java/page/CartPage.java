package page;

import bse_entity.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    private By removeGoodFromCartBtn = By.id("remove-sauce-labs-backpack");
    private By checkoutBtn = By.id("checkout");


    public CartPage(WebDriver driver) {
        super(driver);
    }


    public WebElement getRemoveFromCartBtn(){
        return service.waitForVisibilityByLocator(removeGoodFromCartBtn);
    }

    public WebElement getcheckoutBtn(){
        return service.waitForVisibilityByLocator(checkoutBtn);
    }
}
