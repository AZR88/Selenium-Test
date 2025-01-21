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

    public static WebElement Order (WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement order = wait.until(ExpectedConditions.visibilityOfElementLocated(OrderButton));
        return order;
    }

    public static WebElement Confirmation (WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement confirm = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPurchase));
        return confirm;
    }

    public static WebElement CheckPrice(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(AllPrice));
        return price;
    }

    public static WebElement CheckTitle(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement Title = wait.until(ExpectedConditions.visibilityOfElementLocated(cartitem));
        return Title;
    }

    public static WebElement Delete (WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement del = wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteItem));
        return del;
    }

    public static WebElement purchase (WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement buy = wait.until(ExpectedConditions.visibilityOfElementLocated(Purchasebutton));
        return buy;
    }


        public static WebElement fillField(WebDriver driver, String fieldId) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement fieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(fieldId)));
            return  fieldElement;
        }



    public  static WebElement totalPrice (WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement TP = wait.until(ExpectedConditions.visibilityOfElementLocated(TotalPrice));
        return TP;
    }

    public static boolean theItemShouldNoLongerBeDisplayedInTheCart(WebDriver driver, String itemName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            By itemLocator = By.xpath("//tbody[@id='tbodyid']//tr[td[2][text()='" + itemName + "']]");
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(itemLocator));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int[] CalculateTotalPrice(WebDriver driver) {
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

            return new int[] { totalPriceCalculated, totalPriceDisplayed };
        }





    }


