package page;
import Helper.WaitElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class Contact {

    public static  By contactButton = By.xpath("//a[normalize-space()='Contact']");
    public static By senderEmail = By.id("recipient-email");
    public static By senderName = By.id("recipient-name");
    public static By message = By.id("message-text");
    public static By submit = By.xpath("//button[.='Send message']");

    public static boolean clickContact (WebDriver driver) {
        try {
            WaitElement.waitForElement(contactButton);
            WebElement con = driver.findElement(contactButton);
            con.click();
            return true;
        }catch (TimeoutException | NoSuchElementException e){
            return false;
        }
    }
    public static String inputEmail(WebDriver driver, String email) {
        WaitElement.waitForElement(senderEmail);
        WebElement emailField = driver.findElement(senderEmail);
        emailField.sendKeys(email);
        return emailField.getAttribute("value");
    }

    public static String inputName(WebDriver driver, String name) {
        WaitElement.waitForElement(senderName);
        WebElement namefield = driver.findElement(senderName);
        namefield.sendKeys(name);
        return namefield.getAttribute("value");
    }

    public static String inputMassage(WebDriver driver, String  massage) {
        WaitElement.waitForElement(message);
        WebElement massagefield = driver.findElement(message);
        massagefield.sendKeys(massage);
        return massagefield.getAttribute("value");
    }

    public static boolean clickSubmit(WebDriver driver){
        try {
            WaitElement.waitForElement(submit);
            WebElement submt = driver.findElement(submit);
            submt.click();
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

