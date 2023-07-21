package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartComponent {

    private WebElement parentElement;
    private WebElement productName;

    public CartComponent(WebElement parentElement) {
        this.parentElement = parentElement;
    }

    public boolean productInCartIsVisible() {
        return parentElement.findElement(By.xpath("//div[@class='cart_contents_container']")).isDisplayed();
    }
}
