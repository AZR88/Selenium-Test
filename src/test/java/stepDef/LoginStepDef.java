package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import page.Login_Page;

import static Helper.WebHelper.driver;


public class LoginStepDef {
    @Given("user is on homepage")
    public void userIsOnHomepage() {
        driver.get("https://www.demoblaze.com/");
    }

    @When("user click Login button")
    public void userClickLoginButton() {
        Login_Page.openLoginPage(driver);
    }


    @And("user input username with {string}")
    public void userInputUsernameWith(String arg0) {
        Login_Page.inputUsername(driver,arg0);
    }

    @And("user input password with {string}")
    public void userInputPasswordWith(String arg0) {
        Login_Page.inputPassword(driver,arg0);
    }

    @And("user click submit")
    public void userClickSubmit() throws InterruptedException {
        Thread.sleep(1000);
        Login_Page.clickSubmitButton(driver);
    }

    @Then("user redirect to home page with {string} username displayed")
    public void userRedirectToHomePageWithUsernameDisplayed(String arg0) {
        Login_Page.verifyUserID(driver,arg0);
    }

    @Then("show invalid login notification")
    public void showInvalidLoginNotification() {

            // Berpindah ke alert yang muncul setelah login gagal
            Alert alert = driver.switchTo().alert();

            // Mengambil teks dari alert
            String alertText = alert.getText();
            System.out.println("Teks notifikasi login invalid: " + alertText);

            // Memverifikasi teks alert sesuai yang diharapkan
            if(alertText.equals("User does not exist.")) {
                System.out.println("Notifikasi login invalid tampil dengan benar.");
            } else {
                System.out.println("Notifikasi login invalid tidak sesuai.");
            }

            // Menutup alert dengan menekan "OK"
            alert.accept();


    }
}
