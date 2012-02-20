package testutil.functional.html;

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;

public class HtmlElementAssert extends GenericAssert<HtmlElementAssert, HtmlElement> {

	public HtmlElementAssert(HtmlElement element) {
		super(HtmlElementAssert.class, element);
	}

	public HtmlElementAssert containsText(String text) {
		Assertions.assertThat(actual.getText()).contains(text);
		return this;
	}

}
