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
    public void theUserClickTheProductTitle(String arg0) {
        WebElement select = Item.selectItemByName(driver, arg0);
        assertTrue("Item selected",select.isEnabled() && select.isDisplayed());
        select.click();
    }

    @Then("the product title should be {string}")
    public void theProductTitleShouldBe(String arg0) {
        WebElement title =  Product_Page.checkTitle(driver);
        String text = title.getText();
        assertTrue(title.isDisplayed());
        assertEquals(arg0, text);
    }

    @Then("the product price should be {string}")
    public void theProductPriceShouldBe(String arg0) {
        WebElement price = Product_Page.checkPrice(driver);

        String fullText = price.getText();
        String actualPrice = fullText.split("\n")[0].replaceAll("[^\\d$.]", "").trim();

        assertTrue(price.isDisplayed());
        assertEquals("Price mismatch! Expected: " + arg0 + ", but Actual: " + actualPrice, arg0, actualPrice);

    }

    @Then("the product image should be displayed")
    public void theProductImageShouldBeDisplayed() {
       WebElement pic = Product_Page.checkPic(driver);
       assertTrue(pic.isDisplayed());
    }
    @Then("the product description should contain {string}")
    public void theProductDescriptionShouldContain(String arg0) {
        WebElement desc = Product_Page.ProductDesc(driver, arg0);

        assertTrue("Product description is not displayed.", desc.isDisplayed());
        String descText = desc.getText();
        System.out.println("Product Description: " + descText);
        assertTrue("Product description does not contain the expected text.", descText.contains(arg0));
    }



    @Then("the product {string} should be added to the cart successfully")
    public void theProductShouldBeAddedToTheCartSuccessfully(String arg0) {
       WebElement title = Cart.CheckTitle(driver);
       String text = title.getText();
       assertTrue(title.isDisplayed());
       assertEquals(arg0,text);
    }


    @Then("the user clicks the Add to cart button")
    public void theUserClicksTheAddToCartButton() {
        WebElement button = Product_Page.clickAdd(driver);
        assertTrue(button.isDisplayed()&& button.isEnabled());
        button.click();
    }

    @Then("Show Alert Product Added")
    public void showAlertProductAdded() {
        boolean isAlertPresent = Product_Page.isAlertPresent(driver);
        Assert.assertTrue("No alert detected.", isAlertPresent);
    }
}
