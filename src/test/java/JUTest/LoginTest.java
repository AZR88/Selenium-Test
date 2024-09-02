package JUTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import page.Login_Page;

import java.time.Duration;

public class LoginTest {

        private WebDriver driver;
        private Login_Page loginPage;

        @BeforeEach
        public void setUp() {

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

            driver.manage().window().maximize();
            loginPage = new Login_Page(driver);


            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


            driver.get("https://www.demoblaze.com/");
        }

        @Test
        public void testLogin()  {
            loginPage.openLoginPage();
            loginPage.inputUsername("Beta123");
            loginPage.inputPassword("123");
            loginPage.clickSubmitButton();
        }

        @AfterEach
        public void tearDown() {
            // Quit the browser
            if (driver != null) {
                driver.quit();
            }
        }
    }

