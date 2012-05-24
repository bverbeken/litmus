package litmus.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    private static WebDriver driver;

    public static WebDriver getWebdriver() {
        if (driver == null){
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public static void quitAndInit() {
        driver.quit();
        driver = null;
    }
}
