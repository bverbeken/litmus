package testutil.functional.html.tags;

import org.jsoup.nodes.Element;
import play.mvc.Http;
import testutil.util.RequestBuilder;

public class Anchor extends AbstractHtmlTag {

	public Anchor(Element element) {
		super(element);
	}

	@Override
	public String getTagName() {
		return "a";
	}

	public String getHref() {
		return element.attr("href");
	}

	public Http.Response click(){
		return new RequestBuilder(getHref()).get();
	}

}
