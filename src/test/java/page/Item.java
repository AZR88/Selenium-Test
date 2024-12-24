package page;

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

    public static void UrlCheck(WebDriver driver, String expectedUrl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
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

    public static void ClickNext(WebDriver driver, String nextProductID, String nextProductTitle) throws InterruptedException {

        driver.findElement(nextbutton).click();
        Thread.sleep(5000);
        By productTitleLocator = getProductTitleLocatorById(nextProductID, nextProductTitle);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productTitleLocator));


        Assert.assertEquals("Expected product title did not match", productTitleElement.getText(), nextProductTitle);
    }

    public static void clickPhoneCategory(WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement PhonCat = wait.until(ExpectedConditions.visibilityOfElementLocated(PhoneCat));

        Assert.assertTrue(PhonCat.isEnabled() && PhonCat.isDisplayed());
        PhonCat.click();
    }
    public static void clickLaptopCategory(WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement LapCat = wait.until(ExpectedConditions.visibilityOfElementLocated(LaptopCat));

        Assert.assertTrue(LapCat.isEnabled() && LapCat.isDisplayed());
        LapCat.click();
    }
    public static void clickMonitorCategory(WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement MonCat = wait.until(ExpectedConditions.visibilityOfElementLocated(MonitorCat));

        Assert.assertTrue(MonCat.isEnabled() && MonCat.isDisplayed());
        MonCat.click();
    }
}
