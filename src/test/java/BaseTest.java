import driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {


    WebDriver webDriver;
    @BeforeSuite
    public void setUp(){
        WebDriverFactory factory = new WebDriverFactory();
        webDriver = factory.getDriver();
    }

    @AfterSuite
    public void wrapUp(){
        webDriver.manage().deleteAllCookies();
        webDriver.quit();

    }
}
