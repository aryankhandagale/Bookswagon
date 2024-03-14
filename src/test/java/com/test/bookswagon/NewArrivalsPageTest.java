package com.test.bookswagon;

import com.bookswagon.base.BaseClass;
import com.bookswagon.pages.HomePage;
import com.bookswagon.pages.NewArrivalsPage;
import com.bookswagon.pages.LoginPage;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class NewArrivalsPageTest extends BaseClass {
    public LoginPage loginPage;
    public HomePage homePage;
    public NewArrivalsPage newArrivalsPage;

    public NewArrivalsPageTest(){
        super();
    }

    @BeforeMethod
    public void setup() {
        try {
            initialization();
            loginPage = new LoginPage();
            homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
            newArrivalsPage = new NewArrivalsPage();
            newArrivalsPage = homePage.newArrivalsClick();
            driver.navigate().refresh();
        } catch (WebDriverException e){
            e.printStackTrace();
        }
    }

    @Test
    public void priceRangeSliderTest(){
        newArrivalsPage.selectPriceRange(50, 10);
    }

    @Test
    public void discountRangeSliderTest(){
        newArrivalsPage.selectDiscountRange(50, 10);
    }

    @Test
    public void BindingCheckBoxTest() throws InterruptedException {
        newArrivalsPage.selectBindingCheckBox("1");
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
