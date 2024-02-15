package utils;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import web_driver.WebDriverFactory;

public abstract class BasePage {

    protected WebDriver driver;
    protected WaitService waitService;

    protected BasePage() {
        driver = WebDriverFactory.getDriver();
        waitService = new WaitService(driver);
        PageFactory.initElements(driver, this);
        waitForOpen();
    }

    protected abstract boolean isOpened();

    protected void waitForOpen() {
        try {
            isOpened();
        } catch (TimeoutException e){
            throw new AssertionError("page was not loaded");
        }
    }
}
