package webdriver;

import litmus.webdriver.WebDriverTest;
import org.junit.Test;
import webdriver.pages.HelloWorldPage;
import webdriver.pages.SayHelloPage;

import static webdriver.pages.Pages.goToHelloWorldPage;
import static webdriver.pages.Pages.goToSayHelloPage;

public class SampleWebDriverTest extends WebDriverTest {

    @Test
    public void iShouldBeAbleToSubmitAndSeeTheMessage() {
        SayHelloPage page = goToHelloWorldPage()
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
        HelloWorldPage page = goToHelloWorldPage()
                .enterName("Ben")
                .clickSubmitAndExpectValidationErrors();

        assertThat(page.error).containsTextExactly("Minimum size is 4");
    }

    @Test
    public void tagNameAssertExample() {
        SayHelloPage page = goToHelloWorldPage()
                .enterName("Caroline")
                .clickSubmit();

        assertThat(page.message).hasTagName("div");
        assertThat(page.message).isDiv();
    }

    @Test
    public void iCanDirectlyAccessTheSayHelloPage(){
        SayHelloPage page = goToSayHelloPage("Ben Verbeken");

        assertThat(page).hasTitle("SayHello");
        assertThat(page.message).containsTextExactly("Hello Ben Verbeken!");
    }


}
