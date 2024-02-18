package step;

import page.AddProjectPage;
import page.DashboardPage;
import page.OverviewPage;

public class Project {

    private DashboardPage dashboardPage;
    private AddProjectPage addProjectPage;
    private OverviewPage overviewPage;

    public Project(DashboardPage dashboardPage, AddProjectPage addProjectPage, OverviewPage overviewPage) {
        this.dashboardPage = dashboardPage;
        this.addProjectPage = addProjectPage;
        this.overviewPage = overviewPage;
    }

    public void deleteProject() {
        overviewPage.getDeleteBtn().click();
        overviewPage.getCheckbox().click();
        overviewPage.getConfirmButton().click();
    }

    public void createProject() {
        dashboardPage.getAddProjectBtn().click();

        addProjectPage.getNameInput().sendKeys("test");
        addProjectPage.getAccessBtn().click();
        addProjectPage.getRadioButtonTable().selectButtonByValue(1);
        //
        addProjectPage.getAccessDropdownBtn().select.selectByValue("Designer");
        //
        addProjectPage.getAcceptBtn().click();
    }
}
