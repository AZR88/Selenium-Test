package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import page.SignUp_Page;

import static Helper.WebHelper.driver;
import static page.SignUp_Page.SignUpButton;

public class SignUpStepDef {
    @When("user click Signup button")
    public void userClickSignupButton() {
        driver.findElement(SignUpButton).click();
    }

    @And("user input username with \\{sosososo}")
    public void userInputUsernameWithSosososo(String arg0) {
        SignUp_Page.SignUpusernameInput(dri);
    }
}
