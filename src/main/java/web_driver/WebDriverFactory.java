package web_driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class WebDriverFactory {

    private static WebDriver driver;

    public WebDriver getDriver(){
        WebDriverManager.edgedriver().setup();
        if (driver == null){
            driver = new EdgeDriver(edgeOptions());
        }
        return driver;
    }

    public EdgeOptions edgeOptions(){
        EdgeOptions edgeOptions = new EdgeOptions();

        edgeOptions.setHeadless(true);
        edgeOptions.addArguments("--disable-gpu");
        edgeOptions.addArguments("--window-size=1920,1200");
        edgeOptions.addArguments("--ignore-certificate-errors");
        edgeOptions.addArguments("--silent");
        edgeOptions.addArguments("--start-maximized");

        return edgeOptions;
    }

}