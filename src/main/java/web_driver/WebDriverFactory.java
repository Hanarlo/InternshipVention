package web_driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    private static WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null){
            WebDriverManager.chromedriver().driverVersion("123.0.6312.58").setup();
            driver = new ChromeDriver();
        }
        return driver;
    }
}