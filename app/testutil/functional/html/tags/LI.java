package testutil.functional.html.tags;

import org.jsoup.nodes.Element;
import testutil.functional.html.AbstractHtmlTag;

public class LI extends AbstractHtmlTag {

	public LI(Element element) {
		super(element);
	}

	@Override
	protected String getTagName() {
		return "li";
	}
}
