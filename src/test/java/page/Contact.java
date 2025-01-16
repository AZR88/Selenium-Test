package page;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class Contact {

    public static  By ContactButton = By.xpath("//a[normalize-space()='Contact']");
    public static By SenderEmail = By.id("recipient-email");
    public static By SenderName = By.id("recipient-name");
    public static By Message = By.id("message-text");
    public static By submit = By.xpath("//button[.='Send message']");

    public static void clickContact (WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement Con = wait.until(ExpectedConditions.visibilityOfElementLocated(ContactButton));
        Con.click();

    }
    public static void inputemail(WebDriver driver, String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement EmailField = wait.until(ExpectedConditions.visibilityOfElementLocated(SenderEmail));
        EmailField.sendKeys(email);
        Assert.assertTrue(EmailField.isDisplayed());
    }

    public static void inputname(WebDriver driver, String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement namefield = wait.until(ExpectedConditions.visibilityOfElementLocated(SenderName));
        namefield.sendKeys(name);
        Assert.assertTrue(namefield.isDisplayed());
    }

    public static void inputmassage(WebDriver driver, String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement massagefield = wait.until(ExpectedConditions.visibilityOfElementLocated(Message));
        massagefield.sendKeys(message);
        Assert.assertTrue(massagefield.isDisplayed());
    }

    public static void clickSubmit(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement Submt = wait.until(ExpectedConditions.visibilityOfElementLocated(submit));
        Submt.click();
    }
}

