package testutil.functional.html;

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;
import testutil.functional.html.tags.AbstractHtmlTag;

public class HtmlTagAssert<S extends HtmlTagAssert, T extends AbstractHtmlTag> extends GenericAssert<S, T> {

	@SuppressWarnings("unchecked")
	public HtmlTagAssert(T actual) {
		super((Class<S>) HtmlTagAssert.class, actual);
	}

	protected HtmlTagAssert(Class<S> clazz, T tag){
		super(clazz, tag);
	}

	public HtmlTagAssert<? extends HtmlTagAssert, ? extends AbstractHtmlTag> containsText(String text) {
		Assertions.assertThat(actual.getText()).contains(text);
		return this;
	}

	public HtmlTagAssert<? extends HtmlTagAssert, ? extends AbstractHtmlTag> containsTextIgnoringCase(String text) {
		Assertions.assertThat(actual.getText()).containsIgnoringCase(text);
		return this;
	}

	public HtmlTagAssert<? extends HtmlTagAssert, ? extends AbstractHtmlTag> hasText(String text) {
		Assertions.assertThat(actual.getText()).isEqualTo(text);
		return this;
	}

	public HtmlTagAssert<? extends HtmlTagAssert, ? extends AbstractHtmlTag> hasTextIgnoringCase(String text) {
		Assertions.assertThat(actual.getText()).isEqualToIgnoringCase(text);
		return this;
	}

}
