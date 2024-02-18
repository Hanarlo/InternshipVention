package page;

import elements.Button;
import elements.DropDown;
import elements.RadioButtonTable;
import elements.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BasePage;

public class AddProjectPage extends BasePage {

    private By nameInputLocator = By.id("name");
    private By accessBtnLocator = By.id("projects-tabs-access");
    private By accessDropdownBtnLocator = By.className("dropdown-icon-black");

    private By radioButtonTableLocator = By.cssSelector("div.dirty-trackable.tab.tab1 > div.table");
    private By acceptBtnLocator = By.id("accept");

    public TextInput getNameInput() {
        return new TextInput(webDriver, nameInputLocator);
    }
    public Button getAccessBtn() {
        return new Button(webDriver, accessBtnLocator);
    }

    public RadioButtonTable getRadioButtonTable() {
        return new RadioButtonTable(webDriver, radioButtonTableLocator);
    }

    public DropDown getAccessDropdownBtn() {
        return new DropDown(webDriver, accessDropdownBtnLocator);
    }

    public Button getAcceptBtn() {
        return new Button(webDriver, acceptBtnLocator);
    }

}
