package stepDef;

import io.cucumber.core.cli.Main;
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
        boolean ButtonCliked = Contact.clickContact(driver);
        assertTrue("Button not Cliked",ButtonCliked);

    }

    @Then("the user enters their email {string}")
    public void theUserEntersTheirEmail(String email) {
       String input =  Contact.inputemail(driver, email);
       assertEquals("invalid input",input,email);
    }

    @And("the user enters their name {string}")
    public void theUserEntersTheirName(String name) {
       String input =  Contact.inputname(driver, name);
        assertEquals("invalid input",name, input);
    }

    @And("the user enters their message {string}")
    public void theUserEntersTheirMessage(String message) {
        String input =  Contact.inputmassage(driver,message);
        assertEquals("invalid input",message,input);
    }

    @And("the user click Submit")
    public void theUserClickSubmit() {
        boolean button = Contact.clickSubmit(driver);
        assertTrue("Button dont displayed",button);
    }



    @Then("an error message should be displayed for emtpy field")
    public void anErrorMessageShouldBeDisplayedForEmtpyField() {
        boolean isAlertPresent = Login_Page.isLoginAlertPresent(driver);
        Assert.assertTrue("Notifikasi login tidak valid tidak terdeteksi!", isAlertPresent);
    }
}
