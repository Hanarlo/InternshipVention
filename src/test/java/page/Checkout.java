package page;

import bse_entity.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkout extends BasePage {

    private By firstNameInputLocator = By.id("first-name");
    private By lastNameInputLocator = By.id("last-name");
    private By postalCodeInputLocator = By.id("postal-code");

    private By continueBtn = By.id("continue");
    private By finishBtn = By.id("finish");

    private By completeBanner = By.className("complete-header");
    private By ItemInCheckoutLocator = By.xpath("//a[@id='item_4_title_link']");

    public WebElement getFirstNameInput(){
        return service.waitForVisibilityByLocator(firstNameInputLocator);
    }
    public WebElement getLastNameInput(){
        return service.waitForVisibilityByLocator(lastNameInputLocator);
    }
    public WebElement getPostalCodeInput(){
        return service.waitForVisibilityByLocator(postalCodeInputLocator);
    }

    public WebElement getContinueBtn(){
        return service.waitForVisibilityByLocator(continueBtn);
    }
    public WebElement getFinishBtn(){
        return service.waitForVisibilityByLocator(finishBtn);
    }

    public WebElement getCompleteBanner(){
        return service.waitForVisibilityByLocator(completeBanner);
    }

    public Boolean isItemInCheckout(){
        return service.waitForPresence(ItemInCheckoutLocator);
    }



    public Checkout(WebDriver driver) {
        super(driver);
    }
}
