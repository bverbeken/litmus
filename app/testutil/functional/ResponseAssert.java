package testutil.functional;

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;
import play.mvc.Http;

import java.io.UnsupportedEncodingException;

import static java.lang.String.format;
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


	// TODO move everything below this line to a separate HtmlRepsonseAssert (subclass of ResponseAssert)
	public ResponseAssert hasMetaTag(String name, String content) {
		// TODO: use HtmlUsnit here? Or some html parser at least..
		Assertions.assertThat(readContent()).contains(format("<meta name=\"%s\" content=\"%s\">", name, content));
		return this;
	}


	public ResponseAssert contains(String expected) {
		Assertions.assertThat(readContent()).contains(expected);
		return this;
	}

	private String readContent() {
		try {
			return new String(actual.out.toByteArray(), actual.encoding);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

}
