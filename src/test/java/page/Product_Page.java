package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Product_Page {

    public static By ProductPic = By.xpath("//div[@id='imgp']//img");
    public static By ProductTitle = By.xpath("//h2[@class='name']");
    public static By ProductPrice = By.xpath("//div[@id='tbodyid']/h3[@class='price-container']");
    public static By AddToCart= By.xpath("//a[@class='btn btn-success btn-lg' and text()='Add to cart']");

    public static By ProductDesc(String productdesc) {
        return By.xpath("//p[contains(text(),'"+ productdesc +"')]");
    }

    public static void checkTitle(WebDriver driver, String Title) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ItemTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(ProductTitle));

        Assert.assertTrue(ItemTitle.isDisplayed());
        Assert.assertEquals(Title, ItemTitle.getText());
    }

    public static void checkPrice(WebDriver driver, String expectedPrice) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement itemPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPrice));

        // Ambil teks penuh dari elemen
        String fullText = itemPrice.getText();

        // Ambil hanya bagian harga dari teks penuh
        String actualPrice = fullText.split("\n")[0].replaceAll("[^\\d$.]", "").trim();

        // Validasi bahwa elemen terlihat di halaman
        Assert.assertTrue(itemPrice.isDisplayed());

        // Validasi kesesuaian harga
        Assert.assertEquals("Price mismatch! Expected: " + expectedPrice + ", but Actual: " + actualPrice, expectedPrice, actualPrice);
    }



    public static void checkPic(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ItemPic = wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPic));

        Assert.assertTrue(ItemPic.isDisplayed());
    }

    public static void clickAdd (WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Add = wait.until(ExpectedConditions.visibilityOfElementLocated(AddToCart));

        Assert.assertTrue(Add.isDisplayed() && Add.isDisplayed());
        Add.click();
    }
}
