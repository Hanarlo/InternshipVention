package example;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LaunchDriver{

    @Test
    public void launchDriverTest(){
        AdvancedDriver advancedDriver = new AdvancedDriver();
        WebDriver webDriver = advancedDriver.getDriver();
        webDriver.quit();
    }
}
