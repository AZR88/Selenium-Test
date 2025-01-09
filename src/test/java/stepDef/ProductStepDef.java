package stepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.Cart;
import page.Item;
import page.Product_Page;

import static Helper.WebHelper.driver;
public class ProductStepDef {
    @When("the user click the product title {string}")
    public void theUserClickTheProductTitle(String arg0) {
        Item.selectItemByName(driver, arg0);
    }

    @Then("the product title should be {string}")
    public void theProductTitleShouldBe(String arg0) {
        Product_Page.checkTitle(driver, arg0);
    }

    @Then("the product price should be {string}")
    public void theProductPriceShouldBe(String arg0) {
        Product_Page.checkPrice(driver, arg0);
    }

    @Then("the product image should be displayed")
    public void theProductImageShouldBeDisplayed() {
        Product_Page.checkPic(driver);

    }

    @Then("the product description should contain {string}")
    public void theProductDescriptionShouldContain(String arg0) {
        Product_Page.ProductDesc(driver, arg0);
    }



    @Then("the product {string} should be added to the cart successfully")
    public void theProductShouldBeAddedToTheCartSuccessfully(String arg0) {
        Cart.CheckTitle(driver, arg0);
    }


    @Then("the user clicks the Add to cart button")
    public void theUserClicksTheAddToCartButton() {
        Product_Page.clickAdd(driver);
    }

    @Then("Show Alert Product Added")
    public void showAlertProductAdded() {
        Product_Page.AlertDetect(driver);
    }
}
