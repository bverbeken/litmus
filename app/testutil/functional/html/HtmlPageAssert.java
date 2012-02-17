package testutil.functional.html;

import testutil.functional.AbstractFunctionalAssert;

public class HtmlPageAssert extends AbstractFunctionalAssert<HtmlPageAssert, HtmlPage> {

	public HtmlPageAssert(HtmlPage htmlPage) {
		super(HtmlPageAssert.class, htmlPage, htmlPage.response);
	}


	public HtmlPageAssert hasMetaTag(String name, String content) {
		// TODO Assertions.assertThat(actual.getMetaTag(name)).isEqualTo(content);
		return this;
	}
}
