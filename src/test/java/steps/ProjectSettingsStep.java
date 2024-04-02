package steps;

import io.qameta.allure.Step;
import pages.ProjectSettingsPage;

public class ProjectSettingsStep {

    private ProjectSettingsPage page;

    public ProjectSettingsStep() {
        page = new ProjectSettingsPage();
    }

    @Step("clearing name input")
    public void clearNameInputValue() {
        page.getNameInput().clear();
    }

    @Step("input characters")
    public void input(String text){
        page.getNameInput().sendKeys(text);
    }

    @Step("input 2 characters")
    public void Input2Characters() {
        clearNameInputValue();
        page.getNameInput().sendKeys("ab");
    }

    @Step("input 41 characters")
    public void Input41Characters() {
        page.getNameInput().sendKeys("q");
    }

    @Step("Reset name input value")
    public void resetNameInputValue() {
        clearNameInputValue();
        page.getNameInput().sendKeys("My Demo Project");
    }

    @Step("checking is error message is visible")
    public Boolean isErrorMessageVisible() {
        return page.getPopUp().isDisplayed();
    }

    @Step("return to main page")
    public void returnToMainPage() {
        page.getReturnToMainPageButton().click();
    }

    @Step("get text from title of dialog box and discard changes")
    public String getTitleFromDialogBoxAndDiscardChanges() {
        returnToMainPage();
        String result = page.getTitleDialogBox().getText();
        page.getDiscardButton().click();
        return result;
    }

    @Step("checking is button active")
    public Boolean isButtonActive() {
        return page.getSaveButton().isEnabled();
    }

}
