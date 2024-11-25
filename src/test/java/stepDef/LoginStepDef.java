package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.Login_Page;

import java.time.Duration;

import static Helper.WebHelper.driver;
import static org.junit.Assert.assertTrue;


public class LoginStepDef {
    @Given("user is on homepage {string}")
    public void userIsOnHomepage(String arg0) {
        Login_Page.UrlCheck(driver, arg0);
    }

    @When("user click Login button")
    public void userClickLoginButton() {

        Login_Page.openLoginPage(driver);
    }


    @And("user input username with {string}")
    public void userInputUsernameWith(String arg0) {
        Login_Page.inputUsername(driver,arg0);
    }

    @And("user input password with {string}")
    public void userInputPasswordWith(String arg0) {
        Login_Page.inputPassword(driver,arg0);
    }

    @And("user click submit")
    public void userClickSubmit() throws InterruptedException {
        Thread.sleep(1000);
        Login_Page.clickSubmitButton(driver);
    }

    @Then("user redirect to home page with {string} username displayed")
    public void userRedirectToHomePageWithUsernameDisplayed(String arg0) {
       boolean isTitleCorrect = Login_Page.verifyUserID(driver,arg0);
        assertTrue("Title tidak sesuai dengan yang diharapkan!", isTitleCorrect);
    }

    @Then("show invalid login notification")
    public void showInvalidLoginNotification() {
        Login_Page.verifyLoginAlert(driver);
    }



}
