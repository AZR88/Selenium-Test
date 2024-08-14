import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Ui_Test {
    @Test
    public void UI(){
        WebDriver driver = WebDriverManager.edgedriver().create();
        driver.get("https://www.demoblaze.com/");

        //driver.findElement(By.cssSelector("input#loginusername.form-control"));
        //driver.findElement(By.xpath("//*[@id=\"loginpassword\"]"));
        driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]"));

    }
}
