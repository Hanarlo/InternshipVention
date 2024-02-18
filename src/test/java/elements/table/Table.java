package elements.table;

import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Table {

    private UIElement uiElement;
    public TableHeader tableHeader;
    public TableBody tableBody;

    public Table(WebDriver driver, By locator) {
        uiElement = new UIElement(driver, locator);
        tableBody = new TableBody(driver, uiElement.findElement(By.cssSelector("tbody")));
        tableHeader = new TableHeader(driver, uiElement.findElement(By.cssSelector("thead")));
    }

    public Table(WebDriver driver, WebElement element) {
        uiElement = new UIElement(driver, element);
        tableBody = new TableBody(driver, uiElement.findElement(By.cssSelector("tbody")));
        tableHeader = new TableHeader(driver, uiElement.findElement(By.cssSelector("thead")));
    }
}