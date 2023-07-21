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
        //div[@class='inventory_item_name']
        return parentElement.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        //return parentElement.findElement(By.cssSelector(".inventory_item_name")).getText();
    }
    public int getProductPrice() {
        return Integer.getInteger(parentElement.findElement(By.cssSelector(".inventory_item_price")).getText());
    }

    public boolean productNameIsVisible(){
        return parentElement.findElement(By.xpath("//div[@class='inventory_item_name']")).isDisplayed();
    }

    public void addProductToCart() {
        parentElement.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']")).click();
    }


}
