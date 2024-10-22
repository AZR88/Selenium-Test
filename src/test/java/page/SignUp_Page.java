package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUp_Page {
    public static By SignUpButton = By.id("signin2");
    public static  By SignUpusernameInput = By.id("sign-username");
    public static  By SignUppasswordInput = By.id("sign-password");
    public static  By SubmitButton = By.cssSelector("button[onclick='register()']");

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
        driver.findElement(SubmitButton);
    }

    public static boolean verifySignupAlert(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            // Mengambil teks dari alert
            String alertText = alert.getText();
            System.out.println("Teks notifikasi login invalid: " + alertText);

            // Memverifikasi teks alert sesuai yang diharapkan
            if(alertText.equals("Sign up successful.")) {
                System.out.println("Alert menunjukkan: 'Sign up successful.'");
                alert.accept();
                return true;
            }
            else if (alertText.equals("This user already exist.")) {
                System.out.println("Alert menunjukkan: 'This user already exist.'");
                alert.accept();
                return false;
            } else if (alertText.equals("Please fill out Username and Password.")) {
                System.out.println("Alert menunjukkan: 'Please fill out Username and Password.'");
                alert.accept();
                return false;
            } else {
                System.out.println("Notifikasi login invalid tidak sesuai.");
                alert.accept();
                return false;
            }
        } catch (TimeoutException e) {
            System.out.println("Alert tidak muncul dalam waktu yang ditentukan.");
            return false;
        }

    }
}



