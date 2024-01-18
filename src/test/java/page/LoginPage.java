package page;

import bse_entity.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private By loginInputLocator = By.id("user-name");
    private By passInputLocator = By.id("password");
    private By buttonLocator = By.id("login-button");
    private By errorMesageLocator = By.cssSelector(".error-message-container");

    public LoginPage(WebDriver driver){
        super(driver);
    }


    private WebElement getLoginInput(){
        return service.waitForVisibilityByLocator(loginInputLocator);
    }
    private WebElement getPassInput(){
        return service.waitForVisibilityByLocator(passInputLocator);
    }
    private WebElement getButton(){
        return service.waitForVisibilityByLocator(buttonLocator);
    }

    public WebElement geterrorMesage(){
        return service.waitForVisibilityByLocator(errorMesageLocator);
    }

    public void enterCredentials(String login, String pass){
        getLoginInput().sendKeys(login);
        getPassInput().sendKeys(pass);
        getButton().click();
    }
}
