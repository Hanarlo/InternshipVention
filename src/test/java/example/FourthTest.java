package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FourthTest extends BaseTest{

    //работает
    @Test
    public void myfinTest() throws InterruptedException {
        webDriver.get("https://myfin.by/");
        WebElement from = webDriver.findElement(By.id("from_curr"));
        Select selectFrom = new Select(from);
        WebElement to = webDriver.findElement(By.id("to_curr"));
        Select selectTo =  new Select(to);
        selectFrom.selectByIndex(5);
        selectTo.selectByIndex(1);
        WebElement fromInput = webDriver.findElement(By.xpath("//input[@id='from_input_curr']"));
        fromInput.clear();
        fromInput.sendKeys("400");
        Thread.sleep(4000);
        WebElement toInput = webDriver.findElement(By.xpath("//select[@id='to_curr']"));
        Assert.assertEquals(toInput.getAttribute("value"), "100.4913");
    }
}
