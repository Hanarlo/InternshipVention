package step;

import page.LoginPage;

public class LoginStep {

    private LoginPage loginPage;

    public LoginStep(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public void performLogin(String login, String pass){
        loginPage.getEmailInput().sendKeys(login);
        loginPage.getPassInput().sendKeys(pass);
        loginPage.getLoginButton().click();
    }

}
