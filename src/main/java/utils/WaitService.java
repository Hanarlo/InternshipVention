package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitService {

    private WebDriverWait wait;

    public WaitService(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public WebElement waitForElementVisibilityByLocator(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
