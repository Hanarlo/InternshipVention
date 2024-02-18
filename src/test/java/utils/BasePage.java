package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import wait_service.WaitService;
import web_driver.WebDriverFactory;

public class BasePage {

    public static WebDriver webDriver;
    public WaitService service;

    public BasePage(){
        WebDriverFactory factory = new WebDriverFactory();
        webDriver = factory.getDriver();
        service = new WaitService(webDriver);
    }

    protected Boolean isItemOnAPage(By by){
        try {
            return webDriver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
