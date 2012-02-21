package testutil.functional.html;

import org.fest.assertions.Assertions;
import testutil.functional.html.tags.Anchor;

public class HtmlAnchorAssert extends HtmlTagAssert<HtmlAnchorAssert, Anchor>{

	public HtmlAnchorAssert(Anchor anchor) {
		super(HtmlAnchorAssert.class, anchor);
	}


	public void hasHref(String href) {
		Assertions.assertThat(actual.getHref()).isEqualTo(href);
	}

}
