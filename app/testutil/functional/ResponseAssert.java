package testutil.functional;

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;
import play.mvc.Http;

import static play.mvc.Http.Response;
import static play.mvc.Http.StatusCode.*;

public class ResponseAssert extends GenericAssert<ResponseAssert, Http.Response> {

	ResponseAssert(Response actual) {
		super(ResponseAssert.class, actual);
	}

	public ResponseAssert isStatus(int httpStatusCode) {
		Assertions.assertThat(actual.status).isEqualTo(httpStatusCode);
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
		Assertions.assertThat(actual.getHeader(headerName)).isEqualTo(headerValue);
		return this;
	}


	public ResponseAssert hasContentType(String contentType) {
		Assertions.assertThat(actual.contentType).containsIgnoringCase(contentType);
		return this;
	}

	public ResponseAssert isHtml() {
		return hasContentType("text/html");
	}

	public ResponseAssert isEncoded(String encoding) {
		Assertions.assertThat(actual.encoding).isEqualToIgnoringCase(encoding);
		return this;
	}

	public ResponseAssert isUtf8() {
		return isEncoded("utf-8");
	}
}
