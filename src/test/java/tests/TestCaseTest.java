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

    @BeforeClass
    private void setUpMethod() {
        DashboardStep dashboardStep = new DashboardStep();
        testCaseStep = new TestCaseStep();
        dashboardStep.goToTestCases();
    }


    @Story("create entity Test")
    @Test
    public void createEntityTest() {
        testCaseStep.createTestCase();
        Assert.assertTrue(testCaseStep.isTestCaseCreated());
    }

    @Story("delete entity test")
    @Test(dependsOnMethods = {"createEntityTest"})
    public void deleteEntityTest() {
        testCaseStep.deleteTestCase();
        Assert.assertTrue(testCaseStep.isTestCaseDeleted());
    }

}
