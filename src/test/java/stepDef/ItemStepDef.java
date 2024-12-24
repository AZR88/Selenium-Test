package stepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Helper.WebHelper.driver;
import static page.Item.*;

public class ItemStepDef {
    @When("check Navbar {string} button")
    public void checkNavbarButton(String arg0) {
        CheckHomebutton(driver,arg0);
    }

}
