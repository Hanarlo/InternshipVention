package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import utils.BasePage;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    public WebElement loginInput;

    @FindBys({
            @FindBy(className = "form_group"),
            @FindBy(id = "password")
    })
    public WebElement passwordInput;

    @FindAll({
            @FindBy(id = "gfrihgidfhnv"),
            @FindBy(name = "foidsjofjvg"),
            @FindBy(id = "login-button")
    })
    public WebElement loginButton;

    public LoginPage(WebDriver driver){
        super(driver);
        driver.get("https://www.saucedemo.com/");
    }



}
