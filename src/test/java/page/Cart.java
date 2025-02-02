package page;

import Helper.WaitElement;
import org.openqa.selenium.*;
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

    public static boolean Order (WebDriver driver){
        try {

            WaitElement.waitForElement(OrderButton);

            WebElement order = driver.findElement(OrderButton);
            order.click();
            return true;
        }catch (TimeoutException | NoSuchElementException e){
            return false;
        }

    }

    public static boolean Confirmation (WebDriver driver){
        try {
            WaitElement.waitForElement(confirmPurchase);

            WebElement confirm = driver.findElement(confirmPurchase);
            confirm.click();
            return true;
        }catch (TimeoutException | NoSuchElementException e){
            return false;
        }

    }

    public static String CheckPrice(WebDriver driver){

        WaitElement.waitForElement(AllPrice);
        WebElement price = driver.findElement(AllPrice);
        String text= price.getText();
        return text;
    }

    public static String CheckTitle(WebDriver driver){
        WaitElement.waitForElement(cartitem);
        WebElement Title = driver.findElement(cartitem);
        String text = Title.getText();
        return text;
    }

    public static boolean Delete (WebDriver driver){
        try {

            WaitElement.waitForElement(DeleteItem);
            WebElement del = driver.findElement(DeleteItem);
            del.click();
            return true;
        }catch (TimeoutException|NoSuchElementException e){
            return false;
        }
    }

    public static boolean purchase (WebDriver driver){
            try {
                WaitElement.waitForElement(Purchasebutton);

                WebElement buy = driver.findElement(Purchasebutton);
                buy.click();
                return true;
            } catch (TimeoutException| NoSuchElementException e){
                return false;
            }
    }


    public static boolean fillField(WebDriver driver, String fieldId, String fieldValue) {
        try {
            WaitElement.waitForElement(By.id(fieldId));
            WebElement fieldElement = driver.findElement(By.id(fieldId));
            fieldElement.clear();
            fieldElement.sendKeys(fieldValue);
            return true;
        } catch (TimeoutException| NoSuchElementException e){
            return false;
        }}




    public  static String  totalPrice (WebDriver driver)
    {

        WaitElement.waitForElement(TotalPrice);
        WebElement TP = driver.findElement(TotalPrice);
        String price = TP.getText();
        return price;
    }

    public static boolean theItemShouldNoLongerBeDisplayedInTheCart(WebDriver driver, String itemName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            By itemLocator = By.xpath("//tbody[@id='tbodyid']//tr[td[2][text()='" + itemName + "']]");
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(itemLocator));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int[] CalculateTotalPrice(WebDriver driver) {
            WaitElement.waitForElement(AllPrice);
            List<WebElement> prices = driver.findElements(AllPrice);
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

            WebElement totalPriceElement = driver.findElement(TotalPrice);
            String totalPriceText = totalPriceElement.getText().trim();
            int totalPriceDisplayed = Integer.parseInt(totalPriceText.replaceAll("[^0-9]", ""));

            return new int[] { totalPriceCalculated, totalPriceDisplayed };
        }

        public static boolean verifyalert (WebDriver driver) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
                alert.accept();
                return true;
            } catch (TimeoutException e) {
                System.out.println("No alert detected within the timeout.");
                return false;
            }
        }
}


