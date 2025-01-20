package page;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static Helper.WebHelper.driver;

public class Login_Page {

    //locators
    public static By loginButton = By.id("login2");
    public static By usernameInputText = By.cssSelector("#loginusername");
    public static By passwordInputText = By.xpath("//*[@id='loginpassword']");
    public static By submitButton = By.xpath("//button[text()='Log in']");
    public static By UserID =By.xpath("//a[@id='nameofuser']");



    public static void UrlCheck(WebDriver driver, String expectedUrl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }


    public static WebElement openLoginPage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement Logbut = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        return Logbut;
    }


    public static WebElement inputUsername(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInputText));
        return usernameField;
    }



    public static WebElement inputPassword(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInputText));
        return passwordField;
    }

    public static WebElement clickSubmitButton (WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement SmbBut = wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
    return SmbBut;
    }

    public static boolean verifyUserID(WebDriver driver, String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement userIDElement = wait.until(ExpectedConditions.visibilityOfElementLocated(UserID));


        String actualUserID = userIDElement.getText();
        return actualUserID.contains(username);
    }

    public static WebElement verifyLoginAlert(WebDriver driver) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("yourElementId")));

                System.out.println("Element found: " + element.getText());
                return element;

            } catch (TimeoutException e) {
                System.out.println("Element tidak muncul dalam waktu yang ditentukan.");
                return null; // Return null or handle it as per your requirement
            }

    }

}
