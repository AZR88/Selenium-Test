package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Cart {
    public static By cartitem = By.xpath("//tbody[@id='tbodyid']//tr[@class='success']/td[2]");
    public static By cartItemPrice = By.xpath("//tbody[@id='tbodyid']/tr[1]/td[3]");
    public static By DeleteItem = By.xpath("//tbody[@id='tbodyid']//tr[@class='success']//a[contains(text(),'Delete')]");
    public static By TotalPrice = By.id("totalp");
    public static By OrderButton =  By.xpath("//button[text()='Place Order']");
    public static By Purchasebutton = By.xpath("//button[text()='Purchase']");
    public static By OrderDetail(String input) {
        return By.id(input);
    }

    public static void CheckPrice(WebDriver driver, String expectedPrice){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(cartItemPrice));
        Assert.assertTrue(price.isDisplayed());

        Assert.assertEquals(expectedPrice, price.getText());

    }
    public static void CheckTitle(WebDriver driver, String expectedTitle){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement Title = wait.until(ExpectedConditions.visibilityOfElementLocated(cartitem));
        Assert.assertTrue(Title.isDisplayed());
        Assert.assertEquals(expectedTitle, Title.getText());

    }
    public static void Delete (WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement del = wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteItem));
        Assert.assertTrue(del.isDisplayed() && del.isEnabled());
        del.click();

    }
}


