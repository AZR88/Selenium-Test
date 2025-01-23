package stepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

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


    @When("check Navbar {string} button")
    public void checkNavbarButton(String arg0) {
       WebElement button = CheckHomebutton(driver);
        assertTrue(button.isDisplayed() && button.isEnabled());
    }

    @Then("Check {string} button")
    public void checkButton(String arg1) {
        WebElement button = CheckAboutbutton(driver);
        assertTrue(button.isDisplayed() && button.isEnabled());

    }

    @Then("Check the {string} button")
    public void checkTheButton(String arg0) {
        WebElement button =CheckCartbutton(driver);
        assertTrue(button.isDisplayed() && button.isEnabled());
    }


    @Then("Check a {string} button")
    public void checkAButton(String arg0) {
        WebElement button = CheckLoginbutton(driver);
        assertTrue(button.isDisplayed() && button.isEnabled());
    }

    @Then("check {string} buton")
    public void checkButon(String arg0) {
        WebElement button = CheckSignupbutton(driver);
        assertTrue(button.isDisplayed() && button.isEnabled());
    }

    @Then("Chek {string} button")
    public void chekButton(String arg0) {

        WebElement button = Checkcontactbutton(driver);
        assertTrue(button.isDisplayed() && button.isEnabled());

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

        WebElement button = page.Item.clickPhoneCategory(driver);
        assertTrue(button.isDisplayed() && button.isEnabled());
        button.click();
    }

    @When("user clik Category laptop button")
    public void userClikCategoryLaptopButton() {

        WebElement button = page.Item.clickLaptopCategory(driver);
        assertTrue(button.isDisplayed() && button.isEnabled());
        button.click();
    }

    @When("user clik Category Monitor button")
    public void userClikCategoryMonitorButton() {

        WebElement button = page.Item.clickMonitorCategory(driver);
        assertTrue(button.isDisplayed() && button.isEnabled());
        button.click();
    }


    @Then("click next to show next product where id = {string} and title = {string} and price = {string}")
    public void clickNextToShowNextProductWhereIdAndTitleAndPrice(String arg0, String arg1, String arg2) {
        WebElement nextButton = page.Item.ClickNext(driver);
        nextButton.click();
        boolean isMatch = page.Item.isTitleAndPriceTextEqual(driver, arg0, arg1, arg2);

        assertTrue("Title or Price does not match for product with ID: " + arg0, isMatch);
    }
}
