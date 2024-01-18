import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    WaitService wait;

    @BeforeSuite
    public void setUp(){
        WebDriverFactory factory = new WebDriverFactory();
        driver = factory.getDriver();
        wait = new WaitService(driver, Duration.ofSeconds(10));
    }

    @AfterSuite
    public void wrapUp(){
        driver.quit();
    }

}
