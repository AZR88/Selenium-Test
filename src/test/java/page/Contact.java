package page;
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

    public static boolean clickContact (WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
        WebElement Con = wait.until(ExpectedConditions.visibilityOfElementLocated(ContactButton));
        Con.click();
        return true;
        }catch (TimeoutException | NoSuchElementException e){
            return false;
        }
    }
    public static String inputemail(WebDriver driver, String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement EmailField = wait.until(ExpectedConditions.visibilityOfElementLocated(SenderEmail));
        EmailField.sendKeys(email);
        return EmailField.getAttribute("Value");
    }

    public static String inputname(WebDriver driver, String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement namefield = wait.until(ExpectedConditions.visibilityOfElementLocated(SenderName));
        namefield.sendKeys(name);
        return namefield.getAttribute("value");
    }

    public static String inputmassage(WebDriver driver, String  massage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement massagefield = wait.until(ExpectedConditions.visibilityOfElementLocated(Message));
        massagefield.sendKeys(massage);
        return massagefield.getAttribute("value");
    }

    public static boolean clickSubmit(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement Submt = wait.until(ExpectedConditions.visibilityOfElementLocated(submit));
            Submt.click();
            return true;
        }catch (TimeoutException | NoSuchElementException e){
            return false;
        }
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

