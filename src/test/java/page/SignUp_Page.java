package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUp_Page {
    public static By SignUpButton = By.id("signin2");
    public static  By SignUpusernameInput = By.id("sign-username");
    public static  By SignUppasswordInput = By.id("sign-password");
    public static  By SubmitButton = By.xpath("button[onclick='register()']");

    public static void openSignupPage(WebDriver driver){
        driver.findElement(SignUpButton).click();
    }


}



