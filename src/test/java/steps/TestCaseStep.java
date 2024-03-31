package steps;

import io.qameta.allure.Step;
import pages.TestCasesPage;

public class TestCaseStep {

    private TestCasesPage page;

    public TestCaseStep() {
        page = new TestCasesPage();
    }

    @Step("create test case")
    public void createTestCase() throws InterruptedException {
        page.getQuickAddProjectButton().click();
        page.getTextInput().sendKeys("test");
        page.getAddTestCaseButton().click();
    }

    @Step("delete case test")
    public void deleteTestCase() {
        page.getMoreButton().click();
        page.getButtonDelete().click();
        page.getButtonConfirmDelete().click();
    }

    @Step("check is test case created")
    public boolean isTestCaseCreated() {
        return page.isTestCaseCreated();
    }

    @Step("check is test case deleted")
    public boolean isTestCaseDeleted() {
        return page.isTestCaseDeleted();
    }

}
