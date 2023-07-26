package testClasses;

import org.example.LoginPage;
import org.example.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTestClass extends BaseFirefoxBrowser114TestClass{
    static int counter = 0;
    final String WEB_PAGE = "https://www.saucedemo.com/";
    @Test
    @DisplayName("Verify login")
    public void verifyLogin(){
        chromeDriver.get(WEB_PAGE);

        new LoginPage(chromeDriver)
                .enterUserName("standard_user")
                .eneterUserPassword("secret_sauce")
                .clickOnLoginButton();
        Assertions.assertTrue(new MainPage(chromeDriver).nameOfMainPageIsVisible());
    }

    @Test
    @DisplayName("Verify products visibility")
    public void verifyProductsNamesAreVisible(){
        chromeDriver.get(WEB_PAGE);

        Assertions.assertTrue(new LoginPage(chromeDriver)
                .enterUserName("standard_user")
                .eneterUserPassword("secret_sauce")
                .clickOnLoginButton()
                .productsNamesAreVisible());
    }
    @Test
    @DisplayName("Verify product's List is sorted")
    public void verifyListIsSorted(){
        chromeDriver.get(WEB_PAGE);

        Assertions.assertTrue(new LoginPage(chromeDriver)
                .enterUserName("standard_user")
                .eneterUserPassword("secret_sauce")
                .clickOnLoginButton()
                .sortListByPrice()
                .verifyProductsListIsSorted());
    }


    @Test
    @DisplayName("Verify products are added to Cart")
    public void verifyProductsAddedToCart(){
        chromeDriver.get(WEB_PAGE);

        Assertions.assertTrue(new LoginPage(chromeDriver)
                .enterUserName("standard_user")
                .eneterUserPassword("secret_sauce")
                .clickOnLoginButton()
                .addSomeProductsToCart()
                .openCartWithAddedProducts(chromeDriver)
                .productsInCartAreVisible());
    }

    @Test
    @DisplayName("Verify logout")
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
