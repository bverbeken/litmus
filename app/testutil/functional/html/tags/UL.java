package testutil.functional.html.tags;

import org.jsoup.nodes.Element;

public class UL extends AbstractHtmlList {

	public UL(Element element) {
		super(element);
	}

	@Override
	protected String getTagName() {
		return "ul";
	}

}
