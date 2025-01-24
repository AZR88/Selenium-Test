package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page.SignUp_Page;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static Helper.WebHelper.driver;

public class SignUpStepDef {
    @When("user click Signup button")
    public void userClickSignupButton() {
        boolean isButtonCliked =SignUp_Page.openSignupPage(driver);
        assertTrue("Button Cliked",isButtonCliked);
    }

    @And("user input username  with {string}")
    public void userInputUsernameWith(String username) {
        String Value = SignUp_Page.SignUpusernameInput(driver,username);
        assertEquals(username, Value);
    }

    @And("user input password  with {string}")
    public void userInputPasswordWith(String password) {
        String inputpass = SignUp_Page.SignUppasswordInput(driver, password);
        assertEquals(inputpass, password);
        }

    @And("user click submit button")
    public void userClickSubmitButton() {
        boolean isButtonCliked = SignUp_Page.ClikSubmit(driver);
        assertTrue("Button Cliked",isButtonCliked);
    }

    @Then("show account succes created alert")
    public void showAccountSuccesCreatedAlert() {
        boolean isAlertPresent = SignUp_Page.verifySignupAlert(driver);
        Assert.assertTrue("No alert detected.", isAlertPresent);
    }

    @Then("show invalid SignUP notification")
    public void showInvalidSignUPNotification() {
        boolean isAlertPresent = SignUp_Page.verifySignupAlert(driver);
        Assert.assertTrue("No alert detected.", isAlertPresent);
    }
}
