package litmus.webdriver;

import org.apache.commons.lang.NotImplementedException;
import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;

public class PageAssert extends GenericAssert<PageAssert, Page> {

    public PageAssert(Page page) {
        super(PageAssert.class, page);
    }

    public PageAssert hasTitle(String expectedTitle) {
        Assertions.assertThat(actual.getTitle()).isEqualTo(expectedTitle);
        return this;
    }

    public PageAssert containsFieldError(String field, String error) {
        Assertions.assertThat(actual.findElementById(field + "Error").getText()).contains(error);
        return this;
    }
}
