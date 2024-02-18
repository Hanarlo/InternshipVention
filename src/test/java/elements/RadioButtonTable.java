package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonTable {

    private UIElement uiElement;

    public RadioButtonTable(WebDriver driver, WebElement element) {
        uiElement = new UIElement(driver, element);
    }

    public RadioButtonTable(WebDriver driver, By locator) {
        uiElement = new UIElement(driver, locator);
    }


    public void selectButtonByValue(int value) {
        uiElement.findElement(By.xpath("//input[@type='radio' and @value='" + value + "']")).click();
    }
}