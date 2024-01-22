package step;

import page.AddProjectPage;
import page.DashboardPage;

public class AddProjectStep {

    private DashboardPage dashboardPage;
    private AddProjectPage addProjectPage;

    public AddProjectStep(DashboardPage dashboardPage, AddProjectPage addProjectPage) {
        this.dashboardPage = dashboardPage;
        this.addProjectPage = addProjectPage;
    }

    public void createProject(){
        dashboardPage.getAddProjectBtn().click();

        addProjectPage.getNameInput().sendKeys("test");
        addProjectPage.getAccessBtn().click();
        addProjectPage.getAccessDropdownBtn().click();
        addProjectPage.getDesignerDropdownMenuLink().click();
        addProjectPage.getAcceptBtn().click();
    }
}
