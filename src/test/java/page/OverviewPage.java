package page;

import elements.Button;
import elements.CheckBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BasePage;

public class OverviewPage extends BasePage {

    private By successBannerLocator = By.cssSelector(".message");
    private By deleteBtnLocator = By.xpath("//tr[@class = 'even hoverSensitive']/td[@class='action'][2]");
    private By checkboxLocator = By.xpath("//span[@class = 'dialog-confirm']/strong[contains(text(), 'Yes')]");
    private By confirmButtonLocator = By.xpath("//a[@data-testid = 'caseFieldsTabDeleteDialogButtonOk']");

    public Boolean isBannerOnPage() {
        return isItemOnAPage(successBannerLocator);
    }
    public Button getDeleteBtn() {
        return new Button(webDriver, deleteBtnLocator);
    }
    public CheckBox getCheckbox() {
        return new CheckBox(webDriver, checkboxLocator);
    }
    public Button getConfirmButton() {
        return new Button(webDriver, confirmButtonLocator);
    }
}
