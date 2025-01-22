package page;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Product_Page {

    public static By ProductPic = By.xpath("//div[@id='imgp']//img");
    public static By ProductTitle = By.xpath("//h2[@class='name']");
    public static By ProductPrice = By.xpath("//div[@id='tbodyid']/h3[@class='price-container']");
    public static By AddToCart= By.xpath("//a[@class='btn btn-success btn-lg' and text()='Add to cart']");

    public static WebElement ProductDesc(WebDriver driver, String productdesc) {
        By descLocator = By.xpath("//p[contains(text(),'" + productdesc + "')]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(descLocator));
    }


    public static WebElement checkTitle(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ItemTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(ProductTitle));
        return ItemTitle;
    }

    public static WebElement checkPrice(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement itemPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPrice));
        return  itemPrice;
    }



    public static WebElement checkPic(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ItemPic = wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPic));
        return ItemPic;
    }

    public static WebElement clickAdd (WebDriver driver){
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement Add = wait.until(ExpectedConditions.visibilityOfElementLocated(AddToCart));
                return Add;
            }

            public static boolean isAlertPresent(WebDriver driver) {
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







