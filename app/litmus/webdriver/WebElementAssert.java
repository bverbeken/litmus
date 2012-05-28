package litmus.webdriver;

import org.fest.assertions.GenericAssert;
import org.openqa.selenium.WebElement;

import static org.fest.assertions.Assertions.assertThat;

public class WebElementAssert extends GenericAssert<WebElementAssert, WebElement> {

    protected WebElementAssert(WebElement actual) {
        super(WebElementAssert.class, actual);
    }

    public WebElementAssert containsText(String text) {
        assertThat(actual.getText()).contains(text);
        return this;
    }

    public WebElementAssert doesNotContainText(String text) {
        assertThat(actual.getText()).doesNotContain(text);
        return this;
    }

    public WebElementAssert containsTextExactly(String text) {
        assertThat(actual.getText()).isEqualTo(text);
        return this;
    }

    public WebElementAssert hasTagName(String tagName) {
        assertThat(actual.getTagName()).isEqualToIgnoringCase(tagName);
        return this;
    }

    public WebElementAssert isDiv() {
        return hasTagName("div");
    }

    public WebElementAssert hasAttribute(String key, String value) {
        assertThat(actual.getAttribute(key)).isEqualTo(value);
        return this;
    }

    public WebElementAssert hasClass(String cssClass){
        String actualClasses = actual.getAttribute("class");
        assertThat(actualClasses).contains(cssClass);
        return this;
    }

    public WebElementAssert hasCssValue(String key, String value) {
        assertThat(actual.getCssValue(key)).isEqualTo(value);
        return this;
    }


}
