package tests.baseClasses;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;

public class BaseLocalTest {
    public WebDriver chromeDriver;
    @BeforeEach
    public void init() throws MalformedURLException {
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
    }

    @AfterEach
    public void clear(){
        chromeDriver.quit();
    }

}

