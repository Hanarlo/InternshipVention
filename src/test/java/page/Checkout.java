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

    private WebElement getFirstNameInput(){
        return service.waitForVisibilityByLocator(firstNameInputLocator);
    }
    private WebElement getLastNameInput(){
        return service.waitForVisibilityByLocator(lastNameInputLocator);
    }
    private WebElement getPostalCodeInput(){
        return service.waitForVisibilityByLocator(postalCodeInputLocator);
    }

    private WebElement getContinueBtn(){
        return service.waitForVisibilityByLocator(continueBtn);
    }
    private WebElement getFinishBtn(){
        return service.waitForVisibilityByLocator(finishBtn);
    }

    public Checkout(WebDriver driver) {
        super(driver);
    }

    public WebElement getCompleteBanner(){
        return service.waitForVisibilityByLocator(completeBanner);
    }

    public Boolean isItemInCheckout(){
        return service.waitForPresence(ItemInCheckoutLocator);
    }

    public void enterDataAndClickContinue(){
        getFirstNameInput().sendKeys("TestName");
        getLastNameInput().sendKeys("TestSurname");
        getPostalCodeInput().sendKeys("12345");
        getContinueBtn().click();
    }

    public void clickOnFInishBtn(){
        getFinishBtn().click();
    }
}
