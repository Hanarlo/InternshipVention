package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

public class LoginPage extends BasePage {

    protected By loginButton = By.id("button_primary");
    protected By loginInput = By.id("name");
    protected By passwordInput = By.id("password");

    public WebElement getloginInput() {
        return driver.findElement(loginInput);
    }
    public WebElement getPassInput() {
        return driver.findElement(passwordInput);
    }
    public WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }

    @Override
    protected boolean isOpened() {
        return waitService.waitForElementVisibilityByLocator(By.cssSelector(".logo")).isDisplayed();
    }
}
