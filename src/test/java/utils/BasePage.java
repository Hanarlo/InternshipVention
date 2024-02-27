package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import wait_service.WaitService;

public class BasePage extends BaseCucumberStep {
    public WaitService service;

    public BasePage(){
        service = new WaitService(driver);
    }

    protected Boolean isItemOnAPage(By by){
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
