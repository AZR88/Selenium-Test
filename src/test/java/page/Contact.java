package page;
import Helper.WaitElement;
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
        try {
            WaitElement.waitForElement(ContactButton);
            WebElement Con = driver.findElement(ContactButton);
            Con.click();
            return true;
        }catch (TimeoutException | NoSuchElementException e){
            return false;
        }
    }
    public static String inputemail(WebDriver driver, String email) {
        WaitElement.waitForElement(SenderEmail);
        WebElement EmailField = driver.findElement(SenderEmail);
        EmailField.sendKeys(email);
        return EmailField.getAttribute("value");
    }

    public static String inputname(WebDriver driver, String name) {
        WaitElement.waitForElement(SenderName);
        WebElement namefield = driver.findElement(SenderName);
        namefield.sendKeys(name);
        return namefield.getAttribute("value");
    }

    public static String inputmassage(WebDriver driver, String  massage) {
        WaitElement.waitForElement(Message);
        WebElement massagefield = driver.findElement(Message);
        massagefield.sendKeys(massage);
        return massagefield.getAttribute("value");
    }

    public static boolean clickSubmit(WebDriver driver){
        try {
            WaitElement.waitForElement(submit);
            WebElement Submt = driver.findElement(submit);
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

