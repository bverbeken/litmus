package testutil.functional.html;

import org.fest.assertions.Assertions;
import testutil.functional.AbstractFunctionalAssert;

public class HtmlPageAssert extends AbstractFunctionalAssert<HtmlPageAssert, HtmlPage> {

	public HtmlPageAssert(HtmlPage htmlPage) {
		super(HtmlPageAssert.class, htmlPage, htmlPage.getResponse());
	}

	public HtmlPageAssert hasMetaTag(String name, String content) {
		Assertions.assertThat(actual.getMetaTag(name)).isEqualTo(content);
		return this; 
	}
}
