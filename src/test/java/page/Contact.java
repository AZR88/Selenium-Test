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
    public static By Cancel =By.xpath("//div[@id='exampleModal']//button[@type='button'][normalize-space()='Close']");

    public static void clickContact (WebDriver driver) {
        driver.findElement(ContactButton).click();
    }

    //  input username
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
        Assert.assertTrue(namefield.isEnabled());
    }

    public static void inputmassage(WebDriver driver, String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement massagefield = wait.until(ExpectedConditions.visibilityOfElementLocated(Message));
    }
}

