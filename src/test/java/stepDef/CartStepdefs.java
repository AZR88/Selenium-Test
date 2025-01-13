package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.Cart;
import page.Item;
import page.Product_Page;

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
}
