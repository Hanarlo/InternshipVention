package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.TablePage;
import step.TableStep;
import utils.BaseTest;

public class TableTest extends BaseTest {

    private TableStep tableStep;

    @BeforeMethod
    public void setUpMethod(){
        tableStep = new TableStep(new TablePage());
        driver.get("https://colorlib.com/etc/tb/Table_Responsive_v1/index.html");
    }

    @Test
    public void tableBodyTest(){
        Assert.assertEquals(tableStep.getTextFromCell(2, 5), "200391");
    }

    @Test
    public void tableHeaderTest(){
        Assert.assertEquals(tableStep.getTextFromHeaderCell(3), "Name");
    }



}
