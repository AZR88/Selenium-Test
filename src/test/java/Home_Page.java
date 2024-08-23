import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home_Page {

    @BeforeAll
    public static void openweb(){

        WebDriver driver = WebDriverManager.edgedriver().create();
        driver.get("https://www.demoblaze.com/");

    }

    @Test
    public void title(){

        String title = driver.getTitle();
        String currenturl = driver.getCurrentUrl();

        System.out.println("Title pada halaman ini adalah "+ title);
        System.out.println("URL pada saat ini adalah "+ currenturl);
    }

    @Test
    public void Navbar (){

    }


}
