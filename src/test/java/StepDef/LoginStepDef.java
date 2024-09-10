package StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import page.Login_Page;

import static Helper.WebHelper.driver;


public class LoginStepDef {
    @Given("user is on homepage")
    public void userIsOnHomepage() {
        
    }

    @When("user click Login button")
    public void userClickLoginButton() {
        Login_Page.openLoginPage(driver);
    }
}
