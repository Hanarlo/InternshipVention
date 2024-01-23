package example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondTest extends BaseTest{
    @Test
    public void skf() {
        webDriver.get("https://bymed.top/calc/%d1%81%d0%ba%d1%84-2148");
        System.out.println(webDriver.getPageSource());
    }
    //не работает,так как там калькулятор подгружается из js
    @Test
    public void skfTest() throws InterruptedException {
        webDriver.get("https://bymed.top/calc/%d1%81%d0%ba%d1%84-2148");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("window.scrollBy(0,350)", "");
    WebElement form = webDriver.findElement(By.xpath("//input[@id='age']"));
         //WebElement age = webDriver.findElement(By.name("age"));
        WebElement sex = webDriver.findElement(By.id("sex"));
        Select sexSelector = new Select(sex);
        WebElement createnin = webDriver.findElement(By.id("cr"));
        WebElement race = webDriver.findElement(By.id("race"));
        Select raceSelector = new Select(race);
        WebElement mass = webDriver.findElement(By.id("mass"));
        WebElement grow = webDriver.findElement(By.id("grow"));

       // age.sendKeys("20");
        sexSelector.selectByIndex(0);
        createnin.sendKeys("10");
        raceSelector.selectByIndex(0);
        mass.sendKeys("85");
        grow.sendKeys("190");
        form.submit();
        Thread.sleep(2000);

        WebElement mdrd = webDriver.findElement(By.id("mdrd_res"));
        Assert.assertEquals(mdrd.getText(), 1177.97);
    }
}
