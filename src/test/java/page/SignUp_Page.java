package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUp_Page {
    public static By SignUpButton = By.id("signin2");
    public static By SignUpusernameInput = By.id("sign-username");
    public static By SignUppasswordInput = By.id("sign-password");
    public static By SubmitButton = By.cssSelector("button[onclick='register()']");



    public static boolean openSignupPage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement SignBut = wait.until(ExpectedConditions.visibilityOfElementLocated(SignUpButton));
            SignBut.click();
            return true ;
        }catch ( TimeoutException | NoSuchElementException e) {
            return false ;
        }
    }

    public static String SignUpusernameInput(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(SignUpusernameInput));
        usernameField.sendKeys();
        return usernameField.getAttribute("value");
    }

    public static String SignUppasswordInput(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(SignUppasswordInput));
        passwordField.sendKeys();
        return passwordField.getAttribute("value");
    }

    public static boolean ClikSubmit(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
        WebElement SubmitBut = wait.until(ExpectedConditions.visibilityOfElementLocated(SubmitButton));
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




