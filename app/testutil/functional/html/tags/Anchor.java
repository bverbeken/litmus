package testutil.functional.html.tags;

import org.jsoup.nodes.Element;

public class Anchor extends AbstractHtmlTag {

	public Anchor(Element element) {
		super(element);
	}

	@Override
	public String getTagName() {
		return "a";
	}

	public String getHref() {
		return element.attr("href");
	}
}
