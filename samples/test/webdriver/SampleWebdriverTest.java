package webdriver;

import litmus.webdriver.WebdriverTest;
import org.junit.Test;
import webdriver.pages.HelloWorldPage;

public class SampleWebdriverTest extends WebdriverTest {

    @Test
    public void testPage() {
        new HelloWorldPage()
                .open()
                .enterName("Ben")
                .clickSubmit();
    }
}
