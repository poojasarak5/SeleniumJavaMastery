package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void CheckoutInfo(String Firstname, String Lastname, String PostalCode) throws InterruptedException {
        By firstname = By.name("firstName");
        driver.findElement(firstname).clear();
        driver.findElement(firstname).sendKeys(Firstname);
        By lastname = By.id("last-name");
        driver.findElement(lastname).clear();
        driver.findElement(lastname).sendKeys(Lastname);
        By postal = By.id("postal-code");
        driver.findElement(lastname).clear();
        driver.findElement(postal).sendKeys(PostalCode);
        Thread.sleep(10000);
        By clickContinue = By.id("continue");
        driver.findElement(clickContinue).click();

    }
}
