package testutil.functional;

import org.fest.assertions.Assertions;

public class HtmlPageAssert extends FunctionalAssert<HtmlPageAssert, HtmlPage> {

	protected  HtmlPageAssert(HtmlPage htmlPage) {
		super(HtmlPageAssert.class, htmlPage, htmlPage.getResponse());
	}

	public HtmlPageAssert hasTitle(String title) {
		Assertions.assertThat(actual.getTitle()).isEqualTo(title);
		return this;
	}
}
