package litmus.functional;

import org.fest.assertions.Assertions;
import play.mvc.Http;

public class FunctionalAssertions extends Assertions {

	public static ResponseAssert assertThat(Response response) {
		return new ResponseAssert(response);
	}

	public static CookieAssert assertThat(Http.Cookie cookie) {
		return new CookieAssert(cookie);
	}

	public static HtmlAssert assertThat(Html html){
		return new HtmlAssert(html);
	}

}