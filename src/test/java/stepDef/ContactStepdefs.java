package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import page.Contact;
import page.Login_Page;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


import static Helper.WebHelper.driver;

public class ContactStepdefs {
    @When("Click Contact")
    public void clickContact() {
        WebElement button = Contact.clickContact(driver);
        assertTrue(button.isDisplayed()&& button.isEnabled());
        button.click();
    }

    @Then("the user enters their email {string}")
    public void theUserEntersTheirEmail(String arg0) {
       WebElement input =  Contact.inputemail(driver);
       input.sendKeys(arg0);
       String data = input.getAttribute("value");
       assertTrue(input.isDisplayed() && input.isEnabled());
       assertEquals(arg0, data);
    }

    @And("the user enters their name {string}")
    public void theUserEntersTheirName(String arg0) {
        WebElement input =  Contact.inputname(driver);
        input.sendKeys(arg0);
        String data = input.getAttribute("value");
        assertTrue(input.isDisplayed() && input.isEnabled());
        assertEquals(arg0, data);
    }

    @And("the user enters their message {string}")
    public void theUserEntersTheirMessage(String arg0) {
        WebElement input =  Contact.inputmassage(driver);
        input.sendKeys(arg0);
        String data = input.getAttribute("value");
        assertTrue(input.isDisplayed() && input.isEnabled());
        assertEquals(arg0, data);
    }

    @And("the user click Submit")
    public void theUserClickSubmit() {
        WebElement button = Contact.clickSubmit(driver);
        assertTrue(button.isDisplayed() && button.isEnabled());
        button.click();
    }



    @Then("an error message should be displayed for emtpy field")
    public void anErrorMessageShouldBeDisplayedForEmtpyField() {
        boolean isAlertPresent = Login_Page.isLoginAlertPresent(driver);
        Assert.assertTrue("Notifikasi login tidak valid tidak terdeteksi!", isAlertPresent);
    }
}
