package testutil.functional.html;

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;

public class HtmlTagAssert extends GenericAssert<HtmlTagAssert, AbstractHtmlTag> {

	public HtmlTagAssert(AbstractHtmlTag element) {
		super(HtmlTagAssert.class, element);
	}

	public HtmlTagAssert containsText(String text) {
		Assertions.assertThat(actual.getText()).contains(text);
		return this;
	}

}
