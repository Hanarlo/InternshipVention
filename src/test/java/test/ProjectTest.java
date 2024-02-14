package test;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.AddProjectPage;
import page.DashboardPage;
import page.OverviewPage;
import step.Project;
import utils.BaseTest;

@Epic("ProjectEpic")
public class ProjectTest extends BaseTest {

    private Project project;
    private OverviewPage overviewPage;

    @BeforeMethod
    public void setUpMethod(){
        overviewPage = new OverviewPage();
        project = new Project(new DashboardPage(), new AddProjectPage(), new OverviewPage());
    }

    @Test(dependsOnGroups = {"login"})
    @Feature("projects feature")
    @Story("project story")
    public void workWithProjects(){
        createProjectTest();
        deleteProjectTest();
    }

    @Step("sub-step 1")
    public void substep1(){

    }

    //@Test(groups = {"create project"}, dependsOnGroups = {"login"})
    @Step("CreateProjectStep")
    public void createProjectTest(){
        substep1();
        Allure.step("open page");
        project.createProject();
        Allure.step("checking banner");
        Assert.assertTrue(overviewPage.isBannerOnPage());
    }

    //@Test(dependsOnGroups = {"create project"})
    @Step("Delete project step")
    public void deleteProjectTest(){
        Allure.step("open delete page");
        project.deleteProject();
        Allure.step("banner checking");
        Assert.assertTrue(overviewPage.isBannerOnPage());
    }
}
