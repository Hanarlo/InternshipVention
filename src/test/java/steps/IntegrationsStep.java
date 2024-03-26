package steps;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import pages.IntegrationsPage;

public class IntegrationsStep {

    IntegrationsPage page;

    public IntegrationsStep() {
        page = new IntegrationsPage();
    }

    @Step("Trying to connect git hub with wrong credentials and get error message")
    public Boolean connectGithubWithWrongCredentials() {
        Allure.step("navigate to integrations page");
        page.getIntegrationMenuButton().click();
        Allure.step("opening git hub integration settings");
        page.getAddGitHubButton().click();
        Allure.step("input wrong data");
        page.getUrlInput().sendKeys("github.com");
        page.getAccessCodeInput().sendKeys("abrakadabra");
        Allure.step("checking is api responds correctly");
        page.getTestConnectionButton().click();
        boolean result = page.getSuccessMessage().isDisplayed();
        page.getCancelButton().click();
        page.getDiscardButton().click();
        return result;
    }
}
