package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Cart {
    public static By cartitem = By.xpath("//tbody[@id='tbodyid']//tr[@class='success']/td[2]");
    public static By DeleteItem = By.xpath("//tbody[@id='tbodyid']//tr[@class='success']//a[contains(text(),'Delete')]");
    public static By TotalPrice = By.id("totalp");
    public static By OrderButton =  By.xpath("//button[text()='Place Order']");
    public static By Purchasebutton = By.xpath("//button[text()='Purchase']");

    public static By cartItemPrice (String ItemName) {
        return By.xpath("//tbody[@id='tbodyid']//tr[td[2][text()='"+ ItemName+"']]/td[3]");
    }

    public static By OrderDetail(String input) {
        return By.id(input);
    }

    public static void CheckPrice(WebDriver driver, String expectedPrice, String Itemname){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(cartItemPrice(Itemname)));
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

    public static void CalculateTotalPrice(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // XPath untuk semua elemen harga di kolom ketiga (Price)
        List<WebElement> prices = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartItemPrice));

        // Variabel untuk menyimpan total harga
        int totalPriceCalculated = 0;

        // Iterasi melalui setiap elemen harga dan jumlahkan
        for (WebElement priceElement : prices) {
            String priceText = priceElement.getText(); // Ambil teks harga
            int price = Integer.parseInt(priceText.replaceAll("[^0-9]", "")); // Hapus karakter non-angka
            totalPriceCalculated += price; // Tambahkan harga ke total
        }

        // Verifikasi dengan elemen total harga di halaman
        WebElement totalPriceElement = driver.findElement(TotalPrice); // Ambil elemen Total Price
        String totalPriceText = totalPriceElement.getText();
        int totalPriceDisplayed = Integer.parseInt(totalPriceText.replaceAll("[^0-9]", ""));

        // Assert bahwa total yang dihitung sama dengan total yang ditampilkan
        Assert.assertEquals(totalPriceCalculated, totalPriceDisplayed);
        System.out.println("Total price calculated: " + totalPriceCalculated);
        System.out.println("Total price displayed: " + totalPriceDisplayed);
    }

}


