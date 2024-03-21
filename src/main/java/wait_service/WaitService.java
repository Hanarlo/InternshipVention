package wait_service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitService {

    protected WebDriverWait wait;

    public WaitService(WebDriver driver, Duration duration) {
        wait = new WebDriverWait(driver, duration);
    }

    public WebElement waitUntilVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitUntilVisibleByLocator(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitUntilClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public Boolean waitUntilPresent() {
        return wait.until(ExpectedConditions.urlToBe("https://app.testiny.io/DP/dashboard"));
    }
}
