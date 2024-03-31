package web_driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null){
            driver = WebDriverManager.chromedriver().driverVersion("123.0.6312.58").create();
        }
        return driver;
    }
}