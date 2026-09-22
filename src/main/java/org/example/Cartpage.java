package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cartpage {
    WebDriver driver;
    CheckoutPage checkoutPage;

    public Cartpage(WebDriver driver)
    {
        this.driver = driver;

    }

    public void Clickcart()
    {
        By Cartitem = By.className("shopping_cart_link");
        driver.findElement(Cartitem).click();
    }
    public CheckoutPage ChekoutBtn()
    {
        By Checkoutbtn = By.id("checkout");
        driver.findElement(Checkoutbtn).click();
        return checkoutPage;
    }

}
