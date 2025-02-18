package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page.SignUpPage;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static Helper.WebHelper.driver;

public class SignUpStepDef {
    @When("user click Signup button")
    public void userClickSignupButton() {
        boolean isButtonCliked = SignUpPage.openSignupPage(driver);
        assertTrue("Button Cliked",isButtonCliked);
    }

    @And("user input username  with {string}")
    public void userInputUsernameWith(String username) {
        String value = SignUpPage.signUpusernameInput(driver,username);
        assertEquals(username, value);
    }

    @And("user input password  with {string}")
    public void userInputPasswordWith(String password) {
        String inputpass = SignUpPage.signUppasswordInput(driver, password);
        assertEquals(inputpass, password);
        }

    @And("user click submit button")
    public void userClickSubmitButton() {
        boolean isButtonCliked = SignUpPage.clikSubmit(driver);
        assertTrue("Button Cliked",isButtonCliked);
    }




    @Then("show account succes created alert {string}")
    public void showAccountSuccesCreatedAlert(String message) {
        String text = SignUpPage.getAlertText(driver);
        assertEquals(text,message);
    }

    @Then("show invalid SignUP notification {string}")
    public void showInvalidSignUPNotification(String message) {
        String text = SignUpPage.getAlertText(driver);
        assertEquals(message,text);
    }
}
