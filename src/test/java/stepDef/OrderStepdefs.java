package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import page.Item;
import page.Product_Page;

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
}
