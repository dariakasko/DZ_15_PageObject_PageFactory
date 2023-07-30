package tests;

import org.example.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.baseClasses.BaseFirefoxBrowser114Test;

public class ProductsVisibilityTest extends BaseFirefoxBrowser114Test {
    static int counter = 0;
    final String WEB_PAGE = "https://www.saucedemo.com/";

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
    @AfterEach
    public void clear() {
        chromeDriver.quit();
    }

}
