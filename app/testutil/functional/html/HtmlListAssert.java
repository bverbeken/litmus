package testutil.functional.html;

import org.fest.assertions.Assertions;
import testutil.functional.html.tags.AbstractHtmlList;

public class HtmlListAssert extends HtmlTagAssert<HtmlListAssert, AbstractHtmlList> {

	public HtmlListAssert(AbstractHtmlList list) {
		super(HtmlListAssert.class, list);
	}

	public HtmlListAssert containsExactlyItemsWithText(String... items) {
		Assertions.assertThat(actual.getTextFromItems()).containsExactly(items);
		return this;
	}

	public HtmlListAssert hasSize(int size) {
		Assertions.assertThat(actual.getItems()).hasSize(size);
		return this;
	}
}
