package testutil.functional.html;

import org.jsoup.nodes.Element;

public abstract class AbstractHtmlTag {

	protected Element element;

	public AbstractHtmlTag(Element element) {
		this.element = element;
	}

	public String getText() {
		return element.text();
	}

	public String getId() {
		return element.id();
	}



}
