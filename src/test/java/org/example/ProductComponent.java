package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductComponent {
    private WebElement parentElement;
    private WebElement productName;
    private WebElement productPrice;

    public ProductComponent(WebElement parentElement) {
        this.parentElement = parentElement;
    }

    public String getProductName() {
        return parentElement.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
    }
    public double getProductPrice() {
        return Double.parseDouble(parentElement.findElement(By.cssSelector(".inventory_item_price")).getText().substring(1));
    }

    public boolean productNameIsVisible(){
        return parentElement.findElement(By.xpath("//div[@class='inventory_item_name']")).isDisplayed();
    }

    public void addProductToCart() {
        parentElement.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']")).click();
    }


}
