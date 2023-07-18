package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass{
    @FindBy(xpath = "//input[@name='user-name']")
    private By userNameInputField;

    @FindBy(xpath = "//input[@name='password']")
    private By userPasswordField;

    @FindBy(id = "login-button")
    private By loginButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public LoginPage enterUserName(String userName) {
        webDriver.findElement(userNameInputField).sendKeys(userName);
        return this;
    }

    public LoginPage eneterUserPassword(String password){
        webDriver.findElement(userPasswordField).sendKeys(password);
        return this;
    }

    public MainPage clickOnLoginButton() {
        webDriver.findElement(loginButton).click();
        return new MainPage(webDriver);
    }
}
