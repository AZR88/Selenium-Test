package JUTest;

import Page.Login_Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class Login_Test {

    @Test
    public void data_test() throws InterruptedException {
        WebDriver driver = WebDriverManager.edgedriver().create();

        // Tentukan username dan password langsung di sini
        String username = "yourUsername";
        String password = "yourPassword";

        // Panggil metode login dari Login_Page
        Login_Page loginPage = new Login_Page();
        loginPage.login(driver, username, password);

        // Tutup browser setelah selesai
        driver.quit();
    }
}
