package web_driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class WebDriverFactory {

    public WebDriver getDriver(){
        System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
        return new EdgeDriver(edgeOptions());
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
