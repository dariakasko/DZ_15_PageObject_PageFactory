package tests;

import org.example.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.baseClasses.BaseFirefoxBrowser114Test;
import tests.baseClasses.BaseLocalTest;

public class LogoutTest extends BaseLocalTest {
    static int counter = 0;
    final String WEB_PAGE = "https://www.saucedemo.com/";
    @Test
    @DisplayName("Verify logout")
    public void logout(){
        chromeDriver.get(WEB_PAGE);

        Assertions.assertTrue(new LoginPage(chromeDriver)
                .enterUserName("standard_user")
                .eneterUserPassword("secret_sauce")
                .clickOnLoginButton()
                .logout(chromeDriver)
                .verifyLoginPageIsVisible());
    }

    @AfterEach
    public void clear() {
        chromeDriver.quit();
    }

}
