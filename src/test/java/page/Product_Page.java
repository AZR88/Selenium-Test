package page;

import org.openqa.selenium.By;

public class Product_Page {


    public static By ProductTitle = By.xpath("//h2[@class='name'");
    public static By ProductPrice = By.xpath("//h3[@class='price-container']");
    public static By ProductPic = By.xpath("//div[@id='imgp']//img]");
    public static By AddToCart= By.xpath("//a[@class='btn btn-success btn-lg' and text()='Add to cart']");

    public static By ProductDesc(String productdesc) {
        return By.xpath("//p[contains(text(),'"+ productdesc +"')]");
    }

}
