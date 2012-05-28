package webdriver;

import litmus.webdriver.WebdriverTest;
import org.junit.Test;
import webdriver.pages.HelloWorldPage;
import webdriver.pages.SayHelloPage;

public class SampleWebdriverTest extends WebdriverTest {

    @Test
    public void iShouldBeAbleToSubmitAndSeeTheMessage() {
        SayHelloPage page = new HelloWorldPage()
                .open()
                .enterName("World")
                .clickSubmit();

        assertThat(page.message).containsText("Hello");
        assertThat(page.message).containsText("World");
        assertThat(page.message).containsText("!");

        assertThat(page.message).containsTextExactly("Hello World!");

        assertThat(page.message).doesNotContainText("Byebye");
    }


    @Test
    public void iGetACorrectErrorMessageWhenSubmittingValueThatIsTooSmall() {
        HelloWorldPage page = new HelloWorldPage()
                .open()
                .enterName("Ben")
                .clickSubmitAndExpectValidationErrors();

        assertThat(page.error).containsTextExactly("Minimum size is 4");
    }

    @Test
    public void tagNameAssertExample(){
        SayHelloPage page = new HelloWorldPage().open()
                .enterName("Caroline")
                .clickSubmit();

        assertThat(page.message).hasTagName("div");
        assertThat(page.message).isDiv();
    }


}
