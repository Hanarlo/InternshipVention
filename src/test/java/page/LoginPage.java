package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BasePage;

public class LoginPage extends BasePage {

    private By emailInputLocator = By.id("name");
    private By pswInputLocator = By.id("password");
    private By loginBtn = By.id("button_primary");

    public WebElement getEmailInput(){
        return service.waitForVisibilityByLocator(emailInputLocator);
    }
    public WebElement getPassInput(){
        return service.waitForVisibilityByLocator(pswInputLocator);
    }
    public WebElement getLoginButton(){
        return service.waitForVisibilityByLocator(loginBtn);
    }
}
