package page;

import Helper.WaitElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    public static By productPic = By.xpath("//div[@id='imgp']//img");
    public static By productTitle = By.xpath("//h2[@class='name']");
    public static By productPrice = By.xpath("//div[@id='tbodyid']/h3[@class='price-container']");
    public static By addToCart = By.xpath("//a[@class='btn btn-success btn-lg' and text()='Add to cart']");

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
        WaitElement.waitForElement(productTitle);
        WebElement itemTitle = driver.findElement(productTitle);
        return itemTitle.getText();
    }

    public static String checkPrice(WebDriver driver) {
        WaitElement.waitForElement(productPrice);
        WebElement itemPrice = driver.findElement(productPrice);
        String text = itemPrice.getText();
        String actualPrice = text.split("\n")[0].replaceAll("[^\\d$.]", "").trim();
        return  actualPrice;
    }



    public static boolean checkPic(WebDriver driver){
        try {
            WaitElement.waitForElement(productPic);
            WebElement itemPic = driver.findElement(productPic);
            return itemPic.isDisplayed();
        } catch ( TimeoutException | NoSuchElementException e){
            return false;
        }
    }

    public static Boolean clickAdd (WebDriver driver){
                try {
                    WaitElement.waitForElement(addToCart);
                    WebElement add = driver.findElement(addToCart);
                    add.click();
                    return true;
                }catch (TimeoutException | NoSuchElementException e){
                    return false;
                }
            }



    public static String getAlertText(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertText = alert.getText();
            alert.accept();
            return alertText;
        } catch (TimeoutException e) {
            System.out.println("No alert detected within the timeout");
            return null;
        }
    }

}







