package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import web_driver.WebDriverFactory;

public class InvokedListener implements IInvokedMethodListener {

    WebDriver driver;
    WebDriverFactory factory;

    public void afterInvocation(IInvokedMethod method, ITestResult result) {
        factory = new WebDriverFactory();
        driver = factory.getDriver();
        //System.out.println("This method is invoked after every config method - " + method.getTestMethod().getMethodName());

        if (result.getStatus() == ITestResult.SUCCESS) {

            try {
                byte[] srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                saveScreenshot(srcFile);
            } catch (NoSuchSessionException ex) {

            }
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(byte[] screenshot) {
        return screenshot;
    }

    @Attachment(value = "{0}", type = "text/plain")
    private static String saveTextLog(String message) {
        return message;
    }

}
