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
        Thread.sleep(1000);
    }

    @Step("delete case test")
    public void deleteTestCase() {
        page.getMoreButton().click();
        page.getButtonDelete().click();
        page.getButtonConfirmDelete().click();
    }

    @Step("check is test case exists")
    public boolean isTestCaseExists() {
        return page.isTestCaseExists();
    }

}
