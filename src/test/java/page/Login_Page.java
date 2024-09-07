package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Login_Page {

    //locators
    public static By loginButton = By.id("login2");
    public static By usernameInputText = By.cssSelector("#loginusername");
    public static By passwordInputText = By.xpath("//*[@id='loginpassword']");
    public static By submitButton = By.cssSelector("button[onclick='logIn()']");
    public static By UserID =By.xpath("//a[@id='nameofuser']");

    //open the login page
    public static void openLoginPage(WebDriver driver) {
        driver.findElement(loginButton).click();
    }

    //  input username
    public static void inputUsername(WebDriver driver, String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInputText));
        usernameField.sendKeys(username);
    }

    // input password
    public static void inputPassword(WebDriver driver, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInputText));
        passwordField.sendKeys(password);
    }

    // click the login button
    public static void clickSubmitButton(WebDriver driver) {
        driver.findElement(submitButton).click();
    }

    public static boolean verifyUserID(WebDriver driver, String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement userIDElement = wait.until(ExpectedConditions.visibilityOfElementLocated(UserID));

        // Get the text of the UserID element and compare it with the username
        String actualUserID = userIDElement.getText();

        // Assuming the UserID includes something like "Welcome, <username>", we can compare this:
        return actualUserID.contains(username);
    }
}
