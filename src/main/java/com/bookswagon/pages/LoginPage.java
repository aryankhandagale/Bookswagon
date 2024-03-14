package com.bookswagon.pages;

import com.bookswagon.base.BaseClass;
import com.bookswagon.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
    @FindBy(name = "ctl00$phBody$SignIn$txtEmail")
    WebElement username;

    @FindBy(name = "ctl00$phBody$SignIn$txtPassword")
    WebElement password;

    @FindBy(id = "ctl00_phBody_SignIn_btnLogin")
    WebElement loginBtn;

    @FindBy(id = "ctl00_imglogo")
    WebElement bwLogo;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean validateLogo() {
        return bwLogo.isDisplayed();
    }

    public HomePage login(String un, String pwd) {
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();

        return new HomePage();
    }

    public HomePage SignInMultiple() throws InterruptedException {
        Object[][] testData = TestUtil.getTestData("Sheet1");
        String usernameInput = testData[1][0].toString().replace("@","");
        String passwordInput = testData[0][1].toString();
        username.sendKeys(usernameInput);
        password.sendKeys(passwordInput);
        loginBtn.click();

        return new HomePage();
    }
}
