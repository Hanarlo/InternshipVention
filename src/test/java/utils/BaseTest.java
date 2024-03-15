package utils;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeSuite
    public void setUp(){
        Configuration.baseUrl = "https://google.com/";
        Configuration.browser = "SelenoidDriverProvider";
        Configuration.timeout = 10000;
        Configuration.browserSize = "1600x1400";
    }

}
