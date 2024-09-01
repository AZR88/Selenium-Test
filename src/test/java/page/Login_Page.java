package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login_Page {

    public void login(WebDriver driver, String username, String password) throws InterruptedException {
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("login2")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loginusername")));
        usernameField.sendKeys(username);

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='loginpassword']")));
        passwordField.sendKeys(password);

        driver.findElement(By.cssSelector("button[onclick='logIn()']")).click();

        Thread.sleep(5000);
    }
}
