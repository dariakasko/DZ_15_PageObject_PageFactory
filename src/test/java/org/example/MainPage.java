package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Waiters;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainPage extends BaseClass{
    @FindBy(xpath = "//span[text()='Products']")
    private WebElement mainPageName;

    @FindBy(css="#react-burger-menu-btn")
    private WebElement menuButton;


    @FindBy(css = ".shopping_cart_link")
    private WebElement cartButton;


    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private List<WebElement> productsList;


    public MainPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean nameOfMainPageIsVisible(){
        return mainPageName.isDisplayed();
    }


    public String getProductName(int idOfProduct) {
        return new ProductComponent(productsList.get(idOfProduct)).getProductName();
    }

    public int getProductPrice(int idOfProduct) {
        return new ProductComponent(productsList.get(idOfProduct)).getProductPrice();
    }

    private boolean productNameIsVisible(int idOfProduct) {
        return new ProductComponent(productsList.get(idOfProduct)).productNameIsVisible();
    }
    public boolean productsNamesAreVisible() {
        for (int i = 0; i < productsList.size(); i++) {
            if (!productNameIsVisible(i))
                return false;
        }
        return true;
    }
    public List<WebElement> sortListByPrice() {
        List<WebElement> sortedListOfProducts = productsList.stream()
                .sorted(Comparator.comparing(MainPage::getProductPrice))
                .collect(Collectors.toList());
    }
    private void addProductToCart(int idOfAddButton) {
        new ProductComponent(productsList.get(idOfAddButton)).addProductToCart();
    }
    public MainPage addSomeProductsToCart() {
        addProductToCart(0);
        addProductToCart(1);
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
