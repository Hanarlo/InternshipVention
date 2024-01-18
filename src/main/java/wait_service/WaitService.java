package wait_service;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitService {

    private WebDriverWait wait;

    private WebDriver driver;

    public WaitService(WebDriver driver, Duration duration){
        this.driver = driver;
        wait = new WebDriverWait(driver, duration);
    }

    public WebElement waitForVisibilityByLocator(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public Boolean waitForInvisibility(By locator){
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public Boolean waitForPresence(By locator){
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
