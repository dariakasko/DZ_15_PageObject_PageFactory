package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage extends BaseClass{
    @FindBy(xpath = "//span[text()='Products']")
    private WebElement mainPageName;

    @FindAll({@FindBy(xpath = "//div[text()='Sauce Labs Backpack']"),
            @FindBy(xpath = "//div[text()='Sauce Labs Bike Light']"),
            @FindBy(xpath = "//div[text()='Sauce Labs Bolt T-Shirt']"),
            @FindBy(xpath = "//div[text()='Sauce Labs Fleece Jacket']"),
            @FindBy(xpath = "//div[text()='Sauce Labs Onesie']"),
            @FindBy(xpath = "//div[text()='Test.allTheThings() T-Shirt (Red)']")})
    private List<WebElement> listOfProducts;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean nameOfMainPageIsVisible(){
        return mainPageName.isDisplayed();
    }
    public boolean listOfProductsIsVisible(){
        for (WebElement product: listOfProducts) {
            if (!product.isDisplayed()) {
                return false;
            }
        }
        return true;
    }


}
