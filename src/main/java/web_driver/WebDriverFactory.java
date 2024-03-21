package web_driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class WebDriverFactory {

    private WebDriver driver;

    public WebDriver getDriver() {
        System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
        if (driver == null){
            driver = new EdgeDriver(edgeOptions());
        }
        return driver;
    }

    public EdgeOptions edgeOptions() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--window-size=1920,1200");
        edgeOptions.addArguments("--ignore-certificate-errors");
        return edgeOptions;
    }
}