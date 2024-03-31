package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BasePage;

public class TestCasesPage extends BasePage {

    //ADD CASE
    private final By addProjectQuickButtonLocator = By.cssSelector("button[data-testid='button-add-quick']");
    private final By textInputLocator = By.cssSelector("input[data-testid='textbox-quickadd']");
    private final By addTestCaseButtonLocator = By.cssSelector(".glXRhL");

    //DELETE CASE
    private final By testCaseNameLocator = By.xpath("//td//span[contains(text(), 'test')]");
    private final By buttonMoreLocator = By
            .xpath("//span[contains(text(), 'test')]/ancestor::tr//button[@data-testid='button-more']");
    private final By buttonDeleteLocator = By.xpath("//li[@data-testid='item-delete']");
    private final By buttonConfirmDeleteLocator = By.cssSelector("[data-testid='button-affirm']");

    public WebElement getQuickAddProjectButton() {
        return wait.waitUntilVisibleByLocator(addProjectQuickButtonLocator);
    }

    public WebElement getTextInput() {
        return wait.waitUntilVisibleByLocator(textInputLocator);
    }

    public WebElement getAddTestCaseButton() {
        return wait.waitUntilVisibleByLocator(addTestCaseButtonLocator);
    }


    public WebElement getMoreButton() {
        return wait.waitUntilVisibleByLocator(buttonMoreLocator);
    }

    public boolean isTestCaseExists() {
        return !driver.findElements(testCaseNameLocator).isEmpty();
    }

    public WebElement getButtonDelete() {
        return wait.waitUntilVisibleByLocator(buttonDeleteLocator);
    }

    public WebElement getButtonConfirmDelete() {
        return wait.waitUntilVisibleByLocator(buttonConfirmDeleteLocator);
    }


}
