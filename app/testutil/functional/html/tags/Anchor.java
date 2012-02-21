package testutil.functional.html.tags;

import org.jsoup.nodes.Element;
import play.mvc.Http;
import testutil.util.RequestBuilder;

import static java.lang.String.format;
import static org.apache.commons.lang.StringUtils.isBlank;

public class Anchor extends AbstractHtmlTag {

	public Anchor(Element element) {
		super(element);
	}

	public String getHref() {
		return element.attr("href");
	}

	public Http.Response followHref() {
		String href = getHref();
		if (isBlank(href)) {
			throw new IllegalStateException(format("Anchor with id '%s' has no href attribute. Please provide one or override its click method", getId()));
		} else {
			return new RequestBuilder(href).get();
		}
	}

}
