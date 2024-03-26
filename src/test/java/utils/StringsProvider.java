package utils;

import org.testng.annotations.DataProvider;


public class StringsProvider {

    @DataProvider(name = "strings")
    public Object[][] getString(){
        return new Object[][] {
                {"c"},
                {"d"},
                {"sxqazwsxqazwsxqa"},
                {"qazwsxqazwsxqazwsxq"},
                {"q"}
        };
    }
}
