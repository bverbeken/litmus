package litmus.webdriver;

import litmus.Category;
import litmus.functional.FestAssertFunctionalTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebElement;
import play.Play;

import static java.lang.Integer.parseInt;
import static litmus.engine.CategoryInstance.WEBDRIVER;

@Category(value = WEBDRIVER, priority = 20000, slow = true)
public abstract class WebDriverTest extends FestAssertFunctionalTest {

    @BeforeClass
    public static void checkPlayConfig() {
        String playPool = Play.configuration.getProperty("play.pool");
        if (playPool == null) {
            throw new IllegalStateException("'play.pool' property not found. Please set the 'play.pool' property in your application.conf to at least 2");
        } else if (parseInt(playPool) < 2) {
            throw new IllegalStateException("Cannot run WebDriver tests when 'play.pool' config value is < 2. Please set the 'play.pool' property in your application.conf to at least 2");
        }
    }

    protected WebElementAssert assertThat(WebElement element) {
        return WebDriverAssertions.assertThat(element);
    }

    protected PageAssert assertThat(Page page) {
        return WebDriverAssertions.assertThat(page);
    }

}
