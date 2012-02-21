package testutil.functional.html.tags;

import org.jsoup.nodes.Element;

public class UL extends AbstractHtmlList {

	public UL(Element element) {
		super(element);
	}

	@Override
	public String getTagName() {
		return "ul";
	}

}
