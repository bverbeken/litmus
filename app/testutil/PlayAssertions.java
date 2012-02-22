package testutil;

import org.fest.assertions.Assertions;
import play.mvc.Http;
import testutil.functional.cookie.CookieAssert;
import testutil.functional.html.*;
import testutil.functional.html.tags.AbstractHtmlList;
import testutil.functional.html.tags.AbstractHtmlTag;
import testutil.functional.html.tags.Anchor;
import testutil.functional.response.ResponseAssert;

public class PlayAssertions extends Assertions {

	public static ResponseAssert assertThat(Http.Response response) {
		return new ResponseAssert(response);
	}
	
	public static CookieAssert assertThat(Http.Cookie cookie){
		return new CookieAssert(cookie);
	}

	public static HtmlPageAssert assertThat(HtmlPage htmlPage) {
		return new HtmlPageAssert(htmlPage);
	}

	public static HtmlTagAssert<? extends HtmlTagAssert, AbstractHtmlTag> assertThat(AbstractHtmlTag element) {
		return new HtmlTagAssert<HtmlTagAssert, AbstractHtmlTag>(element);
	}

	public static HtmlListAssert assertThat(AbstractHtmlList list) {
		return new HtmlListAssert(list);
	}

	public static HtmlAnchorAssert assertThat(Anchor anchor){
		return new HtmlAnchorAssert(anchor);
	}
}
