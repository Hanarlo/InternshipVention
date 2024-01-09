package example;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    WebDriver webDriver;
    @BeforeMethod
    public void setUp(){
        AdvancedDriver advancedDriver = new AdvancedDriver();
        webDriver = advancedDriver.getDriver();
    }
    @AfterMethod
    public void wrapUp(){
        System.out.println("Сворачиваемся");
        webDriver.quit();
    }
}
