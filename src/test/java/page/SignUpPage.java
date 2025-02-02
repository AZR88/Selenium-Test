package page;

import Helper.WaitElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {
    public static By SignUpButton = By.id("signin2");
    public static By SignUpusernameInput = By.id("sign-username");
    public static By SignUppasswordInput = By.id("sign-password");
    public static By SubmitButton = By.cssSelector("button[onclick='register()']");



    public static boolean openSignupPage(WebDriver driver) {
        try {
            WaitElement.waitForElement(SignUpButton);
            WebElement SignBut = driver.findElement(SignUpButton);
            SignBut.click();
            return true ;
        }catch ( TimeoutException | NoSuchElementException e) {
            return false ;
        }
    }

    public static String SignUpusernameInput(WebDriver driver, String name) {
        WaitElement.waitForElement(SignUpusernameInput);
        WebElement usernameField = driver.findElement(SignUpusernameInput);
        usernameField.sendKeys(name);
        return usernameField.getAttribute("value");
    }

    public static String SignUppasswordInput(WebDriver driver, String password) {
        WaitElement.waitForElement(SignUpButton);
        WebElement passwordField = driver.findElement(SignUppasswordInput);
        passwordField.sendKeys(password);
        return passwordField.getAttribute("value");
    }

    public static boolean ClikSubmit(WebDriver driver) {
        try {
            WaitElement.waitForElement(SubmitButton);
            WebElement SubmitBut = driver.findElement(SubmitButton);
        SubmitBut.click();
        return true;
        } catch (TimeoutException | NoSuchElementException e ){
            return false;
        }
    }

    public static boolean verifySignupAlert(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (TimeoutException e) {
            System.out.println("No alert detected within the timeout.");
            return false;
        }
        }

    }




