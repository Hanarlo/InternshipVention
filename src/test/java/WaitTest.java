import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitTest extends BaseTest {

    @Test
    public void waitLoading(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement btn = driver.findElement(By.xpath("//button"));
        btn.click();
        WebElement result = driver.findElement(By.id("finish"));
        wait.waitUntilVisible(result);
        Assert.assertTrue(result.isDisplayed());
    }

    @Test
    public void waitLoadingByLocator(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement btn = driver.findElement(By.xpath("//button"));
        btn.click();
        WebElement result = wait.waitUntilVisibleByLocator(By.id("finish"));
        Assert.assertTrue(result.isDisplayed());
    }

    @Test
    public void waitLoadingEnd(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement btn = driver.findElement(By.xpath("//button"));
        btn.click();
        WebElement result = driver.findElement(By.id("loading"));
        wait.waintUntilInvisible(result);
        Assert.assertFalse(result.isDisplayed());
    }

    @Test
    public void waitUntilSelected(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox = driver.findElement(By.xpath("//form/child::input"));
        wait.waitUntillSelected(checkbox);
    }
}
