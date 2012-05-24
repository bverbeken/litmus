package webdriver;

import litmus.webdriver.WebdriverTest;
import org.junit.Test;
import webdriver.pages.HelloWorldPage;
import webdriver.pages.SayHelloPage;

public class SampleWebdriverTest extends WebdriverTest {

    @Test
    public void testPage() {
        SayHelloPage page = new HelloWorldPage()
                .open()
                .enterName("World")
                .clickSubmit();

        assertThat(page.message).containsText("Hello");
        assertThat(page.message).containsText("World");
        assertThat(page.message).containsText("!");

        assertThat(page.message).hasText("Hello World!");
    }


    @Test
    public void testPageValidation() {
        HelloWorldPage page = new HelloWorldPage()
                .open()
                .enterName("Ben")
                .clickSubmitAndExpectValidationErrors();

        assertThat(page.error).hasText("Minimum size is 4");
    }
}
