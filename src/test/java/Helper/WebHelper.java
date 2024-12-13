package Helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class WebHelper {

    public static WebDriver driver;

    public static void startDriver(String browser) {
        try {
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless");
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--disable-dev-shm-usage");
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    chromeOptions.addArguments("--window-size=1920,1080");
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.addArguments("--disable-infobars");
                    chromeOptions.addArguments("--disable-extensions");
                    chromeOptions.setExperimentalOption("useAutomationExtension", false); // Untuk mencegah deteksi otomatis
                    driver = new ChromeDriver(chromeOptions);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--no-sandbox");
                    firefoxOptions.addArguments("--disable-dev-shm-usage");
                    firefoxOptions.addArguments("--disable-gpu"); // Tambahan untuk stabilitas
                    firefoxOptions.addArguments("--window-size=1920,1080");
                    firefoxOptions.addArguments("--headless");
                    driver = new FirefoxDriver(firefoxOptions);
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--no-sandbox");
                    edgeOptions.addArguments("--disable-dev-shm-usage");
                    edgeOptions.addArguments("--remote-allow-origins=*");
                    edgeOptions.addArguments("--window-size=1920,1080");
                    driver = new EdgeDriver(edgeOptions);
                    break;

                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

            if (driver == null) {
                throw new IllegalStateException("WebDriver initialization failed for browser: " + browser);
            }

            // Set konfigurasi umum untuk WebDriver
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get("https://www.demoblaze.com/");
        } catch (Exception e) {
            throw new RuntimeException("Error initializing WebDriver for browser: " + browser, e);
        }
    }


    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
