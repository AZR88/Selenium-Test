package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page.Contact;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


import static Helper.WebHelper.driver;

public class ContactStepdefs {
    @When("Click Contact")
    public void clickContact() {
        boolean buttonCliked = Contact.clickContact(driver);
        assertTrue("Button not Cliked",buttonCliked);
    }

    @Then("the user enters their email {string}")
    public void theUserEntersTheirEmail(String email) {
       String input =  Contact.inputEmail(driver, email);
       assertEquals("invalid input",input,email);
    }

    @And("the user enters their name {string}")
    public void theUserEntersTheirName(String name) {
       String input =  Contact.inputName(driver, name);
        assertEquals("invalid input",name, input);
    }

    @And("the user enters their message {string}")
    public void theUserEntersTheirMessage(String message) {
        String input =  Contact.inputMassage(driver,message);
        assertEquals("invalid input",message,input);
    }

    @And("the user click Submit")
    public void theUserClickSubmit() {
        boolean button = Contact.clickSubmit(driver);
        assertTrue("Button dont displayed",button);
    }



    @Then("an error message should be displayed for emtpy field")
    public void anErrorMessageShouldBeDisplayedForEmtpyField() {
        boolean isAlertPresent = Contact.verifyAlert(driver);
        Assert.assertTrue("Notifikasi login tidak valid tidak terdeteksi!", isAlertPresent);
    }

    @Then("Submit The form")
    public void submitTheForm() {
        boolean button = Contact.clickSubmit(driver);
        assertTrue("Button dont displayed",button);
    }
}
