package stepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page.Cart;
import page.Item;
import page.ProductPage;

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
    public void theProductTitleShouldBe(String title) {
        String text =  ProductPage.checkTitle(driver);
        assertEquals("The tilte is not match, expected ="+title+"",text, title);
    }

    @Then("the product price should be {string}")
    public void theProductPriceShouldBe(String price) {
        String text = ProductPage.checkPrice(driver);
        assertEquals("Price mismatch! Expected: " + price + ", but Actual: " + text, price, text);

    }

    @Then("the product image should be displayed")
    public void theProductImageShouldBeDisplayed() {
        boolean isDisplayed = ProductPage.checkPic(driver);
        assertTrue("picture is not Displayed", isDisplayed);
    }
    @Then("the product description should contain {string}")
    public void theProductDescriptionShouldContain(String productdesc) {
        boolean isDisplayed = ProductPage.isProductDescriptionDisplayed(driver, productdesc);
        assertTrue("Product with desc '" + productdesc + "' Not seen in this page!", isDisplayed);
    }



    @Then("the product {string} should be added to the cart successfully")
    public void theProductShouldBeAddedToTheCartSuccessfully(String title) {
       String text = Cart.checkTitle(driver);
       assertEquals(title,text);
    }


    @Then("the user clicks the Add to cart button")
    public void theUserClicksTheAddToCartButton() {
        boolean button = ProductPage.clickAdd(driver);
       assertTrue("button not displayed",button);
    }


    @Then("Show Alert message {string}")
    public void showAlertMessage(String massage) {
        String text = ProductPage.getAlertText(driver);
        assertEquals(text,massage);
    }
}
