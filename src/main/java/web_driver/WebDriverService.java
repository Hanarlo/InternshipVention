package web_driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class WebDriverService {

    private WebDriver driver;

    public WebDriverService() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();

        edgeOptions.setHeadless(true);
        edgeOptions.addArguments("--disable-gpu");
        edgeOptions.addArguments("--window-size=1920,1200");
        edgeOptions.addArguments("--ignore-certificate-errors");
        edgeOptions.addArguments("--silent");
        edgeOptions.addArguments("--start-maximized");
        driver = new EdgeDriver(edgeOptions);
    }

    public WebDriver getDriver() {
        return driver;
    }

}