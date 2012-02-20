package testutil.functional.html;

import org.fest.assertions.Assertions;
import testutil.functional.html.tags.AbstractHtmlList;

public class HtmlListAssert extends HtmlTagAssert {

	public HtmlListAssert(AbstractHtmlList element) {
		super(element);
	}

	public HtmlListAssert containsExactly(String... items) {
		Assertions.assertThat(actual.getTextFromItems()).containsExactly(items);
		return this;
	}

	public HtmlListAssert isUnordered() {
		Assertions.assertThat(actual.getTagName()).isEqualToIgnoringCase("ul");
		return this;
	}


	public HtmlListAssert isOrdered() {
		Assertions.assertThat(actual.getTagName()).isEqualToIgnoringCase("ol");
		return this;
	}

	public HtmlListAssert hasSize(int size) {
		Assertions.assertThat(actual.getItems()).hasSize(size);
		return this;
	}
}
