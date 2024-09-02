import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.Login_Page;

import java.time.Duration;

public class LoginTest {

    public static WebDriver driver;

    @BeforeEach
    public void setUp() {
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

    @Test
    public void testLogin() {
        Login_Page.openLoginPage(driver);
        Login_Page.inputUsername(driver,"Beta123");
        Login_Page.inputPassword(driver, "123");
        Login_Page.clickSubmitButton(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

