package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BasePage;

import java.util.List;

public class AccountSettings extends BasePage {

    private final By accountSettingButtonLocator = By.cssSelector("li[data-testid='item-profile']");
    private final By nameTextInputLocator = By.cssSelector("input[data-testid='textbox-prop-display_name']");
    private final By uploadImageInputLocator = By.xpath("//div[@data-testid='section-drop-area']/div/button");
    private final By imageLocator = By.xpath("//div[@data-testid='section-drop-area']/button/div/img");
    private final By firstNameInputLocator = By.cssSelector("input[data-testid='textbox-prop-firstName']");

    public WebElement getFirstNameInput() {
        return wait.waitUntilVisibleByLocator(firstNameInputLocator);
    }

    public WebElement getAccountSettingButton() {
        return wait.waitUntilVisibleByLocator(accountSettingButtonLocator);
    }

    public WebElement getUsernameInput() {
        return wait.waitUntilVisibleByLocator(nameTextInputLocator);
    }

    public void openUploadWindow() {
        Actions builder = new Actions(driver);

        Action myAction = builder.click(driver.findElement(uploadImageInputLocator))
                .release()
                .build();
        myAction.perform();
    }

    public List<WebElement> getImage() {
        return driver.findElements(imageLocator);
    }

}
