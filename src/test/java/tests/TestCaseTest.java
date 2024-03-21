package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.DashboardStep;
import steps.TestCaseStep;
import utils.BaseTest;

@Epic("Testing creating and deleting test cases")
public class TestCaseTest extends BaseTest {

    private TestCaseStep testCaseStep;
    private DashboardStep dashboardStep;

    @BeforeClass
    private void setUpMethod() {
        dashboardStep = new DashboardStep();
        testCaseStep = new TestCaseStep();
        dashboardStep.goToTestCases();
    }


    @Story("create entity Test")
    @Test
    public void createEntityTest() throws InterruptedException {
        testCaseStep.createTestCase();
        Assert.assertTrue(testCaseStep.isTestCaseExists());
    }

    @Story("delete entity test")
    @Test(dependsOnMethods = {"createEntityTest"})
    public void deleteEntityTest() throws InterruptedException {
        testCaseStep.deleteTestCase();
        Thread.sleep(500);
        Assert.assertFalse(testCaseStep.isTestCaseExists());
    }


}
