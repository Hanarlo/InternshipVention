import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitService {

    WebDriver webDriver;
    WebDriverWait wait;

    public WaitService(WebDriver driver, Duration duration){
        webDriver = driver;
        wait = new WebDriverWait(driver, duration);
    }

    public WebElement waitUntilVisible(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitUntilVisibleByLocator(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public Boolean waintUntilInvisible(WebElement element){
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public Boolean waitUntilPresent(String url){
        return wait.until(ExpectedConditions.urlToBe(url));
    }

    public Boolean waitUntillSelected(WebElement element){
        return wait.until(ExpectedConditions.elementToBeSelected(element));
    }


}
