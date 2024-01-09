package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {


    //работает
    @Test
    public void kalkulatorTest() throws InterruptedException{
        webDriver.get("https://clinic-cvetkov.ru/company/kalkulyator-imt/");
        WebElement weight = webDriver.findElement(By.name("weight"));
        WebElement height = webDriver.findElement(By.name("height"));
        WebElement btn = webDriver.findElement(By.id("calc-mass-c"));

        height.sendKeys("183");
        weight.sendKeys("58");
        btn.click();

        Thread.sleep(2000);
        WebElement result = webDriver.findElement(By.id("imt-result"));
        Assert.assertEquals(result.getText(), "17.3 - Недостаточная (дефицит) масса тела");
    }
}
