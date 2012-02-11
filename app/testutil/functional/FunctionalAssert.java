package testutil.functional;

import play.mvc.Http;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static play.mvc.Http.StatusCode.FOUND;

public class FunctionalAssert {

	private Http.Response response;

	public FunctionalAssert(Http.Response response) {
		this.response = response; 
	}

	public FunctionalAssert is(int httpStatusCode) {
		assertThat("Wrong http status code ", response.status, equalTo(httpStatusCode));
		return this;
	}

	public FunctionalAssert redirectsTo(String location) {
		return is(FOUND).hasHeader("location", location);
	}

	private FunctionalAssert hasHeader(String headerName, String headerValue) {
		assertThat("Wrong header value for ["+ headerName+ "]", response.getHeader(headerName), equalTo(headerValue));
		return this;
	}
}
