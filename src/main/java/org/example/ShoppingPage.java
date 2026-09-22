package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingPage {
    private WebDriver driver;
    Cartpage cartpage;

    public ShoppingPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void SelectItem(String productName)
    {
        System.out.println("Start of SelectItem method");
        String dynamicXpath = String.format(
                "//div[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']",
                productName
        );
        // Find and click the targeted button
        WebElement addToCartButton = driver.findElement(By.xpath(dynamicXpath));
        addToCartButton.click();
        System.out.println("End of SelectItem method");

    }
}
