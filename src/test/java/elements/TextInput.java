package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextInput {

    private UIElement uiElement;

    public TextInput(WebDriver driver, By locator) {
        uiElement = new UIElement(driver, locator);
    }

    public TextInput(WebDriver driver, WebElement element) {
        uiElement = new UIElement(driver, element);
    }

    public void sendKeys(CharSequence... s) {
        uiElement.sendKeys(s);
    }
}
