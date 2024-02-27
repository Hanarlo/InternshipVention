package step;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import page.LoginPage;
import utils.BaseCucumberStep;

public class LoginStep extends BaseCucumberStep {

    private LoginPage loginPage;


    public LoginStep(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @Given("driver is ready")
    public void openDriver() {
        driver.get("https://piogjheioghtor.testrail.io/index.php?/auth/login/LWZhMDA0NWExYzgyM2UyNWUzMDVjMjE3ZmRjNzU1ZWEzMjJkOTZmNWY1MWEwODk0MDNjZDJhN2E1NTQ2YTEzM2Y:");

    }

    @When("perform login with {string} email and {string} password")
    public void performLogin(String email, String pass) {
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPassInput().sendKeys(pass);
        loginPage.getLoginButton().click();
    }

    @Then("Dashboard page is opened")
    public void isDashboardPageOpened() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://piogjheioghtor.testrail.io/index.php?/dashboard");
    }

    @Then("login page is opened")
    public void loginPageIsOpened() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://piogjheioghtor.testrail.io/index.php?/auth/login/LWZhMDA0NWExYzgyM2UyNWUzMDVjMjE3ZmRjNzU1ZWEzMjJkOTZmNWY1MWEwODk0MDNjZDJhN2E1NTQ2YTEzM2Y:");
    }
}
