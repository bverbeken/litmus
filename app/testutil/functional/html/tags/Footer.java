package testutil.functional.html.tags;

import org.jsoup.nodes.Element;
import testutil.functional.html.AbstractHtmlTag;

public class Footer extends AbstractHtmlTag {

	public Footer(Element element) {
		super(element);
	}

	@Override
	protected String getTagName() {
		return "footer";
	}

}
