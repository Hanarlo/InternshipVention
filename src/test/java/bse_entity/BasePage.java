package bse_entity;

import org.openqa.selenium.WebDriver;
import wait_service.WaitService;

import java.time.Duration;

public class BasePage {

    WebDriver driver;
    public WaitService service;

    public BasePage(WebDriver driver){
        this.driver = driver;
        service = new WaitService(driver, Duration.ofSeconds(10));
    }
}
