package page;

import bse_entity.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CollectionPage extends BasePage {

    private By addToCartBackpackButtonLocator = By.id("add-to-cart-sauce-labs-backpack");
    private By imageLocator = By.xpath("//a[@id='item_4_img_link']/img");

    public CollectionPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getAddToCartBackpackButton(){
        return service.waitForVisibilityByLocator(addToCartBackpackButtonLocator);
    }

    public String getImageSrc(){
        return service.waitForVisibilityByLocator(imageLocator).getAttribute("src");
    }

    public void addBackPackToCart(){
        getAddToCartBackpackButton().click();
    }
}