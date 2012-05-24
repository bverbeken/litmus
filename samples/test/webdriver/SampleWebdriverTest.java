package webdriver;

import litmus.webdriver.WebdriverTest;
import org.junit.Test;
import webdriver.pages.HelloWorldPage;

public class SampleWebdriverTest extends WebdriverTest {

    @Test
    public void testPage() {
        String actualMessage = new HelloWorldPage()
                .open()
                .enterName("World")
                .clickSubmit()
                .getMessage();

        assertThat(actualMessage).isEqualTo("Hello World!");
    }
}
