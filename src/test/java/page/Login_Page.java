package page;

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

    public static boolean verifyLoginAlert(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            // Mengambil teks dari alert
            String alertText = alert.getText();
            System.out.println("Teks notifikasi login invalid: " + alertText);

            // Memverifikasi teks alert sesuai yang diharapkan
            if (alertText.equals("User does not exist.")) {
                System.out.println("Alert menunjukkan: 'User does not exist.'");
                alert.accept(); // Menutup alert
                return false; // Mengembalikan false jika username salah
            } else if (alertText.equals("Wrong password.")) {
                System.out.println("Alert menunjukkan: 'Wrong password.'");
                alert.accept(); // Menutup alert
                return false; // Mengembalikan false jika password salah
            } else {
                System.out.println("Notifikasi login invalid tidak sesuai.");
                alert.accept(); // Menutup alert
                return false; // Mengembalikan false jika teks tidak sesuai
            }
        } catch (TimeoutException e) {
            System.out.println("Alert tidak muncul dalam waktu yang ditentukan.");
            return false; // Mengembalikan false jika alert tidak muncul
        }

    }
}
