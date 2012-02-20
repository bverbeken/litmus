package testutil.functional.html;

import org.fest.assertions.Assertions;
import testutil.functional.AbstractFunctionalAssert;

public class HtmlPageAssert extends AbstractFunctionalAssert<HtmlPageAssert, HtmlPage> {

	public HtmlPageAssert(HtmlPage htmlPage) {
		super(HtmlPageAssert.class, htmlPage, htmlPage.getResponse());
	}

	public HtmlPageAssert hasMeta(String name, String content) {
		Assertions.assertThat(actual.getMeta(name)).isEqualTo(content);
		return this; 
	}

	public HtmlPageAssert hasTitle(String title) {
		Assertions.assertThat(actual.getTitle()).isEqualTo(title);
		return this;
	}
}
