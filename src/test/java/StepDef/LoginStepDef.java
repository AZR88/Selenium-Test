package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.Login_Page;

import java.time.Duration;

import static Helper.WebHelper.driver;


public class LoginStepDef {
    @Given("user is on homepage")
    public void userIsOnHomepage() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
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
    public void userClickSubmit() {
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
