package litmus.webdriver;

import org.fest.assertions.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.tagName;
import static org.openqa.selenium.support.PageFactory.initElements;
import static play.Play.configuration;

@SuppressWarnings("unchecked")
public abstract class Page<SelfType extends Page> {

    public Page() {
        initElements(getWebDriver(), this);
        assertArrivedAt();
    }

    private static String getAppUrl() {
        String protocol = "http";
        String port = "9000";
        if (configuration.getProperty("https.port") != null) {
            port = configuration.getProperty("https.port");
            protocol = "https";
        } else if (configuration.getProperty("http.port") != null) {
            port = configuration.getProperty("http.port");
        }
        return protocol + "://localhost:" + port;
    }

    protected abstract boolean arrivedAt();

    protected String getTitle() {
        return getWebDriver().getTitle();
    }

    protected List<WebElement> findElements(String cssSelector) {
        return getWebDriver().findElements(By.cssSelector(cssSelector));
    }

    protected WebElement findElement(String cssSelector) {
        return getWebDriver().findElement(By.cssSelector(cssSelector));
    }

    protected WebElement findElementByTagName(String tagName) {
        return getWebDriver().findElement(tagName(tagName));
    }

    protected WebElement findElementById(String id) {
        return getWebDriver().findElement(By.id(id));
    }

    protected WebDriver getWebDriver() {
        return WebDriverFactory.getWebDriver();
    }

    public SelfType assertArrivedAt() {
        Assertions.assertThat(arrivedAt()).isTrue();
        return (SelfType) this;
    }

    public static void open(String relativeUrl) {
        WebDriverFactory.getWebDriver().get(getAppUrl() + relativeUrl);
    }

    public static void openUrl(String url) {
        WebDriverFactory.getWebDriver().get(url);
    }
}
