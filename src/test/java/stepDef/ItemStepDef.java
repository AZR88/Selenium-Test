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
    @Then("Check {string} button")
    public void checkButton(String arg1) {
        CheckAboutbutton(driver,arg1);

    }

    @Then("Check the {string} button")
    public void checkTheButton(String arg0) {
        CheckCartbutton(driver,arg0);
    }


    @Then("Check a {string} button")
    public void checkAButton(String arg0) {
        CheckLoginbutton(driver,arg0);
    }

    @Then("check {string} buton")
    public void checkButon(String arg0) {
        CheckSignupbutton(driver,arg0);
    }

    @Then("Chek {string} button")
    public void chekButton(String arg0) {
        Checkcontactbutton(driver,arg0);
    }
}
