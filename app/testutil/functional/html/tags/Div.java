package testutil.functional.html.tags;

import org.jsoup.nodes.Element;
import testutil.functional.html.AbstractHtmlTag;

public class Div extends AbstractHtmlTag {

	public Div(Element element) {
		super(element);
	}

	@Override
	protected String getTagName() {
		return "div";
	}

}
