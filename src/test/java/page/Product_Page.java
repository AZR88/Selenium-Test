package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Product_Page {


    public static By ProductPic = By.xpath("//div[@id='imgp']//img]");
    public static By ProductTitle = By.xpath("//h2[@class='name'");
    public static By ProductPrice = By.xpath("//h3[@class='price-container']");
    public static By AddToCart= By.xpath("//a[@class='btn btn-success btn-lg' and text()='Add to cart']");

    public static By ProductDesc(String productdesc) {
        return By.xpath("//p[contains(text(),'"+ productdesc +"')]");
    }

    public static void checkTitle(WebDriver driver, String Title) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ItemTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//your/xpath/here")));

        Assert.assertTrue(ItemTitle.isEnabled());
        Assert.assertEquals(Title, ItemTitle.getText());
    }

}
