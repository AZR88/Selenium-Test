package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.Cart;
import page.Item;
import page.Product_Page;

import java.sql.Driver;

import static Helper.WebHelper.driver;

public class OrderStepdefs {
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


}
