package page;

import Helper.WaitElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.UUID;

public class SignUpPage {
    public static By signUpButton = By.id("signin2");
    public static By signUpUsernameInput = By.id("sign-username");
    public static By signUpPasswordInput = By.id("sign-password");
    public static By SubmitButton = By.cssSelector("button[onclick='register()']");



    public static boolean openSignupPage(WebDriver driver) {
        try {
            WaitElement.waitForElement(signUpButton);
            WebElement signBut = driver.findElement(signUpButton);
            signBut.click();
            return true ;
        }catch ( TimeoutException | NoSuchElementException e) {
            return false ;
        }
    }

    public static String signUpusernameInput(WebDriver driver, String name) {
        WaitElement.waitForElement(signUpUsernameInput);
        WebElement usernameField = driver.findElement(signUpUsernameInput);
        usernameField.sendKeys(name);
        return usernameField.getAttribute("value");
    }

    public static String signUppasswordInput(WebDriver driver, String password) {
        WaitElement.waitForElement(signUpButton);
        WebElement passwordField = driver.findElement(signUpPasswordInput);
        passwordField.sendKeys(password);
        return passwordField.getAttribute("value");
    }

    public static boolean clikSubmit (WebDriver driver) {
        try {
            WaitElement.waitForElement(SubmitButton);
            WebElement submitBut = driver.findElement(SubmitButton);
        submitBut.click();
        return true;
        } catch (TimeoutException | NoSuchElementException e ){
            return false;
        }
    }

    public static String getAlertText(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertText = alert.getText();
            alert.accept();
            return alertText;
        } catch (TimeoutException e) {
            System.out.println("No alert detected within the timeout");
            return null;
        }
    }

}



