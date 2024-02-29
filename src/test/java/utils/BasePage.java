package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import wait_service.WaitService;

public class BasePage{
    public WaitService service;
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.service = new WaitService(driver);
        this.driver = driver;
    }

    protected Boolean isItemOnAPage(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
