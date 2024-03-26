package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BasePage;

public class LoginPage extends BasePage {

    private final By emailInputLocator = By.id(":r0:");
    private final By passwordInputLocator = By.id(":r2:");
    private final By buttonLocator = By.cssSelector(".hxngFe");

    public WebElement getEmailInput() {
        return wait.waitUntilVisibleByLocator(emailInputLocator);
    }

    public WebElement getPasswordInput() {
        return wait.waitUntilVisibleByLocator(passwordInputLocator);
    }

    public WebElement getButton() {
        return wait.waitUntilClickable(buttonLocator);
    }
}
