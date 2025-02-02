package page;

import Helper.WaitElement;
import org.openqa.selenium.*;
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


    public static boolean ClickNext(WebDriver driver) {
        try {
            WaitElement.waitForElement(nextbutton);
            WebElement Next = driver.findElement(nextbutton);
            Next.click();
            return true;
        }catch (TimeoutException | NoSuchElementException e ){
            return false;
        }
    }

    public static boolean clickPhoneCategory(WebDriver driver) {
        try {
            WaitElement.waitForElement(PhoneCat);
            WebElement Category = driver.findElement(PhoneCat);
            Category.click();
            return true;
        }catch (TimeoutException | NoSuchElementException e ){
            return false;
        }
    }
    public static boolean clickLaptopCategory(WebDriver driver) {
        try {
            WaitElement.waitForElement(LaptopCat);
            WebElement Category = driver.findElement(LaptopCat);
            Category.click();
            return true;
        }catch (TimeoutException | NoSuchElementException e ){
            return false;
        }
    }

    public static boolean clickMonitorCategory(WebDriver driver) {
        try {
            WaitElement.waitForElement(MonitorCat);
            WebElement Category = driver.findElement(MonitorCat);
            Category.click();
            return true;
        }catch (TimeoutException | NoSuchElementException e ){
            return false;
        }
    }

    public static boolean CheckHomebutton(WebDriver driver){
        try {
            WaitElement.waitForElement(HomeButton);
            WebElement element = driver.findElement(HomeButton);
            element.click();
            return true;
        }catch (TimeoutException | NoSuchElementException e){
            return false;
        }
    }



    public static boolean CheckSignupbutton(WebDriver driver){
        try {
            WaitElement.waitForElement(SignUpButton);
            WebElement element = driver.findElement(SignUpButton);
            return element.isDisplayed();
        }catch (TimeoutException | NoSuchElementException e){
            return false;
        }
    }

    public static boolean CheckAboutbutton(WebDriver driver){
        try {
            WaitElement.waitForElement(AboutUsButton);
            WebElement element = driver.findElement(AboutUsButton);
            return element.isDisplayed();
        }catch (TimeoutException | NoSuchElementException e){
            return false;
        }
    }

    public static boolean CheckCartbutton(WebDriver driver){
        try {
            WaitElement.waitForElement(CartButton);
            WebElement element = driver.findElement(CartButton);
            return element.isDisplayed();
        }catch (TimeoutException | NoSuchElementException e){
            return false;
        }
    }

    public static boolean CheckLoginbutton(WebDriver driver){
        try {
            WaitElement.waitForElement(LoginButton);
            WebElement element = driver.findElement(LoginButton);
            return element.isDisplayed();
        }catch (TimeoutException | NoSuchElementException e){
            return false;
        }
    }

    public static boolean Checkcontactbutton(WebDriver driver){
        try {
            WaitElement.waitForElement(ContactButton);
            WebElement element = driver.findElement(ContactButton);
            return element.isDisplayed();
        }catch (TimeoutException | NoSuchElementException e){
            return false;
        }
    }
    public static boolean ClickCartbutton(WebDriver driver){
        try {
            WaitElement.waitForElement(CartButton);
            WebElement element = driver.findElement(CartButton);
            element.click();
            return true;
        }catch (TimeoutException | NoSuchElementException e){
            return false;
        }
    }

    public static boolean ClickHomebutton(WebDriver driver){
        try {
            WaitElement.waitForElement(CartButton);
            WebElement element = driver.findElement(HomeButton);
            element.click();
            return true;
        }catch (TimeoutException | NoSuchElementException e){
            return false;
        }
    }


    public static boolean selectItemByName(WebDriver driver, String itemName) {
        By itemLocator = By.xpath("//a[contains(text(), '" + itemName + "')]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            WebElement itemElement = wait.until(ExpectedConditions.visibilityOfElementLocated(itemLocator));
            itemElement.click();
            return true;
        } catch (TimeoutException|NoSuchElementException e ){
            return false;
        }
    }



}
