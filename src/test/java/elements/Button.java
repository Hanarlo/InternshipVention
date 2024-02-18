package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Button {

    private UIElement uiElement;

    public Button(WebDriver driver, By locator) {
        uiElement = new UIElement(driver, locator);
    }

    public Button(WebDriver driver, WebElement element) {
        uiElement = new UIElement(driver, element);
    }

    public void click() {
        uiElement.click();
    }
}