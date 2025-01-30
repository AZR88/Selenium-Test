package stepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import page.Cart;
import page.Item;
import page.Product_Page;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


import static Helper.WebHelper.driver;
public class ProductStepDef {
    @When("the user click the product title {string}")
    public void theUserClickTheProductTitle(String title) {
        boolean select = Item.selectItemByName(driver, title);
        assertTrue("Item not selected",select);
    }

    @Then("the product title should be {string}")
    public void theProductTitleShouldBe(String Title) {
        String Text =  Product_Page.checkTitle(driver);
        assertEquals("The tilte is not match, expected ="+Title+"",Text, Title);
    }

    @Then("the product price should be {string}")
    public void theProductPriceShouldBe(String price) {
        String Text = Product_Page.checkPrice(driver);
        assertEquals("Price mismatch! Expected: " + price + ", but Actual: " + Text, price, Text);

    }

    @Then("the product image should be displayed")
    public void theProductImageShouldBeDisplayed() {
        boolean isDisplayed = Product_Page.checkPic(driver);
        assertTrue("picture is not Displayed", isDisplayed);
    }
    @Then("the product description should contain {string}")
    public void theProductDescriptionShouldContain(String productdesc) {
        boolean isDisplayed = Product_Page.isProductDescriptionDisplayed(driver, productdesc);
        assertTrue("Product with desc '" + productdesc + "' Not seen in this page!", isDisplayed);
    }



    @Then("the product {string} should be added to the cart successfully")
    public void theProductShouldBeAddedToTheCartSuccessfully(String title) {
       String text = Cart.CheckTitle(driver);
       assertEquals(title,text);
    }


    @Then("the user clicks the Add to cart button")
    public void theUserClicksTheAddToCartButton() {
        boolean button = Product_Page.clickAdd(driver);
       assertTrue("button not displayed",button);
    }

    @Then("Show Alert Product Added")
    public void showAlertProductAdded() {
        boolean isAlertPresent = Product_Page.isAlertPresent(driver);
        Assert.assertTrue("No alert detected.", isAlertPresent);
    }
}
