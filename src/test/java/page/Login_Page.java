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

    //open the login page
    public static void openLoginPage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement Logbut = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(loginButton).click();
        Assert.assertTrue(Logbut.isDisplayed());
    }

    //  input username
    public static void inputUsername(WebDriver driver, String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInputText));
        usernameField.sendKeys(username);
        Assert.assertTrue(usernameField.isDisplayed());
    }

    // input password
    public static void inputPassword(WebDriver driver, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInputText));
        passwordField.sendKeys(password);
        Assert.assertTrue(passwordField.isDisplayed());
    }

    // click the login button
    public static void clickSubmitButton(WebDriver driver) {
        driver.findElement(submitButton).click();
    }

    public static boolean verifyUserID(WebDriver driver, String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement userIDElement = wait.until(ExpectedConditions.visibilityOfElementLocated(UserID));


        String actualUserID = userIDElement.getText();
        return actualUserID.contains(username);
    }

    public static void verifyLoginAlert(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            // Mengambil teks dari alert
            String alertText = alert.getText();
            System.out.println("Teks notifikasi login invalid: " + alertText);

            // Memverifikasi teks alert sesuai yang diharapkan
            boolean isAlertValid = false;

            if (alertText.equals("User does not exist.")) {
                System.out.println("Alert menunjukkan: 'User does not exist.'");
                isAlertValid = true; // Menandai alert valid
            } else if (alertText.equals("Wrong password.")) {
                System.out.println("Alert menunjukkan: 'Wrong password.'");
                isAlertValid = true; // Menandai alert valid
            } else {
                System.out.println("Notifikasi login invalid tidak sesuai: " + alertText);
            }

            alert.accept(); // Menutup alert

            // Memverifikasi hasil menggunakan assertTrue
            Assert.assertTrue("Notifikasi login tidak sesuai.", isAlertValid);

        } catch (TimeoutException e) {
            System.out.println("Alert tidak muncul dalam waktu yang ditentukan.");
            Assert.fail("Alert tidak muncul dalam waktu yang ditentukan."); // Menghasilkan kegagalan assertion
        }
    }
}
