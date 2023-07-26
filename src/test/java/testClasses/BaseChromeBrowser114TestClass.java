package testClasses;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class BaseChromeBrowser114TestClass {
    public RemoteWebDriver chromeDriver;

    @BeforeEach
    public void init() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();

        options.setCapability("browserVersion", "114.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to add test badge */
            put("name", "Test badge...");

            /* How to set session timeout */
            put("sessionTimeout", "15m");

            /* How to set timezone */
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});

            /* How to add "trash" button */
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});

            /* How to enable video recording */
            put("enableVNC", true);
        }});
        chromeDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        chromeDriver.manage().window().maximize();
    }

    @AfterEach
    public void clear(){
        chromeDriver.quit();
    }

}
