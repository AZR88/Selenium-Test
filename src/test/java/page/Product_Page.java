package page;

import org.openqa.selenium.By;

public class Product_Page {


    public static By ProductPic = By.xpath("");
    public static By AddToCart= By.xpath("");

    public static By ProductPrice = By.xpath("");

    public static By ProductTitle(String productTitle) {
        return By.xpath("//h2[@class='name' and text()='"+productTitle +"']");
    }
    public static By ProductDesc(String productdesc) {
        return By.xpath("//p[contains(text(),'"+ productdesc +"')]");
    }

}
