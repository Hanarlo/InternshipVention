package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import web_driver.WebDriverFactory;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeSuite
    public void setUp(){
        WebDriverFactory factory = new WebDriverFactory();
        driver = factory.getDriver();
    }

    @AfterSuite
    public void wrapUp(){
        driver.quit();
    }
}
