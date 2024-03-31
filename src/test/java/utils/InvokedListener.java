package utils;

import io.qameta.allure.Attachment;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import web_driver.WebDriverFactory;


public class InvokedListener implements IInvokedMethodListener {

    WebDriver driver;

    private static final Logger logger = LogManager.getLogger(InvokedListener.class);

    public void afterInvocation(IInvokedMethod method, ITestResult result) {
        driver = WebDriverFactory.getDriver();
        if (result.getStatus() == ITestResult.FAILURE) {
            String message = "-------TEST FAILURE------     " + method.getTestMethod().getMethodName() + "\n" + result.getThrowable() + "\n";
            logger.log(Level.ERROR, message);
            attachLogToAllure("ERROR: " + message);
            try {
                byte[] srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                saveScreenshot(srcFile);
            } catch (NoSuchSessionException ex) {
                logger.log(Level.ERROR, "screenshot save fail!");
            }
        } else if (result.getStatus() == ITestResult.SKIP) {
            String message = "-------TEST SKIP------     " + method.getTestMethod().getMethodName() + "\n" + result.getSkipCausedBy();
            logger.log(Level.WARN, message);
            attachLogToAllure("WARNING: " + message);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            String message = "-------TEST SUCCESS------     " + method.getTestMethod().getMethodName();
            logger.log(Level.INFO, message);
            attachLogToAllure("INFO: " + message);
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(byte[] screenshot) {
        return screenshot;
    }

    @Attachment(value = "{logMessage}", type = "text/plain")
    private static String attachLogToAllure(String logMessage) {
        return logMessage;
    }

}