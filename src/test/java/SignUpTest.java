import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.SignUp_Page;

import java.time.Duration;

public class SignUpTest {

    public static WebDriver driver;

    @BeforeEach
    public void setDriver(){
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

    public void TestSignup(){
        SignUp_Page.openSignupPage(driver);
        SignUp_Page.SignUpusernameInput(driver, "ssssss");
    }
}
