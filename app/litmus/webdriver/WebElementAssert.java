package litmus.webdriver;

import org.fest.assertions.GenericAssert;
import org.openqa.selenium.WebElement;

import static org.fest.assertions.Assertions.assertThat;

public class WebElementAssert extends GenericAssert<WebElementAssert, WebElement> {

    protected WebElementAssert(WebElement actual) {
        super(WebElementAssert.class, actual);
    }

    public WebElementAssert containsText(String s) {
        assertThat(actual.getText()).contains(s);
        return this;
    }

    public WebElementAssert hasText(String s) {
        assertThat(actual.getText()).isEqualTo(s);
        return this;
    }
}
