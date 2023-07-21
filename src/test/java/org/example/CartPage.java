package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BaseClass{

    @FindBy(xpath = "//div[@class='cart_item']")
    private List<WebElement> cartList;

    public CartPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }
    private boolean productInCartIsVisible(int idOfCartItem) {
        return new CartComponent(cartList.get(idOfCartItem)).productInCartIsVisible();
    }
    public boolean productsInCartAreVisible() {
        for (int i = 0; i < cartList.size(); i++) {
            if (!productInCartIsVisible(i))
                return false;
        }
        return true;
    }




    /*
    public boolean productsInCartAreVisible(){
        return productInCartBackpack.isDisplayed() && productInCartBikeLight.isDisplayed();
    }
     */


}
