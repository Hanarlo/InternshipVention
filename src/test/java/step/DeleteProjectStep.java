package step;

import page.OverviewPage;

public class DeleteProjectStep {

    private OverviewPage overviewPage;

    public DeleteProjectStep(OverviewPage overviewPage) {
        this.overviewPage = overviewPage;
    }

    public void deleteProject(){
        overviewPage.getDeleteBtn().click();
        overviewPage.getCheckbox().click();
        overviewPage.getConfirmButton().click();
    }
}
