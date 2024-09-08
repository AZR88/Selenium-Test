package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUp_Page {
    public static By SignUpButton = By.id("signin2");
    public static  By SignUpusernameInput = By.id("sign-username");
    public static  By SignUppasswordInput = By.id("sign-password");
    public static  By SubmitButton = By.xpath("button[onclick='register()']");

    public static void openSignupPage(WebDriver driver){
        driver.findElement(SignUpButton).click();
    }

    public static  void SignUpusernameInput(WebDriver driver, String username){
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement usernameField =  wait.until(ExpectedConditions.visibilityOfElementLocated(SignUpusernameInput));
        usernameField.sendKeys(username);
    }

    public static void SignUppasswordInput(WebDriver driver, String password){
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement passwordField =  wait.until(ExpectedConditions.visibilityOfElementLocated(SignUppasswordInput));
        passwordField.sendKeys(password);
    }

    public static void ClikSubmit (WebDriver driver){

    }
}



