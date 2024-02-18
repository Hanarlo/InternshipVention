package elements;

import org.openqa.selenium.*;
import wait_service.WaitService;

import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.List;

public class UIElement implements WebElement {

    private WebElement webElement;
    private WaitService waitService;
    private WebDriver driver;

    public UIElement(WebDriver driver, WebElement element) {
        this.driver = driver;
        this.waitService = new WaitService(driver);
        this.webElement = element;
    }

    public UIElement(WebDriver driver, By locator) {
        this.driver = driver;
        this.waitService = new WaitService(driver);
        this.webElement = waitService.waitForVisibilityByLocator(locator);
    }


    @Override
    public void click() {
        moveToElement();
        submit();
    }

    @Override
    public void submit() {
        webElement.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        moveToElement();
        webElement.sendKeys(keysToSend);
    }

    @Override
    public void clear() {
    webElement.clear();
    }

    @Override
    public String getTagName() {
        return webElement.getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return webElement.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return webElement.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return webElement.isEnabled();
    }

    @Override
    public String getText() {
        return webElement.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return webElement.findElements(by);
    }

    public List<UIElement> findUIElements(By by) {
        ArrayList<UIElement> list = new ArrayList<>();
        for (WebElement element : webElement.findElements(by)) {
            list.add(new UIElement(driver, element));
        }
        return list;
    }


    @Override
    public UIElement findElement(By by) {
        return new UIElement(driver, webElement.findElement(by));
    }

    @Override
    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return webElement.getLocation();
    }

    @Override
    public Dimension getSize() {
        return webElement.getSize();
    }

    @Override
    public Rectangle getRect() {
        return webElement.getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return webElement.getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return webElement.getScreenshotAs(target);
    }

    public void moveToElement() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", webElement);
    }
}
