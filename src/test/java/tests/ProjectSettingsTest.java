package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.ProjectSettingsPage;
import steps.AccountSettingsStep;
import steps.DashboardStep;
import steps.IntegrationsStep;
import steps.ProjectSettingsStep;
import utils.BaseTest;
import utils.StringsProvider;

import java.awt.*;
import java.net.URISyntaxException;

@Epic("Testing for boundary values, file upload, and dialog box")
public class ProjectSettingsTest extends BaseTest {

    private DashboardStep dashboardStep;
    private ProjectSettingsStep projectSettingsStep;
    private IntegrationsStep integrationsStep;
    private AccountSettingsStep accountSettingsStep;

    @BeforeClass
    private void setUpMethod() {
        dashboardStep = new DashboardStep();
        projectSettingsStep = new ProjectSettingsStep();
        integrationsStep = new IntegrationsStep();
        accountSettingsStep = new AccountSettingsStep();
        dashboardStep.goToProjectSettings();
    }

    @Test
    @Story("checking boundary values with less then minimum")
    public void inputTwoValues() {
        projectSettingsStep.Input2Characters();
        Assert.assertTrue(projectSettingsStep.isErrorMessageVisible());
        Assert.assertFalse(projectSettingsStep.isButtonActive());
    }

    @Story("checking for boundary values")
    @Test(dependsOnMethods = "inputTwoValues", dataProviderClass = StringsProvider.class, dataProvider = "strings")
    public void boundaryValuesTest(String text) {
        projectSettingsStep.input(text);
        Assert.assertTrue(projectSettingsStep.isButtonActive());
    }

    @Story("checking boundary values with more then maximum")
    @Test(dependsOnMethods = "boundaryValuesTest")
    public void input41Value() {
        projectSettingsStep.Input41Characters();
        Assert.assertTrue(projectSettingsStep.isErrorMessageVisible());
        Assert.assertFalse(projectSettingsStep.isButtonActive());
        projectSettingsStep.resetNameInputValue();
    }

    @Story("Checking for error when trying to connect gitHub integration with defect in inputs")
    @Test(dependsOnMethods = "input41Value")
    public void gitHubIntegrationTest() {
        Assert.assertTrue(integrationsStep.connectGithubWithWrongCredentials());
    }

    @Story("Upload image")
    @Test(dependsOnMethods = "gitHubIntegrationTest")
    public void uploadImageTest() throws AWTException, InterruptedException, URISyntaxException {
        accountSettingsStep.uploadImage();
        Thread.sleep(1000);
        Assert.assertTrue(accountSettingsStep.isImageOnAPage());
    }

    @Story("checking for incorrect data")
    @Test(dependsOnMethods = "uploadImageTest", alwaysRun = true)
    public void incorrectDataTest() {
        accountSettingsStep.changeUsername();
        Assert.assertFalse(projectSettingsStep.isButtonActive());
    }

    @Story("Checking for too many characters input")
    @Test(dependsOnMethods = "incorrectDataTest")
    public void tooManeCharactersInputTest() {
        accountSettingsStep.sendManyCharactersInFirstNameInput();
        Assert.assertFalse(projectSettingsStep.isButtonActive());
    }

    @Story("checking for Dialog Box message")
    @Test(dependsOnMethods = "tooManeCharactersInputTest")
    public void DialogBoxMessageTest() {
        String title = projectSettingsStep.getTitleFromDialogBoxAndDiscardChanges();
        Assert.assertEquals(title, "Unsaved data");
    }
}
