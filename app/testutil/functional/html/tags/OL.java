package testutil.functional.html.tags;

import org.jsoup.nodes.Element;

public class OL extends AbstractHtmlList {

	public OL(Element element) {
		super(element);
	}

	@Override
	protected String getTagName() {
		return "ol";
	}
}
