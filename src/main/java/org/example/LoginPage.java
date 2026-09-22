package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage {

    private WebDriver driver;
    ShoppingPage ShoppingPage;

    public LoginPage(WebDriver driver)
    {
        System.out.println("LoginPage");
        this.driver = driver;
    }

    public ShoppingPage UsernamePass(String UserName, String Pass)
    {
        System.out.println("@Tet");

        By Username = By.id("user-name");
        driver.findElement(Username).sendKeys(UserName);
        By Password = By.id("password");
        driver.findElement(Password).sendKeys(Pass);
        By Loginbtn = By.name("login-button");
        driver.findElement(Loginbtn).click();
        return ShoppingPage;
    }



}
