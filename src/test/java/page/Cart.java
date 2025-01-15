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
    public static By AllPrice = By.xpath("//tbody[@id='tbodyid']//tr/td[3]");
    public static By confirmPurchase = By.xpath("//div[@class='sa-confirm-button-container']");

    public static void Order (WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement order = wait.until(ExpectedConditions.visibilityOfElementLocated(OrderButton));
        Assert.assertTrue(order.isDisplayed() && order.isEnabled());
        order.click();

    }
    public static void Confirmation (WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement confirm = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPurchase));
        Assert.assertTrue(confirm.isDisplayed() && confirm.isEnabled());
        confirm.click();

    }

    public static void CheckPrice(WebDriver driver, String expectedPrice){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(AllPrice));
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

    public static void purchase (WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement buy = wait.until(ExpectedConditions.visibilityOfElementLocated(Purchasebutton));
        Assert.assertTrue(buy.isDisplayed() && buy.isEnabled());
        buy.click();

    }




        public static void fillField(WebDriver driver, String fieldId, String value) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            // Menunggu elemen berdasarkan ID yang diberikan
            WebElement fieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(fieldId)));

            // Validasi apakah elemen dapat diinteraksikan
            Assert.assertTrue("The field " + fieldId + " is not displayed or enabled", fieldElement.isDisplayed() && fieldElement.isEnabled());

            fieldElement.clear();  // Membersihkan jika ada nilai sebelumnya
            fieldElement.sendKeys(value);  // Mengisi nilai ke dalam field
        }



    public  static void totalPrice (WebDriver driver , String price )
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement TP = wait.until(ExpectedConditions.visibilityOfElementLocated(TotalPrice));
        Assert.assertTrue(TP.isDisplayed());
        Assert.assertEquals(price, TP.getText());
    }

    public static void theItemShouldNoLongerBeDisplayedInTheCart(WebDriver driver,String itemName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            By itemLocator = By.xpath("//tbody[@id='tbodyid']//tr[td[2][text()='" + itemName + "']]");
            boolean isItemRemoved = wait.until(ExpectedConditions.invisibilityOfElementLocated(itemLocator));
            Assert.assertTrue("Item " + itemName + " masih ditampilkan di keranjang!", isItemRemoved);
            System.out.println("Item " + itemName + " berhasil dihapus dari keranjang.");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Gagal memverifikasi penghapusan item " + itemName + " dari keranjang: " + e.getMessage());
        }
    }
    public static void CalculateTotalPrice(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        List<WebElement> prices = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AllPrice));
        int totalPriceCalculated = 0;

        for (WebElement priceElement : prices) {
            String priceText = priceElement.getText().trim();
            System.out.println("Price Text: " + priceText);
            if (!priceText.isEmpty()) {
                int price = Integer.parseInt(priceText.replaceAll("[^0-9]", ""));
                totalPriceCalculated += price;
            }
        }
        System.out.println("Total Price Calculated: " + totalPriceCalculated);


        WebElement totalPriceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(TotalPrice));
        String totalPriceText = totalPriceElement.getText().trim();
        int totalPriceDisplayed = Integer.parseInt(totalPriceText.replaceAll("[^0-9]", ""));

        Assert.assertEquals("Total price mismatch!", totalPriceCalculated, totalPriceDisplayed);
        System.out.println("Total price calculated: " + totalPriceCalculated);
        System.out.println("Total price displayed: " + totalPriceDisplayed);
    }




}


