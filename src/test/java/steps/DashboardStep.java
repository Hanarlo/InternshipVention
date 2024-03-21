package steps;

import io.qameta.allure.Step;
import pages.DashboardPage;

public class DashboardStep {

    private DashboardPage page;

    public DashboardStep() {
        page = new DashboardPage();
    }

    @Step("go to project settings page")
    public ProjectSettingsStep goToProjectSettings() {
        page.getProjectSettingsButton().click();
        return new ProjectSettingsStep();
    }

    @Step("go to test cases page")
    public TestCaseStep goToTestCases() {
        page.getTestCasesButton().click();
        return new TestCaseStep();
    }

    @Step("get greetings text from dashboard")
    public String getGreetingsText() {
        return page.getGreeting().getText();
    }
}
