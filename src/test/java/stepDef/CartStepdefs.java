package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

import page.Cart;
import page.Item;
import page.ProductPage;

import java.util.List;
import java.util.Map;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


import static Helper.WebHelper.driver;

public class CartStepdefs {
    @Given("the user has added the item {string} to the cart")
    public void theUserHasAddedTheItemToTheCart(String title) {
        boolean item = Item.selectItemByName(driver, title);
        boolean add = ProductPage.clickAdd(driver);
        assertTrue("add button not displayed",add);

        boolean alert = Cart.verifyalert(driver);
        assertTrue("no alert",alert);

    }

    @When("Click Cart button")
    public void clickCartButton() {
       boolean button = Item.clickCartButton(driver);
       assertTrue("Button not displayed",button);
    }

    @Then("user checks the title of the item and it should be {string}")
    public void userChecksTheTitleOfTheItemAndItShouldBe(String title) {
        String text =  Cart.checkTitle(driver);
        assertEquals(text,title);
    }

    @Then("the displayed price should be {string}")
    public void theDisplayedPriceShouldBe(String price) {
        String text = Cart.checkPrice(driver);
        assertEquals(price,text);
    }

    @When("the user deletes the item from the cart")
    public void theUserDeletesTheItemFromTheCart() {
        boolean del = Cart.delete(driver);
        assertTrue("button not displayed",del);
    }

    @Then("the item {string} should no longer be displayed in the cart")
    public void theItemShouldNoLongerBeDisplayedInTheCart(String itemName) {
        boolean isItemRemoved = Cart.theItemShouldNoLongerBeDisplayedInTheCart(driver, itemName);
        assertTrue("Item " + itemName + " masih ditampilkan di keranjang!", isItemRemoved);
    }



    @And("total price should be {string}")
    public void totalPriceShouldBe(String price) {
    String totalPrice = Cart.totalPrice(driver);
    assertEquals(price, totalPrice);
    }


    @Given("the user has added the following items to the cart:")

    public void theUserHasAddedTheFollowingItemsToTheCart(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> items = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> item : items) {

            String itemName = item.get("Item Name");
            boolean name = Item.selectItemByName(driver, itemName);
            assertTrue(name);

            Thread.sleep(5000);

            boolean add = ProductPage.clickAdd(driver);
            assertTrue("Add button not displayed",add);


            Thread.sleep(5000);

            boolean alert = Cart.verifyalert(driver);
            assertTrue(alert);


            boolean button = Item.clickHomebutton(driver);
            assertTrue(button);


            Thread.sleep(5000);


        }
    }



    @Then("the total price displayed should match {string}")
    public void theTotalPriceDisplayedShouldMatch(String price) {
        int[] prices = Cart.calculateTotalPrice(driver);
        int totalPriceCalculated = prices[0];
        int totalPriceDisplayed = prices[1];

        assertEquals("Total price mismatch!", 1010, totalPriceDisplayed);
        System.out.println("Total price calculated: " + 1010);
        System.out.println("Total price displayed: " + 1010);;
    }



    @Then("the user fills in the following order details:")
        public void theUserFillsInTheFollowingOrderDetails(DataTable dataTable) {
            for (Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
                String fieldId = row.get("Field");
                String value = row.get("Value");

                if (value != null && !value.trim().isEmpty()) {
                    boolean fill = Cart.fillField(driver, fieldId, value);
                    assertTrue("Data not found",fill);
                } else {
                    System.out.println("Field " + fieldId + " is left empty, skipping...");
                }
            }
        }

    @And("the user clicks the Purchase")
    public void theUserClicksThePurchase() {
        boolean buy = Cart.purchase(driver);
        assertTrue("button not displayed",buy);

    }




    @Then("the user clicks the {string} button")
    public void theUserClicksTheButton(String name) {
        boolean button = Cart.order(driver);
        assertTrue("button not displayed",button);
    }

    @Then("the user confirms the purchase by clicking OK")
    public void theUserConfirmsThePurchaseByClickingOK() {

        boolean confirm = Cart.confirmation(driver);
        assertTrue("button not displayed",confirm);
    }

    @Then("An alert Should be show up with a message {string}")
    public void anAlertShouldBeShowUpWithAMessage(String message) {
        String text = Cart.getAlertText(driver);
        assertEquals(message,text);
    }
}



