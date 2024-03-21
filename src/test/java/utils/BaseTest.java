package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import web_driver.WebDriverFactory;

@Listeners(InvokedListener.class)
public class BaseTest {

    protected static WebDriver driver;

    @BeforeSuite
    public void setUp() {
        WebDriverFactory factory = new WebDriverFactory();
        driver = factory.getDriver();
    }

    @AfterSuite
    public void wrapUp() {
        driver.quit();
    }
}
