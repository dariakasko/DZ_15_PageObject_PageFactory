package org.example;

import org.openqa.selenium.WebDriver;

public class BaseClass {
    public WebDriver webDriver;

    public BaseClass(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
