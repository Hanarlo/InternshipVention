package elements.table;

import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TableBody {

    private UIElement uiElement;

    public TableBody(WebDriver driver, By locator) {
        uiElement = new UIElement(driver, locator);
    }

    public TableBody(WebDriver driver, WebElement element) {
        uiElement = new UIElement(driver, element);
    }

    public List<UIElement> getColumnByIndex(int index) {
        List<UIElement> columns = uiElement.findUIElements(By.tagName("tr"));
        UIElement column = columns.get(index -1);
        return column.findUIElements(By.tagName("td"));
    }

    public List<UIElement> getRowByIndex(int index) {
        return uiElement.findUIElements(By.cssSelector(".column" + index));
    }

    public UIElement getCellByRowAndColumn(int row, int column) {
        return getColumnByIndex(column).get(row -1);
    }
}