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

    public static WebElement clickContact (WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement Con = wait.until(ExpectedConditions.visibilityOfElementLocated(ContactButton));
        return Con;
    }
    public static WebElement inputemail(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement EmailField = wait.until(ExpectedConditions.visibilityOfElementLocated(SenderEmail));
        return EmailField;
    }

    public static WebElement inputname(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement namefield = wait.until(ExpectedConditions.visibilityOfElementLocated(SenderName));
        return namefield;
    }

    public static WebElement inputmassage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement massagefield = wait.until(ExpectedConditions.visibilityOfElementLocated(Message));
        return massagefield;
    }

    public static WebElement clickSubmit(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement Submt = wait.until(ExpectedConditions.visibilityOfElementLocated(submit));
        return Submt;
    }

    public static boolean verifyAlert(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (TimeoutException e) {
            System.out.println("No alert detected within the timeout.");
            return false;
        }
    }
}

