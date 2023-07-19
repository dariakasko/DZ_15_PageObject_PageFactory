package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BaseClass{
    @FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
    private WebElement productInCartBackpack;
    @FindBy(xpath = "//div[text()='Sauce Labs Bike Light']")
    private WebElement productInCartBikeLight;

    public CartPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean productsInCartAreVisible(){
        return productInCartBackpack.isDisplayed() && productInCartBikeLight.isDisplayed();
    }


}
