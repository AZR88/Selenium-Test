package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login_Page {

    private WebDriver driver;

    //locators
    private By loginButton = By.id("login2");
    private By usernameInputText = By.cssSelector("#loginusername");
    private By passwordInputText = By.xpath("//*[@id='loginpassword']");
    private By submitButton = By.cssSelector("button[onclick='logIn()']");

    // Constructor that will be called in the test class
    public Login_Page(WebDriver driver) {
        this.driver = driver;
    }

    //open the login page
    public void openLoginPage() {
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();
        driver.findElement(loginButton).click();
    }

    //  input username
    public void inputUsername(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInputText));
        usernameField.sendKeys(username);
    }

    // input password
    public void inputPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInputText));
        passwordField.sendKeys(password);
    }

    // click the login button
    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }
}
