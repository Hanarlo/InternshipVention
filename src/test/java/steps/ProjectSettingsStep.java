package steps;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import pages.ProjectSettingsPage;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.URISyntaxException;
import java.util.Objects;

public class ProjectSettingsStep {

    private ProjectSettingsPage page;

    public ProjectSettingsStep() {
        page = new ProjectSettingsPage();
    }

    @Step("clearing name input")
    public void clearNameInputValue() {
        page.getNameInput().clear();
    }

    @Step("input 2 characters")
    public void Input2Characters() {
        clearNameInputValue();
        page.getNameInput().sendKeys("ab");
    }

    @Step("input 3 characters")
    public void Input3Characters() {
        clearNameInputValue();
        page.getNameInput().sendKeys("abc");
    }

    @Step("input 4 characters")
    public void Input4Characters() {
        clearNameInputValue();
        page.getNameInput().sendKeys("abcd");
    }

    @Step("input 20 characters")
    public void Input20Characters() {
        clearNameInputValue();
        page.getNameInput().sendKeys("qazwsxqazwsxqazwsxqa");
    }

    @Step("input 39 characters")
    public void Input39Characters() {
        clearNameInputValue();
        page.getNameInput().sendKeys("qazwsxqazwsxqazwsxqaqazwsxqazwsxqazwsxq");
    }

    @Step("input 40 characters")
    public void Input40Characters() {
        clearNameInputValue();
        page.getNameInput().sendKeys("qazwsxqazwsxqazwsxqaqazwsxqazwsxqazwsxqq");
    }

    @Step("input 41 characters")
    public void Input41Characters() {
        clearNameInputValue();
        page.getNameInput().sendKeys("qazwsxqazwsxqazwsxqaqazwsxqazwsxqazwsxqqq");
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

    @Step("get text from title of dialog box and discard chanes")
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
