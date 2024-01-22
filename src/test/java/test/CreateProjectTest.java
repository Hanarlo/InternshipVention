package test;

import com.beust.ah.A;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.AddProjectPage;
import page.DashboardPage;
import page.OverviewPage;
import step.AddProjectStep;
import utils.BaseTest;

public class CreateProjectTest extends BaseTest {

    private AddProjectStep addProjectStep;
    private OverviewPage overviewPage;

    @BeforeMethod
    public void setUpMethod(){
        overviewPage = new OverviewPage();
        addProjectStep = new AddProjectStep(new DashboardPage(), new AddProjectPage());
    }

    @Test(groups = {"create project"}, dependsOnGroups = {"login"})
    public void createProjectTest(){
        addProjectStep.createProject();
        Assert.assertTrue(overviewPage.isBannerOnPage());
    }
}
