package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

public class LoginTestClass extends BaseTestClass{
    @Test
    public void verifyLogin(){
        chromeDriver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(chromeDriver);
        loginPage.enterUserName("standard_user")
                .eneterUserPassword("secret_sauce")
                .clickOnLoginButton();
        Assertions.assertTrue(chromeDriver.findElement(By.xpath("//span[text()='Products']")).isDisplayed());
    }
}
