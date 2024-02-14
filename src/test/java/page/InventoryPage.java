package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

import java.util.List;

public class InventoryPage extends BasePage {

    @FindAll({
            @FindBy(className = "inventory_item_description")
    })
    public List<WebElement> items;

    public InventoryPage(WebDriver driver){
        super(driver);
    }
}
