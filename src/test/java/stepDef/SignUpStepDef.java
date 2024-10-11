package stepDef;

import io.cucumber.java.en.When;
import static Helper.WebHelper.driver;
import static page.SignUp_Page.SignUpButton;

public class SignUpStepDef {
    @When("user click Signup button")
    public void userClickSignupButton() {
        driver.findElement(SignUpButton).click();
    }
}
