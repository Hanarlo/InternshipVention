package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BasePage;

public class AddProjectPage extends BasePage {

    private By nameInputLocator = By.id("name");
    private By accessBtnLocator = By.id("projects-tabs-access");
    private By accessDropdownBtnLocator = By.className("dropdown-icon-black");
    private By designerDropdownLinkLocator = By.xpath("//a[contains(text(), 'Designer')]");
    private By acceptBtnLocator = By.id("accept");

    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getNameInput() {
        return service.waitForVisibilityByLocator(nameInputLocator);
    }
    public WebElement getAccessBtn() {
        return service.waitForVisibilityByLocator(accessBtnLocator);
    }
    public WebElement getAccessDropdownBtn() {
        return service.waitForVisibilityByLocator(accessDropdownBtnLocator);
    }
    public WebElement getDesignerDropdownMenuLink(){
        return service.waitForVisibilityByLocator(designerDropdownLinkLocator);
    }
    public WebElement getAcceptBtn() {
        return service.waitForVisibilityByLocator(acceptBtnLocator);
    }

}
