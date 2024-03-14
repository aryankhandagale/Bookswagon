package com.test.bookswagon;

import com.bookswagon.base.BaseClass;
import com.bookswagon.pages.HomePage;
import com.bookswagon.pages.LoginPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {
    public LoginPage loginPage;
    public HomePage homePage;

    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        try {
            initialization();
            loginPage = new LoginPage();
            homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
            homePage.returnHome();
        } catch (WebDriverException e){
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.BLOCKER)
    public void searchBookTest() throws InterruptedException {
        homePage.searchBook(prop.getProperty("bookname"));
    }

    @Test(priority = 2)
    public void newArrivalsTest() throws InterruptedException {
        homePage.newArrivalsClick();
    }

    @Test(priority = 3)
    public void bestSellersTest() throws InterruptedException{
        homePage.bestSellersClick();
    }

    @Test(priority = 4)
    public void featuredAuthors() throws InterruptedException{
        homePage.featuredAuthorsClick();
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
