import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class SelenoidDriverProvider implements WebDriverProvider {


    @Override
    public WebDriver createDriver(Capabilities desiredCapabilities) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("121.0");
        capabilities.setPlatform(Platform.LINUX);
        //capabilities.setCapability("enableVNC", true);
//        browser.setCapability("screenResolution", "680x124x24"); // размер экрана

        try {
            RemoteWebDriver driver = new RemoteWebDriver(
                    URI.create("http://127.0.0.1:4444/wd/hub").toURL(),
                    capabilities);
            return driver;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

