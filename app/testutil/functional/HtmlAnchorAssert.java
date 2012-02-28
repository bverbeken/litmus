package testutil.functional;

import org.fest.assertions.Assertions;
import testutil.functional.html.Anchor;

public class HtmlAnchorAssert extends HtmlTagAssert<HtmlAnchorAssert, Anchor>{

	protected  HtmlAnchorAssert(Anchor anchor) {
		super(HtmlAnchorAssert.class, anchor);
	}


	public void hasHref(String href) {
		Assertions.assertThat(actual.getHref()).isEqualTo(href);
	}

}
