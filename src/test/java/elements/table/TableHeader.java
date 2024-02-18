package elements.table;

import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableHeader {

    private UIElement uiElement;

    public TableHeader(WebDriver driver, By locator) {
        uiElement = new UIElement(driver, locator);
    }

    public TableHeader(WebDriver driver, WebElement element) {
        uiElement = new UIElement(driver, element);
    }

    public String getColumnHeaderTextByIndex(int index) {
        List<UIElement> headerCells = uiElement.findUIElements(By.tagName("th"));
        return headerCells.get(index -1).getText();
    }
}