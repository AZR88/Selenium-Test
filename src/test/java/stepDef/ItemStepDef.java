package stepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static Helper.WebHelper.driver;
import static org.junit.Assert.assertTrue;
import static page.Item.*;

public class ItemStepDef {

    @Given("user is on homepage")
    public void userIsOnHomepage() {
        page.Item.UrlCheck(driver,"https://www.demoblaze.com/");
    }


    @When("check Navbar {string} button")
    public void checkNavbarButton(String arg0) {
        CheckHomebutton(driver,arg0);
    }
    @Then("Check {string} button")
    public void checkButton(String arg1) {
        CheckAboutbutton(driver,arg1);

    }

    @Then("Check the {string} button")
    public void checkTheButton(String arg0) {
        CheckCartbutton(driver,arg0);
    }


    @Then("Check a {string} button")
    public void checkAButton(String arg0) {
        CheckLoginbutton(driver,arg0);
    }

    @Then("check {string} buton")
    public void checkButon(String arg0) {
        CheckSignupbutton(driver,arg0);
    }

    @Then("Chek {string} button")
    public void chekButton(String arg0) {
        Checkcontactbutton(driver,arg0);
    }

    @When("check multiple titles and ids")
    public void checkMultipleTitlesAndIds(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : data) {
            String productId = row.get("id");
            String expectedTitle = row.get("title");
            String expectedPrice = row.get("price");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean isTitleAndPriceCorrect = page.Item.isTitleAndPriceTextEqual(driver, productId, expectedTitle, expectedPrice);


            System.out.println("ID Produk: " + productId);
            System.out.println("Expected Title: " + expectedTitle);
            System.out.println("Expected Price: " + expectedPrice);
            System.out.println("Actual Title and Price: " + (isTitleAndPriceCorrect ? "Sesuai" : "Tidak Sesuai"));

            assertTrue("Title atau Price tidak sesuai untuk produk dengan ID " + productId, isTitleAndPriceCorrect);
        }
    }

    @Then("click next to show next product where id = {string} and title = {string}")
    public void clickNextToShowNextProductWhereTitleAndPrice(String arg0, String arg1) throws InterruptedException {
        page.Item.ClickNext(driver, arg0, arg1);
    }

}
