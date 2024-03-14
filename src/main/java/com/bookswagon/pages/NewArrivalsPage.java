package com.bookswagon.pages;

import com.bookswagon.base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NewArrivalsPage extends BaseClass {
    Actions actions = new Actions(driver);

    @FindBy(xpath = "//div[@id='slider-range']//span[1]")
    WebElement priceSliderLow;

    @FindBy(xpath = "//div[@id='slider-range']//span[2]")
    WebElement priceSliderHigh;

    @FindBy(xpath = "//div[@id='discount-range']//span[1]")
    WebElement discountSliderLow;

    @FindBy(xpath = "//div[@id='discount-range']//span[2]")
    WebElement discountSliderHigh;

    @FindBy(xpath = "//input[@type='checkbox' and @name='chkBinding']")
    List<WebElement> bindingCheckBoxes;

    public NewArrivalsPage(){
        PageFactory.initElements(driver, this);
    }

    public void selectBindingCheckBox(String value) {
        for (WebElement checkbox : bindingCheckBoxes) {
            String checkboxValue = checkbox.getAttribute("value");
            if (checkboxValue.equals(value)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
                break;
            }
        }
    }

    public void selectPriceRange(int percentageLeft, int percentageRight){
        int width = priceSliderLow.getSize().getWidth();
        int xoffset = width*(percentageLeft)/10;
        actions.dragAndDropBy(priceSliderLow, xoffset, 0).build().perform();

        int width1 = priceSliderHigh.getSize().getWidth();
        int xoffset1 = width1*(percentageRight)/10;
        actions.dragAndDropBy(priceSliderHigh, xoffset1, 0).build().perform();
    }

    public void selectDiscountRange(int percentageLeft, int percentageRight){
        int width = discountSliderLow.getSize().getWidth();
        int xoffset = width*(percentageLeft)/10;
        actions.dragAndDropBy(discountSliderLow, xoffset, 0).build().perform();

        int widht1 = discountSliderHigh.getSize().getWidth();
        int xoffset1 = widht1*(percentageRight)/10;
        actions.dragAndDropBy(discountSliderHigh, xoffset1, 0).build().perform();
    }
}