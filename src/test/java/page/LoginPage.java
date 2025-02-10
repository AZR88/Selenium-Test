package page;

import Helper.WaitElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    // Locators
    public static By loginButton = By.id("login2");
    public static By usernameInputText = By.cssSelector("#loginusername");
    public static By passwordInputText = By.xpath("//*[@id='loginpassword']");
    public static By submitButton = By.xpath("//button[text()='Log in']");
    public static By userID = By.xpath("//a[@id='nameofuser']");

    // Check URL
    public static boolean isUrlCorrect(WebDriver driver, String expectedUrl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.urlToBe(expectedUrl));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    // Click Login Button
    public static boolean clickLoginButton(WebDriver driver) {
        try {
            WaitElement.waitForElement(loginButton);
            WebElement loginButtonElement = driver.findElement(loginButton);
            loginButtonElement.click();
            return true;
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    // Input Username
    public static String inputUsername(WebDriver driver, String username) {
        WaitElement.waitForElement(usernameInputText);
        WebElement usernameField = driver.findElement(usernameInputText);
        usernameField.clear();
        usernameField.sendKeys(username);
        return usernameField.getAttribute("value");
    }

    // Input Password
    public static String inputPassword(WebDriver driver, String password) {
        WaitElement.waitForElement(passwordInputText);
        WebElement passwordField = driver.findElement(passwordInputText);
        passwordField.clear();
        passwordField.sendKeys(password);
        return passwordField.getAttribute("value");
    }

    // Click Submit Button
    public static boolean clickSubmitButton(WebDriver driver) {
        try {
            WaitElement.waitForElement(submitButton);
            WebElement submitButtonElement = driver.findElement(submitButton);
            submitButtonElement.click();
            return true;
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    // Get Displayed Username
    public static String getDisplayedUsername(WebDriver driver) {
        WaitElement.waitForElement(userID);
        WebElement userIDElement = driver.findElement(userID);
        String rawText = userIDElement.getText().trim();
        if (rawText.startsWith("Welcome ")) {
            rawText = rawText.replace("Welcome ", "");
        }
        return rawText;
    }

    // Check if Login Alert is Present
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
