package step;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.BaseCucumberStep;
import web_driver.WebDriverService;

public class Hook extends BaseCucumberStep {

    private BaseCucumberStep baseCucumberStep;

    public Hook(BaseCucumberStep baseCucumberStep) {
        this.baseCucumberStep = baseCucumberStep;
    }

    @Before
    public void setUp(){
        baseCucumberStep.driver = new WebDriverService().getDriver();
    }


    @After
    public void warUp(){
        if (baseCucumberStep.driver != null){
            baseCucumberStep.driver.close();
        }
    }
}
