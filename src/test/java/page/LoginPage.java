package page;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public LoginPage open(){
        Selenide.open("https://www.saucedemo.com/");
        return this;
    }
    public InventoryPage login(){
        $(By.id("user-name")).sendKeys("standard_user");
        $(By.id("password")).sendKeys("secret_sauce");
        $(By.id("login-button")).click();
        return new InventoryPage();
    }


}
