package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox {

    private UIElement uiElement;

    public CheckBox(WebDriver driver, By locator) {
        uiElement = new UIElement(driver, locator);
    }

    public CheckBox(WebDriver driver, WebElement element) {
        uiElement = new UIElement(driver, element);
    }

    public void click() {
        uiElement.click();
    }
}