import com.beust.ah.A;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdditionalActionsTest extends BaseTest {

    Actions actions;

    @Test
    public void hoverTest() throws InterruptedException {
        actions = new Actions(driver);
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement photo = driver.findElement(By
                .xpath("//div[@class='figcaption']/h5[contains(text(), 'user1')]/../.."));
        WebElement desc = driver.findElement(By
                .xpath("//div[@class='figcaption']/h5[contains(text(), 'user1')]/.."));
        Assert.assertFalse(desc.isDisplayed());
        actions.moveToElement(photo).build().perform();
        Assert.assertTrue(desc.isDisplayed());
    }


    @Test
    public void dragAndDropTest(){
        actions = new Actions(driver);
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement columnA = driver.findElement(By.id("column-a"));
        WebElement columnB = driver.findElement(By.id("column-b"));
        actions.dragAndDrop(columnA, columnB).build().perform();
        WebElement result = driver.findElement(By.xpath("//div[@id='columns']/child::div/header"));
        Assert.assertEquals(result.getText(), "B");
    }

    @Test
    public void fileUploadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement uploadFileBtn = driver.findElement(By.id("file-upload"));
        uploadFileBtn.sendKeys("C:\\Users\\Yury.Chychayeu\\IdeaProjects\\Internship\\src\\test\\resources\\download.jpeg");
        WebElement sendBtn = driver.findElement(By.id("file-submit"));
        sendBtn.click();
    }

    @Test
    public void dropDownMenu(){
        actions = new Actions(driver);
        driver.get("https://www.onliner.by/");
        WebElement dropdown = driver.findElement(By
                .cssSelector("a[href='https://ab.onliner.by']>span[class='b-main-navigation__text']"));
        actions.moveToElement(dropdown).build().perform();
        WebElement minskDropDown = wait
                .waitUntilVisibleByLocator(By
                .cssSelector("a[href='https://ab.onliner.by/city/minsk']>span[class='b-main-navigation__dropdown-advert-sign']"));
        minskDropDown.click();
        Assert.assertTrue(wait.waitUntilPresent("https://ab.onliner.by/city/minsk"));
    }
}
