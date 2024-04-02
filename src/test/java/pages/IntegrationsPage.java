package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BasePage;

public class IntegrationsPage extends BasePage {

    private final By integrationsMenuButtonLocator = By.cssSelector("li[data-testid='item-integrations']");
    private final By addGitHubIntegrationButtonLocator = By.cssSelector("button[data-testid='button-add-integration-github']");
    private final By urlInputLocator = By.cssSelector("input[data-testid='textbox-prop-url']");
    private final By accessCodeInputLocator = By.cssSelector("input[data-testid='textbox-prop-secret_token']");
    private final By testConnectionButton = By.cssSelector("button[data-testid='button-test-connection']");
    private final By successMessage = By.xpath("//div[contains(text(), 'Successfully connected to GitHub.')]");
    private final By closeButton = By.cssSelector("button[data-testid='button-close-entity']");

    private final By discardButtonLocator = By.cssSelector("button[data-testid='button-affirm']");


    public WebElement getIntegrationMenuButton() {
        return wait.waitUntilVisibleByLocator(integrationsMenuButtonLocator);
    }

    public WebElement getAddGitHubButton() {
        return wait.waitUntilVisibleByLocator(addGitHubIntegrationButtonLocator);
    }

    public WebElement getUrlInput() {
        return wait.waitUntilVisibleByLocator(urlInputLocator);
    }

    public WebElement getAccessCodeInput() {
        return wait.waitUntilVisibleByLocator(accessCodeInputLocator);
    }

    public WebElement getTestConnectionButton() {
        return wait.waitUntilVisibleByLocator(testConnectionButton);
    }

    public Boolean isErrorMessageOnAPage() {
        return !driver.findElements(successMessage).isEmpty();
    }

    public WebElement getCancelButton() {
        return wait.waitUntilVisibleByLocator(closeButton);
    }

    public WebElement getDiscardButton() {
        return wait.waitUntilVisibleByLocator(discardButtonLocator);
    }
}
