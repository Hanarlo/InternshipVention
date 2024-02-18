package page;

import elements.table.Table;
import org.openqa.selenium.By;
import utils.BasePage;

public class TablePage extends BasePage {

    private By tableLocator = By.cssSelector(".table100");

    public Table getTable() {
        return new Table(webDriver, tableLocator);
    }
}
