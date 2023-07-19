package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Waiters;

import java.util.List;

public class MainPage extends BaseClass{
    @FindBy(xpath = "//span[text()='Products']")
    private WebElement mainPageName;

    @FindBy(css="#react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(css="#add-to-cart-sauce-labs-backpack")
    private WebElement addToCartButtonBackpack;

    @FindBy(css="#add-to-cart-sauce-labs-bike-light")
    private WebElement addToCartButtonBikeLight;

    @FindBy(css = ".shopping_cart_link")
    private WebElement cartButton;

    @FindAll({@FindBy(xpath = "//div[text()='Sauce Labs Backpack']"),
            @FindBy(xpath = "//div[text()='Sauce Labs Bike Light']"),
            @FindBy(xpath = "//div[text()='Sauce Labs Bolt T-Shirt']"),
            @FindBy(xpath = "//div[text()='Sauce Labs Fleece Jacket']"),
            @FindBy(xpath = "//div[text()='Sauce Labs Onesie']"),
            @FindBy(xpath = "//div[text()='Test.allTheThings() T-Shirt (Red)']")})
    private List<WebElement> listOfProducts;

    @FindAll({@FindBy(xpath = "//div[text()='Sauce Labs Backpack']"),
            @FindBy(xpath = "//div[text()='Sauce Labs Bike Light']"),
            @FindBy(xpath = "//div[text()='Sauce Labs Bolt T-Shirt']"),
            @FindBy(xpath = "//div[text()='Sauce Labs Fleece Jacket']"),
            @FindBy(xpath = "//div[text()='Sauce Labs Onesie']"),
            @FindBy(xpath = "//div[text()='Test.allTheThings() T-Shirt (Red)']")})
    private List<WebElement> listOfPrices;


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
    
    public MainPage addProductsToCart() {
        addToCartButtonBackpack.click();
        addToCartButtonBikeLight.click();
        return this;
    }

    public CartPage openCartWithAddedProducts(WebDriver webDriver) {
        cartButton.click();
        return new CartPage(webDriver);
    }

    public LoginPage logout(WebDriver webDriver){
        menuButton.click();
        WebElement logoutButton = Waiters.useExplicitWaiter(webDriver, By.cssSelector("#logout_sidebar_link"));
        logoutButton.click();
        return new LoginPage(webDriver);
    }


}
