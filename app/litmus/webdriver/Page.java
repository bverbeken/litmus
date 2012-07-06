package litmus.webdriver;

import org.fest.assertions.Assertions;
import org.openqa.selenium.WebDriver;

import static litmus.webdriver.WebDriverFactory.getWebdriver;
import static org.openqa.selenium.support.PageFactory.initElements;
import static play.Play.configuration;

@SuppressWarnings("unchecked")
public abstract class Page<T extends Page> {

    private final String relativeUrl;
    protected WebDriver driver;

    public Page(String relativeUrl) {
        this.relativeUrl = relativeUrl;
        this.driver = WebDriverFactory.getWebdriver();
        initElements(driver, this);
    }

    public T open() {
        WebDriver driver = getWebdriver();
        driver.get(getAppUrl() + relativeUrl);
        return assertArrivedAt();
    }

    private String getAppUrl() {
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
        return driver.getTitle();
    }

    public T assertArrivedAt() {
        Assertions.assertThat(arrivedAt()).isTrue();
        return (T) this;
    }


}
