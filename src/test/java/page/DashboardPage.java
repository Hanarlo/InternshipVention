package page;

import org.openqa.selenium.By;
import utils.BasePage;

public class DashboardPage extends BasePage {
    @Override
    public boolean isOpened() {
        return waitService.waitForElementVisibilityByLocator(By.id("toos")).isDisplayed();
    }
}
