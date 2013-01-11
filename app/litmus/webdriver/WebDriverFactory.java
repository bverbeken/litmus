package litmus.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.util.concurrent.TimeUnit.SECONDS;

public class WebDriverFactory {

    private static WebDriver driver;

    public static WebDriver getWebDriver() {
        if (driver == null) {
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(5, SECONDS);
        }
        return driver;
    }

    public static void quitAndInit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
