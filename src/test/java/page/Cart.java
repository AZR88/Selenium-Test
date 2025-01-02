package page;

import org.openqa.selenium.By;

public class Cart {
    public static By cartitem = By.xpath("//tbody[@id='tbodyid']//tr[@class='success']/td[2]");
    public static By cartItemPrice = By.xpath("//tbody[@id='tbodyid']/tr[1]/td[3]");
    public static By DeleteItem = By.xpath("//tbody[@id='tbodyid']//tr[@class='success']//a[contains(text(),'Delete')]");
    public static By TotalPrice = By.id("totalp");

}


