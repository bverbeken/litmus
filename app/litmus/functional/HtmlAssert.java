package litmus.functional;

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;

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

}
