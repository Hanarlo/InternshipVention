package steps;

import io.qameta.allure.Step;
import pages.DashboardPage;

public class DashboardStep {

    private DashboardPage page;

    public DashboardStep() {
        page = new DashboardPage();
    }

    @Step("go to project settings page")
    public void goToProjectSettings() {
        page.getProjectSettingsButton().click();
    }

    @Step("go to test cases page")
    public void goToTestCases() {
        page.getTestCasesButton().click();
    }

    @Step("get greetings text from dashboard")
    public String getGreetingsText() {
        return page.getGreeting().getText();
    }
}
