package com.test.bookswagon;

import com.bookswagon.base.BaseClass;
import com.bookswagon.pages.HomePage;
import com.bookswagon.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(com.test.Listener.Listener.class)
public class LoginPageTest extends BaseClass {
    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
    }

    @Test (priority = 1)
    public void loginPageTitleTest() {
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com");
    }

    @Test (priority = 2)
    public void logoTest() {
        boolean logo = loginPage.validateLogo();
        Assert.assertTrue(logo);
    }

    @Test (priority = 3)
    public void loginTest() {
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

    }

    @Test (priority = 4)
    public void SignInMultipleTest() throws InterruptedException{
        loginPage.SignInMultiple();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
