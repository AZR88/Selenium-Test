package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.SignUp_Page;
import static Helper.WebHelper.driver;

public class SignUpStepDef {
    @When("user click Signup button")
    public void userClickSignupButton() {
        SignUp_Page.openSignupPage(driver);
    }

    @And("user input username  with {string}")
    public void userInputUsernameWith(String arg0) {
        SignUp_Page.SignUpusernameInput(driver, arg0);

    }

    @And("user input password  with {string}")
    public void userInputPasswordWith(String arg0) {
        SignUp_Page.SignUppasswordInput(driver,arg0);
    }

    @And("user click submit button")
    public void userClickSubmitButton() {
        SignUp_Page.ClikSubmit(driver);
    }

    @Then("show account succes created alert")
    public void showAccountSuccesCreatedAlert() {
        SignUp_Page.verifySignupAlert(driver);

    }

    @Then("show invalid SignUP notification")
    public void showInvalidSignUPNotification() {
        SignUp_Page.verifySignupAlert(driver);
    }
}
