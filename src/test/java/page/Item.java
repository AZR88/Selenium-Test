package page;

import Helper.WaitElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Item {
    private static By homeButton = By.xpath("//li[@class='nav-item active']//a[@class='nav-link']");
    private static By contactButton = By.xpath("//a[normalize-space()='Contact']");
    private static By aboutUsButton = By.xpath("//a[normalize-space()='About us']");
    private static By cartButton = By.xpath("(//a[normalize-space()='Cart'])");
    private static By loginButton = By.id("login2");
    private static By signUpButton = By.id("signin2");


    private  static By nextbutton = By.id("next2");
    private  static By phoneCat = By.xpath("//a[@onclick=\"byCat('phone')\"]");
    private  static By laptopCat = By.xpath("//a[@onclick=\"byCat('notebook')\"]");
    private  static By monitorCat = By.xpath("//a[@onclick=\"byCat('monitor')\"]");

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


    public static boolean clickNext(WebDriver driver) {
        try {
            WaitElement.waitForElement(nextbutton);
            WebElement next = driver.findElement(nextbutton);
            next.click();
            return true;
        }catch (TimeoutException | NoSuchElementException e ){
            return false;
        }
    }

    public static boolean clickPhoneCategory(WebDriver driver) {
        try {
            WaitElement.waitForElement(phoneCat);
            WebElement category = driver.findElement(phoneCat);
            category.click();
            return true;
        }catch (TimeoutException | NoSuchElementException e ){
            return false;
        }
    }
    public static boolean clickLaptopCategory(WebDriver driver) {
        try {
            WaitElement.waitForElement(laptopCat);
            WebElement category = driver.findElement(laptopCat);
            category.click();
            return true;
        }catch (TimeoutException | NoSuchElementException e ){
            return false;
        }
    }

    public static boolean clickMonitorCategory(WebDriver driver) {
        try {
            WaitElement.waitForElement(monitorCat);
            WebElement category = driver.findElement(monitorCat);
            category.click();
            return true;
        }catch (TimeoutException | NoSuchElementException e ){
            return false;
        }
    }

    public static boolean checkHomebutton(WebDriver driver){
        try {
            WaitElement.waitForElement(homeButton);
            WebElement element = driver.findElement(homeButton);
            element.click();
            return true;
        }catch (TimeoutException | NoSuchElementException e){
            return false;
        }
    }



    public static boolean checkSignupbutton(WebDriver driver){
        try {
            WaitElement.waitForElement(signUpButton);
            WebElement element = driver.findElement(signUpButton);
            return element.isDisplayed();
        }catch (TimeoutException | NoSuchElementException e){
            return false;
        }
    }

    public static boolean checkAboutbutton(WebDriver driver){
        try {
            WaitElement.waitForElement(aboutUsButton);
            WebElement element = driver.findElement(aboutUsButton);
            return element.isDisplayed();
        }catch (TimeoutException | NoSuchElementException e){
            return false;
        }
    }

    public static boolean checkCartbutton(WebDriver driver){
        try {
            WaitElement.waitForElement(cartButton);
            WebElement element = driver.findElement(cartButton);
            return element.isDisplayed();
        }catch (TimeoutException | NoSuchElementException e){
            return false;
        }
    }

    public static boolean checkLoginbutton(WebDriver driver){
        try {
            WaitElement.waitForElement(loginButton);
            WebElement element = driver.findElement(loginButton);
            return element.isDisplayed();
        }catch (TimeoutException | NoSuchElementException e){
            return false;
        }
    }

    public static boolean checkContactButton(WebDriver driver){
        try {
            WaitElement.waitForElement(contactButton);
            WebElement element = driver.findElement(contactButton);
            return element.isDisplayed();
        }catch (TimeoutException | NoSuchElementException e){
            return false;
        }
    }
    public static boolean clickCartButton(WebDriver driver){
        try {
            WaitElement.waitForElement(cartButton);
            WebElement element = driver.findElement(cartButton);
            element.click();
            return true;
        }catch (TimeoutException | NoSuchElementException e){
            return false;
        }
    }

    public static boolean clickHomebutton(WebDriver driver){
        try {
            WaitElement.waitForElement(cartButton);
            WebElement element = driver.findElement(homeButton);
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
