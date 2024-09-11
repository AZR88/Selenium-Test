package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
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
}
