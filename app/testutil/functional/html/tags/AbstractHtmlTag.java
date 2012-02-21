package testutil.functional.html.tags;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public abstract class AbstractHtmlTag {

	protected Element element;

	public AbstractHtmlTag(Element element) {
		this.element = element;
	}

	public String getText() {
		return element.text();
	}

	public abstract String getTagName();


	public Anchor getSingleLink() {
		Elements elements = element.getElementsByTag("a");
		if (elements.isEmpty()) return null;
		else if (elements.size() > 1) throw new IllegalStateException("More than one link found... " + elements);
		else return new Anchor(elements.first());
	}
}
