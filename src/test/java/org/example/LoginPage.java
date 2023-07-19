package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage extends BaseClass{
    @FindBy(xpath = "//input[@name='user-name']")
    private WebElement userNameInputField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement userPasswordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(css = ".login_logo")
    private WebElement loginLogo;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public LoginPage enterUserName(String userName) {
        userNameInputField.sendKeys(userName);
        return this;
    }

    public LoginPage eneterUserPassword(String password){
        userPasswordField.sendKeys(password);
        return this;
    }

    public MainPage clickOnLoginButton() {
        loginButton.click();
        return new MainPage(webDriver);
    }

    public boolean verifyLoginPageIsVisible(){
        return loginLogo.isDisplayed();
    }


}
