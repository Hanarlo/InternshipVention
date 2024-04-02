package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BasePage;

public class DashboardPage extends BasePage {

    private final By projectSettingButton = By.cssSelector(".sidebar-settings");
    private final By testCasesButton = By.cssSelector("li[data-testid='item-testcases']");

    private final By greetingLocator = By.cssSelector("h1[data-testid='text-dashboard-header-content']");

    public WebElement getProjectSettingsButton() {
        return wait.waitUntilVisibleByLocator(projectSettingButton);
    }

    public WebElement getTestCasesButton() {
        return wait.waitUntilVisibleByLocator(testCasesButton);
    }

    public WebElement getGreeting() {
        return wait.waitUntilVisibleByLocator(greetingLocator);
    }
}
