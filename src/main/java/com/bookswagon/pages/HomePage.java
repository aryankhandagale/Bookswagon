package com.bookswagon.pages;

import com.bookswagon.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {
    @FindBy(xpath = "//img[@alt='Up to 60%']")
    WebElement booksWagonLogo;

    @FindBy(xpath = "//input[contains(@id, 'inputbar')]")
    WebElement searchBar;

    @FindBy(xpath = "//input[contains(@name, 'btnTopSearch')]")
    WebElement searchIcon;

    @FindBy(xpath = "//*[@id=\"ctl00_linewrelease\"]/a")
    WebElement newArrivals;

    @FindBy(xpath = "//li[@id='ctl00_libestseller']//a[contains(text(),'Best sellers')]")
    WebElement bestSellers;

    @FindBy(xpath = "//li[@id='ctl00_liRequestBook']//a[normalize-space()='Featured Authors']")
    WebElement featuredAuthors;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void searchBook(String bookName) {
        searchBar.sendKeys(bookName);
        searchIcon.click();
    }

    public void returnHome() throws InterruptedException {
        Thread.sleep(5000);
        booksWagonLogo.click();
    }

    public NewArrivalsPage newArrivalsClick() {
        newArrivals.click();
        return new NewArrivalsPage();
    }

    public BestSellerPage bestSellersClick() {
        bestSellers.click();
        return new BestSellerPage();
    }

    public FeaturedAuthorsPage featuredAuthorsClick() {
        featuredAuthors.click();
        return new FeaturedAuthorsPage();
    }
}
