package testutil.functional.html;

import org.jsoup.nodes.Element;
import testutil.functional.Request;
import testutil.functional.Response;

import static org.apache.commons.lang.StringUtils.isBlank;

public class Anchor extends AbstractHtmlTag {

	public Anchor(Element element) {
		super(element);
	}

	public String getHref() {
		return element.attr("href");
	}

	public Response followHref() {
		String href = getHref();
		if (isBlank(href)) {
			throw new IllegalStateException("Anchor has no href attribute. Please provide one or override its click method");
		} else {
			return new Request(href).get();
		}
	}

}
