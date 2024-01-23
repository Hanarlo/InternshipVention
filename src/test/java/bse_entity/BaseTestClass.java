package bse_entity;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import page.CartPage;
import page.Checkout;
import page.CollectionPage;
import page.LoginPage;
import web_driver.WebDriverFactory;

public class BaseTestClass {

    protected static WebDriver driver;
    protected LoginPage loginPage;
    protected CollectionPage collectionPage;
    protected CartPage cartPage;
    protected Checkout checkout;
    protected HeadBar headBar;

    @BeforeTest
    public void setDriver() {
        WebDriverFactory factory = new WebDriverFactory();
        driver = factory.getDriver();
    }

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage(driver);
        collectionPage = new CollectionPage(driver);
        cartPage = new CartPage(driver);
        checkout = new Checkout(driver);
        headBar = new HeadBar(driver);
    }

    @AfterSuite
    public void wrapUp(){
        driver.quit();
    }
}
