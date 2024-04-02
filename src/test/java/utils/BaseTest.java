package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import web_driver.WebDriverFactory;

@Listeners(InvokedListener.class)
public class BaseTest {

    protected static WebDriver driver;
    protected static String key;

    @BeforeSuite
    public void setUp() {
        driver = WebDriverFactory.getDriver();
        key = System.getProperty("apiKey");
    }

    @AfterSuite
    public void wrapUp() {
        driver.quit();
    }
}
