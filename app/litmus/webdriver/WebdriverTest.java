package litmus.webdriver;

import litmus.functional.FestAssertFunctionalTest;
import org.junit.BeforeClass;
import play.Play;

import static java.lang.Integer.parseInt;

public abstract class WebdriverTest extends FestAssertFunctionalTest {

    @BeforeClass
    public static void checkPlayConfig() {
        String playPool = Play.configuration.getProperty("play.pool");
        if (playPool == null) {
            throw new IllegalStateException("'play.pool' property not found. Please set the 'play.pool' property in your application.conf to at least 2");
        } else if (parseInt(playPool) < 2) {
            throw new IllegalStateException("Cannot run webdriver tests when 'play.pool' config value is < 2. Please set the 'play.pool' property in your application.conf to at least 2");
        }
    }

}
