package litmus.functional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Html {

	private final Document document;
	private String source;

	public Html(String source) {
		this.document = Jsoup.parse(source);
		this.source = source;
	}

	public String getTitle() {
		return document.title();
	}

	public Elements select(String selector) {
		return document.select(selector);
	}

	public Element selectSingle(String selector) {
		Elements elements = select(selector);
		if (elements.size() != 1) {
			String msgPrefix = elements.isEmpty() ? "no" : "more than one";
			throw new WrongSelectorException(msgPrefix + " element found for selector [" + selector + "]");
		}
		return elements.first();
	}


	public String getSource() {
		return source;
	}
}
