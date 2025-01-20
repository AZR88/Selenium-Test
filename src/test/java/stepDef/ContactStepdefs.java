package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.Contact;
import page.Product_Page;

import static Helper.WebHelper.driver;

public class ContactStepdefs {
    @When("Click Contact")
    public void clickContact() {
        Contact.clickContact(driver);
    }

    @Then("the user enters their email {string}")
    public void theUserEntersTheirEmail(String arg0) {
        Contact.inputemail(driver,arg0);
    }

    @And("the user enters their name {string}")
    public void theUserEntersTheirName(String arg0) {
        Contact.inputname(driver,arg0);
    }

    @And("the user enters their message {string}")
    public void theUserEntersTheirMessage(String arg0) {
        Contact.inputmassage(driver,arg0);
    }

    @And("the user click Submit")
    public void theUserClickSubmit() {
        Contact.clickSubmit(driver);
    }

    @Then("the contact form should be successfully filled")
    public void theContactFormShouldBeSuccessfullyFilled() {

    }

    @Then("an error message should be displayed for emtpy field")
    public void anErrorMessageShouldBeDisplayedForEmtpyField() {

    }
}
