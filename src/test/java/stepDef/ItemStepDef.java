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
import static page.Item.CheckHomebutton;

import static org.junit.Assert.assertEquals;

public class ItemStepDef {

    @Given("user is on homepage")
    public void userIsOnHomepage() {
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + actualUrl);
        assertEquals("User is not on the expected homepage!", "https://www.demoblaze.com/", actualUrl);

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

            assertTrue("Title atau Price tidak sesuai untuk produk dengan ID " + productId, isTitleAndPriceCorrect);
        }
    }



    @Then("check multiple titles and ids on next page")
    public void checkMultipleTitlesAndIdsOnNextPage(DataTable dataTable) {
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


            assertTrue("Title atau Price tidak sesuai untuk produk dengan ID " + productId, isTitleAndPriceCorrect);
        }
    }

    @When("user clik Category phone button")
    public void userClikCategoryPhoneButton() {

        boolean button = page.Item.clickPhoneCategory(driver);
        assertTrue("Button not displayed",button);
    }

    @When("user clik Category laptop button")
    public void userClikCategoryLaptopButton() {

        boolean button = page.Item.clickLaptopCategory(driver);
        assertTrue("Button not displayed",button);
    }

    @When("user clik Category Monitor button")
    public void userClikCategoryMonitorButton() {
        boolean button = page.Item.clickMonitorCategory(driver);
        assertTrue("Button not displayed",button);
    }


    @Then("click next to show next product where id = {string} and title = {string} and price = {string}")
    public void clickNextToShowNextProductWhereIdAndTitleAndPrice(String id, String title, String price) {
        boolean nextButton = page.Item.ClickNext(driver);
        boolean isMatch = page.Item.isTitleAndPriceTextEqual(driver, id, title, price);

        assertTrue("button not displayed",nextButton);
        assertTrue("Title or Price does not match for product with ID: " + id, isMatch);
    }

    @When("check Navbar {string} button")
    public void checkNavbarButton(String arg0) {
        boolean isDisplayed = CheckHomebutton(driver);
        assertTrue("button Not seen in this page!", isDisplayed);
    }
    @Then("Check About us")
    public void checkAboutUs() {
        boolean isDisplayed = CheckAboutbutton(driver);
        assertTrue("button Not seen in this page!", isDisplayed);
    }

    @Then("Check Contact")
    public void checkContact() {
        boolean isDisplayed = Checkcontactbutton(driver);
        assertTrue("button Not seen in this page!", isDisplayed);

    }

    @Then("Check Cart")
    public void checkCart() {
        boolean isDisplayed = CheckCartbutton(driver);
        assertTrue("button Not seen in this page!", isDisplayed);

    }

    @Then("Check Log in")
    public void checkLogIn() {
        boolean isDisplayed = CheckLoginbutton(driver);
        assertTrue("button Not seen in this page!", isDisplayed);
    }

    @Then("check Sign up")
    public void checkSignUp() {
        boolean isDisplayed = CheckSignupbutton(driver);
        assertTrue("button Not seen in this page!", isDisplayed);
    }
}
