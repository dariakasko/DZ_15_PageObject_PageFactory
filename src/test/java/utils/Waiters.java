package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiters {
    public static WebElement useExplicitWaiter(WebDriver driver, By by) {
        WebDriverWait explicitWaiter = new WebDriverWait(driver, Duration.ofSeconds(10));

        return explicitWaiter.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
