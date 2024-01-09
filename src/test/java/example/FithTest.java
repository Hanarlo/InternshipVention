package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FithTest extends BaseTest{
    //работает
    @Test
    public void fkoTest() throws InterruptedException {
        webDriver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");
        WebElement width = webDriver.findElement(By.xpath("//input[@id='el_f_width']"));
        width.sendKeys("5");
        WebElement length = webDriver.findElement(By.xpath("//input[@id='el_f_lenght']"));
        length.sendKeys("6");
        WebElement roomType = webDriver.findElement(By.id("room_type"));
        Select roomTypeSelect = new Select(roomType);
        roomTypeSelect.selectByValue("2");
        WebElement heatingType = webDriver.findElement(By.id("heating_type"));
        Select heatingTypeSelect = new Select(heatingType);
        heatingTypeSelect.selectByIndex(2);
        WebElement button = webDriver.findElement(By.xpath("//input[@value='Рассчитать']"));
        button.click();
        WebElement cableResult = webDriver.findElement(By.id("floor_cable_power"));
        WebElement cablePower = webDriver.findElement(By.id("spec_floor_cable_power"));
        Assert.assertEquals(cableResult.getAttribute("value"), "1908");
        Assert.assertEquals(cablePower.getAttribute("value"), "64");
    }
}
