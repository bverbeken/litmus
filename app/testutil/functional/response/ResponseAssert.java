package testutil.functional.response;

import org.fest.assertions.Assertions;
import play.mvc.Http;
import testutil.functional.AbstractFunctionalAssert;

import static play.mvc.Http.Response;

@SuppressWarnings("unchecked")
public class ResponseAssert extends AbstractFunctionalAssert<ResponseAssert, Response> {

	public ResponseAssert(Response actual) {
		super(ResponseAssert.class, actual, actual);
	}

	public ResponseAssert hasCookie(String cookieName) {
		Http.Cookie cookie = actual.cookies.get(cookieName);
		Assertions.assertThat(cookie).isNotNull();
		return this;
	}

	public ResponseAssert hasNoCookie(String cookieName) {
		Assertions.assertThat(actual.cookies.get(cookieName)).isNull();
		return this;
	}
}
