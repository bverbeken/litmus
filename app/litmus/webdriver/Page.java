package litmus.webdriver;

import org.fest.assertions.Assertions;

import static litmus.webdriver.WebDriverFactory.getWebDriver;
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

    public SelfType assertArrivedAt() {
        Assertions.assertThat(arrivedAt()).isTrue();
        return (SelfType) this;
    }


    public static void open(String relativeUrl) {
        getWebDriver().get(getAppUrl() + relativeUrl);
    }
}
