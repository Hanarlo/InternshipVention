package step;

import page.LoginPage;

public class LoginStep {

    private LoginPage loginPage;

    public LoginStep(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public void performLogin(String email, String pass){
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPassInput().sendKeys(pass);
        loginPage.getLoginButton().click();
    }

}
