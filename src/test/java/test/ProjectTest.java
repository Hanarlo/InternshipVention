package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.AddProjectPage;
import page.DashboardPage;
import page.OverviewPage;
import step.Project;
import utils.BaseTest;

public class ProjectTest extends BaseTest {

    private Project project;
    private OverviewPage overviewPage;

    @BeforeMethod
    public void setUpMethod(){
        overviewPage = new OverviewPage();
        project = new Project(new DashboardPage(), new AddProjectPage(), new OverviewPage());
    }

    @Test(groups = {"create project"}, dependsOnGroups = {"login"})
    public void createProjectTest(){
        project.createProject();
        Assert.assertTrue(overviewPage.isBannerOnPage());
    }

    @Test(groups = {"create project"}, dependsOnGroups = {"login"})
    public void deleteProjectTest(){
        project.deleteProject();
        Assert.assertTrue(overviewPage.isBannerOnPage());
    }
}
