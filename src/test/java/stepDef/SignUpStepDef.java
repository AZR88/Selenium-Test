package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import page.Login_Page;
import page.SignUp_Page;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static Helper.WebHelper.driver;

public class SignUpStepDef {
    @When("user click Signup button")
    public void userClickSignupButton() {
        WebElement button =SignUp_Page.openSignupPage(driver);
        assertTrue(button.isDisplayed() && button.isEnabled());
        button.click();
    }

    @And("user input username  with {string}")
    public void userInputUsernameWith(String arg0) {
        WebElement inputUsername = SignUp_Page.SignUpusernameInput(driver);
        String data = inputUsername.getAttribute("value");
        assertTrue(inputUsername.isDisplayed() && inputUsername.isEnabled());
        inputUsername.sendKeys(arg0);
        assertEquals(arg0,data);

    }

    @And("user input password  with {string}")
    public void userInputPasswordWith(String arg0) {
        WebElement inputpass = SignUp_Page.SignUppasswordInput(driver);
        String data = inputpass.getAttribute("value");
        assertTrue(inputpass.isDisplayed() && inputpass.isEnabled());
        inputpass.sendKeys(arg0);
        assertEquals(arg0,data);
    }

    @And("user click submit button")
    public void userClickSubmitButton() {
        WebElement button = SignUp_Page.ClikSubmit(driver);
        assertTrue(button.isDisplayed() && button.isEnabled());
        button.click();
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
