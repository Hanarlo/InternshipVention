package utils;

import org.openqa.selenium.WebDriver;
import wait_service.WaitService;
import web_driver.WebDriverFactory;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WaitService wait;

    public BasePage() {
        driver = WebDriverFactory.getDriver();
        wait = new WaitService(driver, Duration.ofSeconds(10));
    }

}
