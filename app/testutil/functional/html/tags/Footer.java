package testutil.functional.html.tags;

import org.jsoup.nodes.Element;

public class Footer extends AbstractHtmlTag {

	public Footer(Element element) {
		super(element);
	}

	@Override
	public String getTagName() {
		return "footer";
	}

}
