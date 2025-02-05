package page;

import Helper.WaitElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;



public class Cart {
    public static By cartitem = By.xpath("//tbody[@id='tbodyid']//tr[@class='success']/td[2]");
    public static By deleteItem = By.xpath("//tbody[@id='tbodyid']//tr[@class='success']//a[contains(text(),'Delete')]");
    public static By TotalPrice = By.id("totalp");
    public static By orderButton =  By.xpath("//button[text()='Place Order']");
    public static By purchasebutton = By.xpath("//button[text()='Purchase']");
    public static By allPrice = By.xpath("//tbody[@id='tbodyid']//tr/td[3]");
    public static By confirmPurchase = By.xpath("//div[@class='sa-confirm-button-container']");

    public static boolean order(WebDriver driver){
        try {

            WaitElement.waitForElement(orderButton);

            WebElement order = driver.findElement(orderButton);
            order.click();
            return true;
        }catch (TimeoutException | NoSuchElementException e){
            return false;
        }

    }

    public static boolean confirmation(WebDriver driver){
        try {
            WaitElement.waitForElement(confirmPurchase);

            WebElement confirm = driver.findElement(confirmPurchase);
            confirm.click();
            return true;
        }catch (TimeoutException | NoSuchElementException e){
            return false;
        }

    }

    public static String checkPrice(WebDriver driver){

        WaitElement.waitForElement(allPrice);
        WebElement price = driver.findElement(allPrice);
        String text= price.getText();
        return text;
    }

    public static String checkTitle(WebDriver driver){
        WaitElement.waitForElement(cartitem);
        WebElement title = driver.findElement(cartitem);
        String text = title.getText();
        return text;
    }

    public static boolean delete(WebDriver driver){
        try {

            WaitElement.waitForElement(deleteItem);
            WebElement del = driver.findElement(deleteItem);
            del.click();
            return true;
        }catch (TimeoutException|NoSuchElementException e){
            return false;
        }
    }

    public static boolean purchase (WebDriver driver){
            try {
                WaitElement.waitForElement(purchasebutton);

                WebElement buy = driver.findElement(purchasebutton);
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
        WebElement tp = driver.findElement(TotalPrice);
        String price = tp.getText();
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

    public static int[] calculateTotalPrice(WebDriver driver) {
            WaitElement.waitForElement(allPrice);
            List<WebElement> prices = driver.findElements(allPrice);
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


