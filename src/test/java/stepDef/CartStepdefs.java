package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.Cart;
import page.Item;
import page.Product_Page;

import java.time.Duration;
import java.util.List;
import java.util.Map;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


import static Helper.WebHelper.driver;

public class CartStepdefs {
    @Given("the user has added the item {string} to the cart")
    public void theUserHasAddedTheItemToTheCart(String arg0) {
        WebElement item = Item.selectItemByName(driver, arg0);
        item.click();
        WebElement add = Product_Page.clickAdd(driver);
        add.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertTrue("No alert detected.", alert != null);
        alert.accept();

    }

    @When("Click Cart button")
    public void clickCartButton() {
       WebElement button = Item.ClickCartbutton(driver);
       assertTrue(button.isDisplayed()&& button.isEnabled());
       button.click();
    }

    @Then("user checks the title of the item and it should be {string}")
    public void userChecksTheTitleOfTheItemAndItShouldBe(String arg0) {
        WebElement title =  Cart.CheckTitle(driver);
        String data = title.getText();
        assertTrue(title.isDisplayed());
        assertEquals(arg0,data);
    }

    @Then("the displayed price should be {string}")
    public void theDisplayedPriceShouldBe(String arg0) {
        WebElement price = Cart.CheckPrice(driver);
        String pr = price.getText();
        assertTrue(price.isDisplayed());
        assertEquals(arg0,pr);
    }

    @When("the user deletes the item from the cart")
    public void theUserDeletesTheItemFromTheCart() {
        WebElement del = Cart.Delete(driver);
        assertTrue(del.isDisplayed() && del.isEnabled());
        del.click();
    }

    @Then("the item {string} should no longer be displayed in the cart")
    public void theItemShouldNoLongerBeDisplayedInTheCart(String itemName) {
        boolean isItemRemoved = Cart.theItemShouldNoLongerBeDisplayedInTheCart(driver, itemName);
        assertTrue("Item " + itemName + " masih ditampilkan di keranjang!", isItemRemoved);
    }



    @And("total price should be {string}")
    public void totalPriceShouldBe(String arg0) {
    WebElement Totalprice = Cart.totalPrice(driver);
    String price = Totalprice.getText();
    assertEquals(arg0,price);
    }


    @Given("the user has added the following items to the cart:")

    public void theUserHasAddedTheFollowingItemsToTheCart(DataTable dataTable) {
        List<Map<String, String>> items = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> item : items) {

            String itemName = item.get("Item Name");
            WebElement name = Item.selectItemByName(driver, itemName);
            assertTrue(name.isDisplayed() && name.isEnabled());
            name.click();

            WebElement add = Product_Page.clickAdd(driver);
            assertTrue(add.isDisplayed() && add.isEnabled());
            add.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            assertTrue("No alert detected.", alert != null);
            alert.accept();

            WebElement button = Item.ClickHomebutton(driver);
            assertTrue(button.isDisplayed() && button.isEnabled());
            button.click();
        }
    }



    @Then("the total price displayed should match {string}")
    public void theTotalPriceDisplayedShouldMatch(String arg0) {
        int[] prices = Cart.CalculateTotalPrice(driver);
        int totalPriceCalculated = prices[0];
        int totalPriceDisplayed = prices[1];

        assertEquals("Total price mismatch!", totalPriceCalculated, totalPriceDisplayed);
        System.out.println("Total price calculated: " + totalPriceCalculated);
        System.out.println("Total price displayed: " + totalPriceDisplayed);;
    }



    @Then("the user fills in the following order details:")
        public void theUserFillsInTheFollowingOrderDetails(DataTable dataTable) {
            for (Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
                String fieldId = row.get("Field");
                String value = row.get("Value");

                if (value != null && !value.trim().isEmpty()) {
                    WebElement fill = Cart.fillField(driver, fieldId);

                    assertTrue("The field " + fieldId + " is not displayed or enabled", fill.isDisplayed() && fill.isEnabled());
                    fill.clear();
                    fill.sendKeys(value);
                } else {
                    System.out.println("Field " + fieldId + " is left empty, skipping...");
                }
            }
        }

    @And("the user clicks the Purchase")
    public void theUserClicksThePurchase() {
        WebElement buy = Cart.purchase(driver);
        assertTrue(buy.isDisplayed() & buy.isEnabled());
        buy.click();
    }

    @Then("the user click ok button to complete the purchase")
    public void theUserClickOkButtonToCompleteThePurchase() {
        WebElement confirm = Cart.Confirmation(driver);
        assertTrue(confirm.isDisplayed() && confirm.isEnabled());
        confirm.click();
    }

    @Then("An alert Should be show up")
    public void anAlertShouldBeShowUp() {
        boolean isAlertPresent = Product_Page.isAlertPresent(driver);
        assertTrue("No alert detected.", isAlertPresent);
    }

    @Then("the user clicks the {string} button")
    public void theUserClicksTheButton(String arg0) {
        WebElement button = Cart.Order(driver);
        assertTrue(button.isDisplayed()&& button.isEnabled());
        button.click();
    }
}



