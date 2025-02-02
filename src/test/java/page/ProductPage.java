package page;

import Helper.WaitElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    public static By ProductPic = By.xpath("//div[@id='imgp']//img");
    public static By ProductTitle = By.xpath("//h2[@class='name']");
    public static By ProductPrice = By.xpath("//div[@id='tbodyid']/h3[@class='price-container']");
    public static By AddToCart= By.xpath("//a[@class='btn btn-success btn-lg' and text()='Add to cart']");

    public static boolean isProductDescriptionDisplayed(WebDriver driver, String productdesc) {
        By descLocator = By.xpath("//p[contains(text(),'" + productdesc + "')]");
        try {
            WaitElement.waitForElement(descLocator);
            WebElement productDescriptionElement = driver.findElement(descLocator);
            return productDescriptionElement.isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("Element with product description '" + productdesc + "' not found or not visible.");
            return false;
        }
    }


    public static String  checkTitle(WebDriver driver) {
        WaitElement.waitForElement(ProductTitle);
        WebElement ItemTitle = driver.findElement(ProductTitle);
        return ItemTitle.getText();
    }

    public static String checkPrice(WebDriver driver) {
        WaitElement.waitForElement(ProductPrice);
        WebElement itemPrice = driver.findElement(ProductPrice);
        String text = itemPrice.getText();
        String actualPrice = text.split("\n")[0].replaceAll("[^\\d$.]", "").trim();
        return  actualPrice;
    }



    public static boolean checkPic(WebDriver driver){
        try {
            WaitElement.waitForElement(ProductPic);
            WebElement ItemPic = driver.findElement(ProductPic);
            return ItemPic.isDisplayed();
        } catch ( TimeoutException | NoSuchElementException e){
            return false;
        }
    }

    public static Boolean clickAdd (WebDriver driver){
                try {
                    WaitElement.waitForElement(AddToCart);
                    WebElement Add = driver.findElement(AddToCart);
                    Add.click();
                    return true;
                }catch (TimeoutException | NoSuchElementException e){
                    return false;
                }
            }



    public static boolean isAlertPresent(WebDriver driver) {
    try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        return true;
    } catch (TimeoutException e) {
            System.out.println("No alert detected within the timeout.");
            return false;
        }
    }
}







