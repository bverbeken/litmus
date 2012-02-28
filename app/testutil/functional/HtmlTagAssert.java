package testutil.functional;

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;
import testutil.functional.html.AbstractHtmlTag;

public class HtmlTagAssert<S extends HtmlTagAssert, T extends AbstractHtmlTag> extends GenericAssert<S, T> {

	@SuppressWarnings("unchecked")
	protected HtmlTagAssert(T actual) {
		super((Class<S>) HtmlTagAssert.class, actual);
	}

	protected HtmlTagAssert(Class<S> clazz, T tag){
		super(clazz, tag);
	}

	public HtmlTagAssert<S, T> containsText(String text) {
		Assertions.assertThat(actual.getText()).contains(text);
		return this;
	}

	public HtmlTagAssert<S, T> containsTextIgnoringCase(String text) {
		Assertions.assertThat(actual.getText()).containsIgnoringCase(text);
		return this;
	}

	public HtmlTagAssert<S, T> hasText(String text) {
		Assertions.assertThat(actual.getText()).as("wrong text").isEqualTo(text);
		return this;
	}

	public HtmlTagAssert<S, T> hasTextIgnoringCase(String text) {
		Assertions.assertThat(actual.getText()).as("wrong text").isEqualToIgnoringCase(text);
		return this;
	}

	public HtmlTagAssert<S, T> hasId(String id) {
		Assertions.assertThat(actual.getId()).as("wrong id").isEqualTo(id);
		return this;
	}
}
