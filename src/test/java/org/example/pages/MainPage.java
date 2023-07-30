package org.example.pages;

import org.example.BaseClass;
import org.example.components.ProductComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Waiters;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainPage extends BaseClass {
    @FindBy(xpath = "//span[text()='Products']")
    private WebElement mainPageName;

    @FindBy(css="#react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(css = ".shopping_cart_link")
    private WebElement cartButton;


    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<WebElement> productsList;

    @FindBy(xpath="//select[@class='product_sort_container']")
    private WebElement sortMenuButton;

    private List<WebElement> sortedListOfProducts;


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

    public double getProductPrice(int idOfProduct, List<WebElement> list) {
        return new ProductComponent(list.get(idOfProduct)).getProductPrice();
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
    /*
    public MainPage sortListByPrice() {
        sortedListOfProducts = productsList.stream().sorted(new Comparator<WebElement>() {
            @Override
            public int compare(WebElement webEl1, WebElement webEl2) {
                Double price1 = new ProductComponent(webEl1).getProductPrice();
                Double price2 = new ProductComponent(webEl2).getProductPrice();

                return price1.compareTo(price2);
            }
        }).collect(Collectors.toList());

        for (int i = 0; i < sortedListOfProducts.size(); i++){
            System.out.println(sortedListOfProducts.get(i).getText());
        }
        return this;
    }
    public boolean verifyProductsListIsSorted() {
        for (int i = 0; i < sortedListOfProducts.size() - 1; i++) {
            if (!(getProductPrice(i, sortedListOfProducts) < getProductPrice(i + 1, sortedListOfProducts))) {
                if (getProductPrice(i, sortedListOfProducts) == getProductPrice(i + 1, sortedListOfProducts)){
                    continue;
                }
                return false;
            }
        }
        return true;
    }
     */
    public MainPage getListOfProductsSortedByPrice() {
        sortMenuButton.click();
        sortMenuButton.findElement(By.xpath("//option[text()='Price (low to high)']")).click();
        PageFactory.initElements(webDriver, this);

        return this;
    }
    public boolean verifyProductsListIsSorted() {
        for (int i = 0; i < productsList.size() - 1; i++) {
            if (!(getProductPrice(i, productsList) < getProductPrice(i + 1, productsList))) {
                if (getProductPrice(i, productsList) == getProductPrice(i + 1, productsList)){
                    continue;
                }
                return false;
            }
        }
        return true;
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
