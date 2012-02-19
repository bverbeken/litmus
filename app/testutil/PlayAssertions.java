package testutil;

import org.fest.assertions.Assertions;
import play.mvc.Http;
import testutil.functional.response.ResponseAssert;
import testutil.functional.html.HtmlPage;
import testutil.functional.html.HtmlPageAssert;

public class PlayAssertions extends Assertions {

	public static ResponseAssert assertThat(Http.Response response) {
		return new ResponseAssert(response);
	}

	public static HtmlPageAssert assertThat(HtmlPage htmlPage) {
		return new HtmlPageAssert(htmlPage);
	}

}
