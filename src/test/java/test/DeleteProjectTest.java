package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.OverviewPage;
import step.DeleteProjectStep;
import utils.BaseTest;

public class DeleteProjectTest extends BaseTest {

    private DeleteProjectStep deleteProjectStep;
    private OverviewPage overviewPage;

    @BeforeMethod
    public void setUpMethod(){
        overviewPage = new OverviewPage();
        deleteProjectStep = new DeleteProjectStep(overviewPage);
    }

    @Test(dependsOnGroups = {"create project", "login"})
    public void deleteProjectTest(){
        deleteProjectStep.deleteProject();
        Assert.assertTrue(overviewPage.isBannerOnPage());
    }
}
