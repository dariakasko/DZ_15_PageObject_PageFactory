package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

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
    }


}
