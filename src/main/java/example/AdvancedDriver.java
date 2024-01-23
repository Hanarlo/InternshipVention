package example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class AdvancedDriver {

    public WebDriver getDriver() {
        System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");

        return new EdgeDriver(edgeOptions());
    }

    private EdgeOptions edgeOptions() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--remote-allow-origins=*");
        //edgeOptions.setHeadless(true);
        //edgeOptions.addArguments("--disable-gpu");
        edgeOptions.addArguments("--ignore-certificate-errors");
        edgeOptions.addArguments("--start-maximized");
        //edgeOptions.addArguments("--silent");
        return edgeOptions;
    }
}
