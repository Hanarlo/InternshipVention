import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwagLabsTest extends BaseTest {

    @Test(dataProvider = "login data", dataProviderClass = DataProvider.class)
    public void loginTest(String username, String psw){
        webDriver.get("https://www.saucedemo.com/");
        System.out.println("---URL---- " + webDriver.getCurrentUrl());
        WebElement loginInput = webDriver.findElement(By.id("user-name"));
        loginInput.sendKeys(username);
        WebElement pswInput = webDriver.findElement(By.name("password"));
        pswInput.sendKeys(psw);
        WebElement btn = webDriver.findElement(By.className("submit-button"));
        btn.click();
        WebElement elementContainer = webDriver.findElement(By.xpath("//div[@id='inventory_container']"));
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "loginTest")
    public void addItemToCart(){
        WebElement addToCartBtn = webDriver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
        addToCartBtn.click();
        WebElement cart = webDriver.findElement(By.className("shopping_cart_badge"));
        cart.click();
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "addItemToCart")
    public void cartTest(){
        WebElement name = webDriver.findElement(By.linkText("Sauce Labs Backpack"));
        WebElement price = webDriver.findElement(By.xpath("//div[@class='inventory_item_price']"));
        Assert.assertEquals(name.getText(), "Sauce Labs Backpack");
        Assert.assertEquals(price.getText(),"$29.99");
    }
}
