package page;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginpage {

    @Test
    public void UI() throws InterruptedException {
        WebDriver driver = WebDriverManager.edgedriver().create();
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("login2")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loginusername")));
        usernameField.sendKeys("Beta123");
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='loginpassword']")));
        passwordField.sendKeys("123");

        driver.findElement(By.cssSelector("button[onclick='logIn()']")).click();

        Thread.sleep(5000);

        driver.quit();
    }
}
