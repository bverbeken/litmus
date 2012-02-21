package testutil.functional.html;

import org.fest.assertions.Assertions;
import testutil.functional.AbstractFunctionalAssert;

public class HtmlPageAssert extends AbstractFunctionalAssert<HtmlPageAssert, HtmlPage> {

	public HtmlPageAssert(HtmlPage htmlPage) {
		super(HtmlPageAssert.class, htmlPage, htmlPage.getResponse());
	}

	public HtmlPageAssert hasTitle(String title) {
		Assertions.assertThat(actual.getTitle()).isEqualTo(title);
		return this;
	}
}
