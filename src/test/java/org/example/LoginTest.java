package org.example;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;


public class LoginTest {

WebDriver driver;
LoginPage loginPage;
ShoppingPage shoppingPage;
Cartpage cartpage;
CheckoutPage checkoutPage;
ReadExcel readExcel;

    @BeforeMethod

    public void setupall()throws InterruptedException
    {
        driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().window().fullscreen();
        Thread.sleep(5000);
       loginPage = new LoginPage(driver);

       shoppingPage = new ShoppingPage(driver);
       cartpage = new Cartpage(driver);
       checkoutPage = new CheckoutPage(driver);
    }

//    @DataProvider(name = "logincheckoutCredentials")
//    public Object[][] getLoginCheckoutData() {
//        return new Object[][]
//                {
//                        {"standard_user", "secret_sauce","Pooja","Sarak","422101","Sauce Labs Backpack"},
////                        {"locked_out_user", "secret_sauce"},
//                        {"performance_glitch_user", "secret_sauce","Vrushali","Digholkar","422111","Sauce Labs Bike Light"},
////                        {"invalid_user", "wrong_password"}
//
//                };}
    @DataProvider(name = "getExcelData")

    public Object[][] getDatafromExcel() throws IOException {
    return ReadExcel.getTestData("C:\\Users\\Pooja.s\\Desktop\\TestData.xlsx","sheet1");
    }

    @Test(dataProvider = "getExcelData")

   public void UsernamePassCheckout(String UserName, String Pass, String FName, String LName, String PostCode, String Item ) throws InterruptedException {
    //public void UsernamePassCheckout(String UserName, String Pass ) throws InterruptedException {
        loginPage.UsernamePass(UserName, Pass);
        Thread.sleep(5000);
        shoppingPage.SelectItem(Item);
        cartpage.Clickcart();
        cartpage.ChekoutBtn();
        checkoutPage.CheckoutInfo(FName,LName,PostCode);

    }
    @AfterMethod
    public void Quitmethod()
   {
       driver.quit();
   }

}
