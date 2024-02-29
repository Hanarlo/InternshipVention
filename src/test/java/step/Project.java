package step;

import com.beust.ah.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import page.AddProjectPage;
import page.DashboardPage;
import page.OverviewPage;
import utils.BaseCucumberStep;

public class Project extends BaseCucumberStep {

    private DashboardPage dashboardPage;
    private AddProjectPage addProjectPage;
    private OverviewPage overviewPage;



    @Given("pages opened")
    public void openPages() {
        dashboardPage = new DashboardPage(driver);
        addProjectPage = new AddProjectPage(driver);
        overviewPage = new OverviewPage(driver);
    }

    @When("Delete project")
    public void deleteProject() {
        overviewPage.getDeleteBtn().click();
        overviewPage.getCheckbox().click();
        overviewPage.getConfirmButton().click();
    }
    @When("Create project")
    public void createProject() {
        dashboardPage.getAddProjectBtn().click();

        addProjectPage.getNameInput().sendKeys("test");
        addProjectPage.getAccessBtn().click();
        addProjectPage.getAccessDropdownBtn().click();
        addProjectPage.getDesignerDropdownMenuLink().click();
        addProjectPage.getAcceptBtn().click();
    }

    @Then("Banner on a page")
    public void isBannerOnPage() {
        Assert.assertTrue(overviewPage.isBannerOnPage());
    }
}
