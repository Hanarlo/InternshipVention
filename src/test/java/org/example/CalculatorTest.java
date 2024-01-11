package org.example;

import org.example.util.DataProvider;
import org.example.util.Retry;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CalculatorTest extends BaseTest {
    //обычные
    @Test(groups = "smoke", priority = 2, testName = "Делим целые числа")
    public void divTestInteger(){
        Assert.assertEquals(calculator.div(4, 2), 2);
    }

    @Test(groups = "smoke", priority = 1, testName = "Делим дробные числа")
    public void divTestDouble(){
        Assert.assertEquals(calculator.div(5.0, 2.0), 2.5);
    }

    //данные через класс
    @Test(dataProvider = "provider", dataProviderClass = DataProvider.class, groups = "regression")
    public void calcWithParam(int a, int b, Object expect){
        Assert.assertEquals(calculator.div(a, b), expect);
    }

    //данные через xml
    @Parameters({"a", "b", "expect"})
    @Test(groups = {"smoke", "regression"})
    public void paramTest(int a, int b, int expect){
        Assert.assertEquals(calculator.div(a, b), expect);
    }

    //проверка на деление на ноль
    @Test(expectedExceptions = ArithmeticException.class, groups = "smoke")
    public void divZeroExc(){
        calculator.div(7, 0);
    }

    //несколько запусков
    @Test(invocationCount = 3, threadPoolSize = 3, groups = {"smoke", "regression"})
    public void InvTest(){
        Assert.assertEquals(calculator.div(5.0, 2.0), 2.5);
    }

    //несколько попыток
    int attempt = 1;
    @Test(retryAnalyzer = Retry.class, groups = "regression")
    public void retryTest(){
        if (attempt >= 4){
            Assert.assertEquals(calculator.div(4, 2 ), 2);
        } else {
            attempt++;
            Assert.assertEquals(calculator.div(4, 2), 4);
        }
    }
}