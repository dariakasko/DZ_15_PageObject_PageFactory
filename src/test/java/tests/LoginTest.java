package tests;

import org.example.pages.LoginPage;
import org.example.pages.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.baseClasses.BaseFirefoxBrowser114Test;

public class LoginTest extends BaseFirefoxBrowser114Test {
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
    @AfterEach
    public void clear() {
        chromeDriver.quit();
    }

}
