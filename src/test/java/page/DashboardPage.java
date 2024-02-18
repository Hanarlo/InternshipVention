package page;

import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BasePage;

public class DashboardPage extends BasePage {

    private By addProjectBtnLocator = By.id("sidebar-projects-add");

    public Button getAddProjectBtn() {
        return new Button(webDriver, addProjectBtnLocator);
    }
}
