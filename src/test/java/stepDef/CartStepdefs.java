package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import page.Cart;
import page.Item;
import page.Product_Page;
import java.util.List;
import java.util.Map;

import static Helper.WebHelper.driver;

public class CartStepdefs {
    @Given("I select the product {string}")
    public void iSelectTheProduct(String arg0) {
        Item.selectItemByName(driver,arg0);

    }

    @When("I check the product image")
    public void iCheckTheProductImage() {
        Product_Page.checkPic(driver);
    }

    @Then("Check The product title and it should be {string}")
    public void checkTheProductTitleAndItShouldBe(String arg0) {
        Product_Page.checkTitle(driver, arg0);
    }

    @Then("Check The price and it should be {string}")
    public void checkThePriceAndItShouldBe(String arg0) {
        Product_Page.checkPrice(driver, arg0);
    }


    @Given("the user has added the item {string} to the cart")
    public void theUserHasAddedTheItemToTheCart(String arg0) {
        Item.selectItemByName(driver, arg0);
        Product_Page.clickAdd(driver);

    }

    @When("Click Cart button")
    public void clickCartButton() {
        Item.ClickCartbutton(driver);
    }

    @Then("user checks the title of the item and it should be {string}")
    public void userChecksTheTitleOfTheItemAndItShouldBe(String arg0) {
        Cart.CheckTitle(driver, arg0);
    }

    @Then("the displayed price should be {string}")
    public void theDisplayedPriceShouldBe(String arg0) {
        Cart.CheckPrice(driver, arg0);
    }

    @When("the user deletes the item from the cart")
    public void theUserDeletesTheItemFromTheCart() {
        Cart.Delete(driver);
    }

    @Then("the item {string} should no longer be displayed in the cart")
    public void theItemShouldNoLongerBeDisplayedInTheCart(String arg0) {
        Cart.theItemShouldNoLongerBeDisplayedInTheCart(driver, arg0);
    }
    @And("total price should be {string}")
    public void totalPriceShouldBe(String arg0) {
    Cart.totalPrice(driver, arg0);
    }


    @Given("the user has added the following items to the cart:")

    public void theUserHasAddedTheFollowingItemsToTheCart(DataTable dataTable) {
        List<Map<String, String>> items = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> item : items) {
            String itemName = item.get("Item Name");
            Item.selectItemByName(driver, itemName);
            Product_Page.clickAdd(driver);

            Item.ClickHomebutton(driver);
        }
    }



    @Then("the total price displayed should match {string}")
    public void theTotalPriceDisplayedShouldMatch(String arg0) {
        Cart.CalculateTotalPrice(driver);
    }


    @Then("the user clicks the {string} button")
    public void theUserClicksTheButton(String arg0) {
        Cart.Order(driver);
    }

    @Then("the user fills in the following order details:")
        public void theUserFillsInTheFollowingOrderDetails(DataTable dataTable) {
            for (Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
                String fieldId = row.get("Field");
                String value = row.get("Value");

                if (value != null && !value.trim().isEmpty()) {
                    Cart.fillField(driver, fieldId, value);
                } else {
                    // Misalnya, jika kosong, kita abaikan atau bisa memberikan peringatan
                    System.out.println("Field " + fieldId + " is left empty, skipping...");
                }
            }
        }

    @And("the user clicks the Purchase")
    public void theUserClicksThePurchase() {
        Cart.purchase(driver);
    }

    @Then("the user click ok button to complete the purchase")
    public void theUserClickOkButtonToCompleteThePurchase() {
        Cart.Confirmation(driver);
    }

    @Then("An alert Should be show up")
    public void anAlertShouldBeShowUp() {

    }
}



