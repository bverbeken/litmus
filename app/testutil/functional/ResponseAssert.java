package testutil.functional;

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;
import play.mvc.Http;
import testutil.util.ResponseContentTypeUtil;

import java.io.UnsupportedEncodingException;

import static play.mvc.Http.Response;
import static play.mvc.Http.StatusCode.*;

@SuppressWarnings("unchecked")
public class ResponseAssert <T extends ResponseAssert> extends GenericAssert<T, Http.Response> {


	ResponseAssert(Response actual){
		super((Class<T>) ResponseAssert.class, actual);
	}

	protected ResponseAssert(Class<T> selfType, Response actual) {
		super(selfType, actual);
	}

	public T isStatus(int httpStatusCode) {
		Assertions.assertThat(actual.status).isEqualTo(httpStatusCode);
		return (T) this;
	}

	public T isOk() {
		return isStatus(OK);
	}

	public T isNotFound() {
		return isStatus(NOT_FOUND);
	}

	public T isForbidden() {
		return isStatus(FORBIDDEN);
	}

	public T redirectsTo(String location) {
		return (T) isStatus(FOUND).hasHeader("location", location);
	}

	private T hasHeader(String headerName, String headerValue) {
		Assertions.assertThat(actual.getHeader(headerName)).isEqualTo(headerValue);
		return (T) this;
	}


	public T hasContentType(String expected) {
		Assertions.assertThat(ResponseContentTypeUtil.hasContentType(actual, expected))
				.as("Expected content type '" + expected + "' but was '" + actual.contentType + "'")
				.isTrue();
		return (T) this;
	}

	public HtmlResponseAssert isHtml() {
		hasContentType("text/html");
		return new HtmlResponseAssert(actual);
	}

	public T isEncoded(String encoding) {
		Assertions.assertThat(actual.encoding).isEqualToIgnoringCase(encoding);
		return (T) this;
	}

	public T isUtf8() {
		return isEncoded("utf-8");
	}

	public T contains(String expected) {
		Assertions.assertThat(readContent()).contains(expected);
		return (T) this;
	}

	protected String readContent() {
		try {
			return new String(actual.out.toByteArray(), actual.encoding);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

}
