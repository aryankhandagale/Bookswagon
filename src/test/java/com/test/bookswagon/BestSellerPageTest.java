package com.test.bookswagon;

import com.bookswagon.base.BaseClass;
import com.bookswagon.pages.HomePage;
import com.bookswagon.pages.BestSellerPage;
import com.bookswagon.pages.LoginPage;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BestSellerPageTest extends BaseClass {
    public LoginPage loginPage;
    public HomePage homePage;
    public BestSellerPage bestSellerPage;

    public BestSellerPageTest(){
        super();
    }

    @BeforeMethod
    public void setup() {
        try {
            initialization();
            loginPage = new LoginPage();
            homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
            bestSellerPage = new BestSellerPage();
            bestSellerPage = homePage.bestSellersClick();
        } catch (WebDriverException e){
            e.printStackTrace();
        }
    }

    @Test
    public void priceRangeSliderTest(){
        bestSellerPage.selectPriceRange(20, 50);
    }

    @Test
    public void discountRangeSliderTest(){
        bestSellerPage.selectDiscountRange(10, 40);
    }

    @Test
    public void BindingCheckBoxTest() throws InterruptedException {
        bestSellerPage.selectBindingCheckBox("2");
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
