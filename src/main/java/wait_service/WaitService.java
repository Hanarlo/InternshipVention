package wait_service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitService {

    protected WebDriverWait wait;

    public WaitService(WebDriver driver, Duration duration) {
        wait = new WebDriverWait(driver, duration);
    }

    public WebElement waitUntilVisibleByLocator(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitUntilClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public List<WebElement> waitUntilDeleted(By locator){
        return wait.until(ExpectedConditions.numberOfElementsToBe(locator, 0));
    }

    public List<WebElement> waitUntilCreated(By locator){
        return wait.until(ExpectedConditions.numberOfElementsToBe(locator, 1));
    }

}
