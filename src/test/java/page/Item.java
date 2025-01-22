package page;

import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Item {
    private static By HomeButton = By.xpath("//li[@class='nav-item active']//a[@class='nav-link']");
    private static By ContactButton = By.xpath("//a[normalize-space()='Contact']");
    private static By AboutUsButton = By.xpath("//a[normalize-space()='About us']");
    private static By CartButton = By.xpath("(//a[normalize-space()='Cart'])");
    private static By LoginButton = By.id("login2");
    private static By SignUpButton = By.id("signin2");


    private  static By nextbutton = By.id("next2");
    private  static By PhoneCat = By.xpath("//a[@onclick=\"byCat('phone')\"]");
    private  static By LaptopCat = By.xpath("//a[@onclick=\"byCat('notebook')\"]");
    private  static By MonitorCat = By.xpath("//a[@onclick=\"byCat('monitor')\"]");

    public static By getProductTitleLocatorById(String productId, String expectedTitle) {
        return By.xpath("//a[contains(@href, 'prod.html?idp_=" + productId + "') and contains(text(), '" + expectedTitle + "')]");
    }
    private static By getProductPriceLocator(String expectedPrice, String productId) {
        return By.xpath("//a[contains(@href, 'prod.html?idp_=" + productId + "')]/following::h5[contains(text(), '" + expectedPrice + "')]");
    }




    public static boolean isTitleAndPriceTextEqual(WebDriver driver, String productId, String expectedTitle, String expectedPrice) {
        By productTitleLocator = getProductTitleLocatorById(productId, expectedTitle);
        By productPriceLocator = getProductPriceLocator(expectedPrice, productId);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productTitleLocator));
        String actualTitle = titleElement.getText();

        WebElement priceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productPriceLocator));
        String actualPrice = priceElement.getText();

        return actualTitle.equals(expectedTitle) && actualPrice.equals(expectedPrice);
    }


    public static WebElement ClickNext(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Next = wait.until(ExpectedConditions.visibilityOfElementLocated(nextbutton));
        return Next;
    }

    public static WebElement clickPhoneCategory(WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement PhonCat = wait.until(ExpectedConditions.visibilityOfElementLocated(PhoneCat));
        return PhonCat;
    }
    public static WebElement clickLaptopCategory(WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement LapCat = wait.until(ExpectedConditions.visibilityOfElementLocated(LaptopCat));

        return LapCat;
    }

    public static WebElement clickMonitorCategory(WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement MonCat = wait.until(ExpectedConditions.visibilityOfElementLocated(MonitorCat));
        return MonCat;
    }

    public static WebElement CheckHomebutton(WebDriver driver){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Home = wait.until(ExpectedConditions.visibilityOfElementLocated(HomeButton));
        return Home;
    }



    public static WebElement CheckSignupbutton(WebDriver driver){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Sign = wait.until(ExpectedConditions.visibilityOfElementLocated(SignUpButton));
        return  Sign;
    }

    public static WebElement CheckAboutbutton(WebDriver driver){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement About = wait.until(ExpectedConditions.visibilityOfElementLocated(AboutUsButton));
        return About;
    }

    public static WebElement CheckCartbutton(WebDriver driver){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Cart = wait.until(ExpectedConditions.visibilityOfElementLocated(CartButton));

        return Cart;
    }

    public static WebElement CheckLoginbutton(WebDriver driver){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Log = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginButton));
        return Log;
    }

    public static WebElement Checkcontactbutton(WebDriver driver){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Cont = wait.until(ExpectedConditions.visibilityOfElementLocated(ContactButton));
        return Cont;
    }
    public static WebElement ClickCartbutton(WebDriver driver){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Cart = wait.until(ExpectedConditions.visibilityOfElementLocated(CartButton));

        return  Cart;
    }

    public static WebElement ClickHomebutton(WebDriver driver){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Home = wait.until(ExpectedConditions.visibilityOfElementLocated(HomeButton));
        return Home;
    }


    public static WebElement selectItemByName(WebDriver driver, String itemName) {
        By itemLocator = By.xpath("//a[contains(text(), '" + itemName + "')]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement itemElement = wait.until(ExpectedConditions.visibilityOfElementLocated(itemLocator));
        return itemElement;
    }



}
