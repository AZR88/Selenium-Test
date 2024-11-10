package page;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUp_Page {
    public static By SignUpButton = By.id("signin2");
    public static By SignUpusernameInput = By.id("sign-username");
    public static By SignUppasswordInput = By.id("sign-password");
    public static By SubmitButton = By.cssSelector("button[onclick='register()']");

    public static void openSignupPage(WebDriver driver) {
        driver.findElement(SignUpButton).click();
    }

    public static void SignUpusernameInput(WebDriver driver, String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(SignUpusernameInput));
        usernameField.sendKeys(username);
        Assert.assertTrue(usernameField.isDisplayed());
    }

    public static void SignUppasswordInput(WebDriver driver, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(SignUppasswordInput));
        passwordField.sendKeys(password);
        Assert.assertTrue(passwordField.isDisplayed());
    }

    public static void ClikSubmit(WebDriver driver) {
        driver.findElement(SubmitButton);
    }

    public static void verifySignupAlert(WebDriver driver) {
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



