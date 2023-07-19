package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginTestClass extends BaseTestClass{
    final String WEB_PAGE = "https://www.saucedemo.com/";
    @Test
    public void verifyLogin(){
        chromeDriver.get(WEB_PAGE);

        new LoginPage(chromeDriver)
                .enterUserName("standard_user")
                .eneterUserPassword("secret_sauce")
                .clickOnLoginButton();
        Assertions.assertTrue(new MainPage(chromeDriver).nameOfMainPageIsVisible());
    }

    @Test
    public void verifyVisibilityOfProducts() {
        chromeDriver.get(WEB_PAGE);

        new LoginPage(chromeDriver)
                .enterUserName("standard_user")
                .eneterUserPassword("secret_sauce")
                .clickOnLoginButton();

        Assertions.assertTrue(new MainPage(chromeDriver).listOfProductsIsVisible());

        By price1 = By.xpath("//div[text()='29.99']");
        System.out.println(chromeDriver.findElement(price1).getText());
    }
    @Test
    public void verifyProductsAddedToCart() {
        chromeDriver.get(WEB_PAGE);

        Assertions.assertTrue(new LoginPage(chromeDriver)
                .enterUserName("standard_user")
                .eneterUserPassword("secret_sauce")
                .clickOnLoginButton()
                .addProductsToCart()
                .openCartWithAddedProducts(chromeDriver)
                .productsInCartAreVisible());

    }

    @Test
    public void logout(){
        chromeDriver.get(WEB_PAGE);

        new LoginPage(chromeDriver)
                .enterUserName("standard_user")
                .eneterUserPassword("secret_sauce")
                .clickOnLoginButton()
                .logout(chromeDriver)
                .verifyLoginPageIsVisible();
    }

    @AfterEach
    public void clear() {
        chromeDriver.quit();
    }

}
