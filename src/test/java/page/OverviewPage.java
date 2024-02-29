package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BasePage;

public class OverviewPage extends BasePage {

    private By successBannerLocator = By.cssSelector(".message");
    private By deleteBtnLocator = By.xpath("//tr[@class = 'even hoverSensitive']/td[@class='action'][2]");
    private By checkboxLocator = By.xpath("//span[@class = 'dialog-confirm']/strong[contains(text(), 'Yes')]");
    private By confirmButtonLocator = By.xpath("//a[@data-testid = 'caseFieldsTabDeleteDialogButtonOk']");

    public Boolean isBannerOnPage(){
        return isItemOnAPage(successBannerLocator);
    }
    public WebElement getDeleteBtn(){
        return service.waitForVisibilityByLocator(deleteBtnLocator);
    }
    public WebElement getCheckbox(){
        return service.waitForVisibilityByLocator(checkboxLocator);
    }
    public WebElement getConfirmButton(){
        return service.waitForVisibilityByLocator(confirmButtonLocator);
    }
}
