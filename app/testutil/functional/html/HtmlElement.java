package testutil.functional.html;

import org.jsoup.nodes.Element;

public class HtmlElement {

	private Element element;

	public HtmlElement(Element element) {
		this.element = element;
	}

	public String getText() {
		return element.text();
	}
}
