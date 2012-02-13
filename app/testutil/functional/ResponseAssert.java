package testutil.functional;

import org.fest.assertions.GenericAssert;
import play.mvc.Http;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.internal.matchers.StringContains.containsString;
import static play.mvc.Http.Response;
import static play.mvc.Http.StatusCode.*;

public class ResponseAssert extends GenericAssert<ResponseAssert, Http.Response> {

	public ResponseAssert(Response actual) {
		super(ResponseAssert.class, actual);
	}

	public ResponseAssert isStatus(int httpStatusCode) {
		assertThat("Wrong http status code ", actual.status, equalTo(httpStatusCode));
		return this;
	}

	public ResponseAssert isOk() {
		return isStatus(OK);
	}

	public ResponseAssert isNotFound() {
		return isStatus(NOT_FOUND);
	}

	public ResponseAssert isForbidden() {
		return isStatus(FORBIDDEN);
	}

	public ResponseAssert redirectsTo(String location) {
		return isStatus(FOUND).hasHeader("location", location);
	}

	private ResponseAssert hasHeader(String headerName, String headerValue) {
		assertThat("Wrong header value for [" + headerName + "]", actual.getHeader(headerName), equalTo(headerValue));
		return this;
	}


	public ResponseAssert hasContentType(String contentType) {
		assertThat("Wrong contentType", actual.contentType, containsString(contentType));
		return this;
	}

	public ResponseAssert isHtml() {
		return hasContentType("text/html");
	}

	public ResponseAssert isEncoded(String encoding) {
		assertThat("Wrong encoding", actual.encoding, equalTo(encoding));
		return this;
	}

	public ResponseAssert isUtf8() {
		return isEncoded("utf-8");
	}
}
