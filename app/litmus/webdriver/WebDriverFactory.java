package litmus.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class WebDriverFactory {

    private static WebDriver driver;

    public static WebDriver getWebDriver() {
        if (driver == null) {
            driver = new HtmlUnitDriver();
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
