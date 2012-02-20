package testutil;

import org.fest.assertions.Assertions;
import org.jsoup.nodes.Element;
import play.mvc.Http;
import testutil.functional.html.HtmlElementAssert;
import testutil.functional.html.HtmlPage;
import testutil.functional.html.HtmlPageAssert;
import testutil.functional.response.ResponseAssert;

public class PlayAssertions extends Assertions {

	public static ResponseAssert assertThat(Http.Response response) {
		return new ResponseAssert(response);
	}

	public static HtmlPageAssert assertThat(HtmlPage htmlPage) {
		return new HtmlPageAssert(htmlPage);
	}

	public static HtmlElementAssert assertThat(Element element) {
		return new HtmlElementAssert(element);
	}
}
