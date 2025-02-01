package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import page.LoginPage;
import static Helper.WebHelper.driver;

public class LoginStepDef {

    @Given("user is on homepage {string}")
    public void userIsOnHomepage(String expectedUrl) {
        boolean isUrlCorrect = LoginPage.isUrlCorrect(driver, expectedUrl);
        Assert.assertTrue(" Incorrect URL !", isUrlCorrect);
    }

    @When("user click Login button")
    public void userClicksLoginButton() {
        boolean isLoginButtonClickable = LoginPage.clickLoginButton(driver);
        Assert.assertTrue("Login button Unclikable or not displayed", isLoginButtonClickable);
    }

    @And("user input username with {string}")
    public void userInputsUsernameWith(String username) {
        String inputtedUsername = LoginPage.inputUsername(driver, username);
        Assert.assertEquals("Input username Not Equal", username, inputtedUsername);
    }

    @And("user input password with {string}")
    public void userInputsPasswordWith(String password) {
        String inputtedPassword = LoginPage.inputPassword(driver, password);
        Assert.assertEquals("Input password Not Equal", password, inputtedPassword);
    }

    @And("user click submit")
    public void userClicksSubmitButton() {
        boolean isSubmitButtonClickable = LoginPage.clickSubmitButton(driver);
        Assert.assertTrue("Submit button Unclikable or not displayed!", isSubmitButtonClickable);
    }

    @Then("user redirect to home page with {string} username displayed")
    public void userRedirectedToHomePageWithUsernameDisplayed(String expectedUsername) {
        String actualUsername = LoginPage.getDisplayedUsername(driver);
        Assert.assertEquals("Username is not equals to account !", expectedUsername, actualUsername);
    }

    @Then("show invalid login notification")
    public void showInvalidLoginNotification() {
        boolean isAlertPresent = LoginPage.isLoginAlertPresent(driver);
        Assert.assertTrue("invalid login notification detected!", isAlertPresent);
    }
}
