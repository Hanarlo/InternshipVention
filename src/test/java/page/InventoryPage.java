package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

public class InventoryPage {

    public String getUrl(){
        return WebDriverRunner.url();
    }
}
