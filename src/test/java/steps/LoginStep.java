package steps;

import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import pages.DashboardPage;
import pages.LoginPage;

@Epic("Login")
public class LoginStep {

    private LoginPage loginPage;

    public LoginStep() {
        loginPage = new LoginPage();
    }

    @Step("perform login")
    public DashboardPage performLogin(String email, String pass) {
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(pass);
        loginPage.getButton().click();
        return new DashboardPage();
    }
}
