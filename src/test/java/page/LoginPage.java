package page;

import elements.Button;
import elements.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Text;
import utils.BasePage;

public class LoginPage extends BasePage {

    private By emailInputLocator = By.id("name");
    private By pswInputLocator = By.id("password");
    private By loginBtn = By.id("button_primary");

    public WebElement getEmailInput() {
        return webDriver.findElement(emailInputLocator);
    }
    public TextInput getPassInput() {
        return new TextInput(webDriver, pswInputLocator);
    }
    public Button getLoginButton() {
        return new Button(webDriver, loginBtn);
    }
}
