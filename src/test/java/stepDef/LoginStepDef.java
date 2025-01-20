package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import org.junit.Assert;
import org.openqa.selenium.WebElement;

import page.Login_Page;
import static Helper.WebHelper.driver;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


public class LoginStepDef {
    @Given("user is on homepage {string}")
    public void userIsOnHomepage(String arg0) {
        Login_Page.UrlCheck(driver, arg0);
    }

    @When("user click Login button")
    public void userClickLoginButton() {

        WebElement loginbutton = Login_Page.openLoginPage(driver);
        assertTrue(loginbutton.isDisplayed() && loginbutton.isEnabled());
        loginbutton.click();
    }


    @And("user input username with {string}")
    public void userInputUsernameWith(String arg0) {
           WebElement Inputuser = Login_Page.inputUsername(driver);
           Inputuser.sendKeys(arg0);
           String inputText = Inputuser.getAttribute("value");
        assertTrue(Inputuser.isDisplayed()&& Inputuser.isEnabled());
        assertEquals(arg0, inputText);
    }

    @And("user input password with {string}")
    public void userInputPasswordWith(String arg0) {
        WebElement Inputpass = Login_Page.inputPassword(driver);
        Inputpass.sendKeys(arg0);
        String inputText = Inputpass.getAttribute("value");
        assertTrue(Inputpass.isDisplayed()&& Inputpass.isEnabled());
        assertEquals(inputText,arg0);
    }

    @And("user click submit")
    public void userClickSubmit() {
        WebElement Submit = Login_Page.clickSubmitButton(driver);
        assertTrue(Submit.isDisplayed() && Submit.isEnabled());
        Submit.click();
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
