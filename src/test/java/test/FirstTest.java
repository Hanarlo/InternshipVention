package test;

import com.codeborne.selenide.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FirstTest extends BaseTest {

    @Test
    public void smokeTest() throws InterruptedException {
        Selenide.open("https://www.google.com/");
        Assert.assertTrue($x("//div[@class ='SDkEP']").isDisplayed());
    }
}
