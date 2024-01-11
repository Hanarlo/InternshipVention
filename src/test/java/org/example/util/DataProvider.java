package org.example.util;

public class DataProvider {
@org.testng.annotations.DataProvider()
    public static Object[][] provider(){
    return new Object[][]{
            {34, 2, 17},
            {10, 5, 2}
    };
}
}
