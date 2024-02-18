package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDown{

    private UIElement uiElement;
    public Select select;

    public DropDown(WebDriver driver, By locator) {
        uiElement = new UIElement(driver, locator);
        select = new Select(uiElement);
    }

    public DropDown(WebDriver driver, WebElement element) {
        uiElement = new UIElement(driver, element);
        select = new Select(uiElement);
    }
}