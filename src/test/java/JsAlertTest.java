import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JsAlertTest extends BaseTest {

    @Test
    public void simpleAlertTest(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement simpleAlertButton = driver.findElement(By
                .xpath("//button[text() = 'Click for JS Alert']"));
        simpleAlertButton.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS Alert");
        alert.accept();
    }

    @Test
    public void textInputAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement simpleAlertButton = driver.findElement(By
                .xpath("//button[text() = 'Click for JS Prompt']"));
        simpleAlertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("JS alert is cool!");
        alert.accept();
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(), "You entered: JS alert is cool!");
    }


}
