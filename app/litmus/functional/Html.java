package litmus.functional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Html {

	private final Document document;

	public Html(String content) {
		this.document = Jsoup.parse(content);
	}

	public String getTitle() {
		return document.title();
	}

}
