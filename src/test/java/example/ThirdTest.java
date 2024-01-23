package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ThirdTest extends BaseTest{
    //не работает из-за проверки на робота
    @Test
    public void laminateTest() {
        webDriver.get("https://calc.by/building-calculators/laminate.html");
        WebElement element = (new WebDriverWait(webDriver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.elementToBeClickable(By.id("In_room_id")));
        WebElement length = webDriver.findElement(By.id("In_room_id"));
        WebElement nPacking = webDriver.findElement(By.id("n_packing"));

        Assert.assertEquals(length.getText(), "430");
        Assert.assertEquals(nPacking.getText(), "8");
    }
}
