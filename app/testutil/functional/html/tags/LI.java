package testutil.functional.html.tags;

import org.jsoup.nodes.Element;

public class LI extends AbstractHtmlTag {

	public LI(Element element) {
		super(element);
	}

	@Override
	public String getTagName() {
		return "li";
	}
}
