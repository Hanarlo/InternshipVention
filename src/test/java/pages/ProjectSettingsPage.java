package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BasePage;

import java.util.List;

public class ProjectSettingsPage extends BasePage {

    private final By nameInputLocator = By.cssSelector("[data-testid='textbox-name']");
    private final By popUpLocator = By.cssSelector("div[data-testid='popup-tooltip']");
    private final By saveButton = By.cssSelector("button[data-testid='button-save-entity']");

    private final By returnToDashboardButtonLocator = By.cssSelector("a[data-testid='link-back-to-app']");

    private final By dialogBoxTitleTextLocator = By.cssSelector("h4[data-testid='text-title']");
    private final By discardButtonLocator = By.cssSelector("button[data-testid='button-affirm']");


    public WebElement getNameInput() {
        return wait.waitUntilVisibleByLocator(nameInputLocator);
    }

    public WebElement getPopUp() {
        return wait.waitUntilVisibleByLocator(popUpLocator);
    }

    public WebElement getReturnToMainPageButton() {
        return wait.waitUntilVisibleByLocator(returnToDashboardButtonLocator);
    }

    public WebElement getTitleDialogBox() {
        return wait.waitUntilVisibleByLocator(dialogBoxTitleTextLocator);
    }

    public WebElement getDiscardButton() {
        return wait.waitUntilVisibleByLocator(discardButtonLocator);
    }

    public WebElement getSaveButton() {
        return wait.waitUntilVisibleByLocator(saveButton);
    }



}
