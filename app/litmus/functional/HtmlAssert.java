package litmus.functional;

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;
import org.jsoup.select.Elements;

import static java.lang.String.format;

public class HtmlAssert extends GenericAssert<HtmlAssert, Html> {

	public HtmlAssert(Html html) {
		super(HtmlAssert.class, html);
	}

	public HtmlAssert hasTitle(String title) {
		Assertions.assertThat(actual.getTitle()).isEqualTo(title);
		return this;
	}

	public HtmlAssert titleContains(String titlePart) {
		Assertions.assertThat(actual.getTitle()).contains(titlePart);
		return this;
	}

	public HtmlAssert titleMatches(String regex) {
		Assertions.assertThat(actual.getTitle()).matches(regex);
		return this;
	}


	public HtmlAssert containsElement(String selector) {
		Assertions.assertThat(actual.select(selector))
				.as(format("Response html does not contain element that satisfies [%s]", selector))
				.isNotEmpty();
		return this;
	}

	public HtmlAssert doesNotContainElement(String selector) {
		Elements elements = actual.select(selector);
		Assertions.assertThat(elements)
				.as(format("Response html contains the following elements that satisfy [%s]: %s", selector, elements))
				.isEmpty();
		return this;
	}

}
