package testutil.functional;

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;
import testutil.functional.html.HtmlPage;
import testutil.functional.html.HtmlPageAssert;
import testutil.util.ResponseContentTypeUtil;

import java.io.UnsupportedEncodingException;

import static play.mvc.Http.Response;
import static play.mvc.Http.StatusCode.*;

@SuppressWarnings("unchecked")
public abstract class AbstractFunctionalAssert<SelfType extends AbstractFunctionalAssert, ActualType> extends GenericAssert<SelfType, ActualType>{

	private Response response;

	protected AbstractFunctionalAssert(Class<SelfType> selfType, ActualType actual, Response response) {
		super(selfType, actual);
		this.response = response;
	}

	@SuppressWarnings("unchecked")
	public SelfType isStatus(int httpStatusCode) {
		Assertions.assertThat(response.status).isEqualTo(httpStatusCode);
		return (SelfType) this;
	}

	public SelfType isOk() {
		return isStatus(OK);
	}

	public SelfType isNotFound() {
		return isStatus(NOT_FOUND);
	}

	public SelfType isForbidden() {
		return isStatus(FORBIDDEN);
	}

	public SelfType redirectsTo(String location) {
		isStatus(FOUND);
		hasHeader("location", location);
		return (SelfType) this;
	}

	public SelfType hasHeader(String headerName, String headerValue) {
		Assertions.assertThat(response.getHeader(headerName)).isEqualTo(headerValue);
		return (SelfType) this;
	}

	public SelfType hasContentType(String expected) {
		Assertions.assertThat(ResponseContentTypeUtil.hasContentType(response, expected))
				.as("Expected content type '" + expected + "' but was '" + response.contentType + "'")
				.isTrue();
		return (SelfType) this;
	}

	public HtmlPageAssert isHtml() {
		hasContentType("text/html");
		return new HtmlPageAssert(new HtmlPage(response));
	}

	public SelfType isEncoded(String encoding) {
		Assertions.assertThat(response.encoding).isEqualToIgnoringCase(encoding);
		return (SelfType) this;
	}

	public SelfType isUtf8() {
		return isEncoded("utf-8");
	}

	public SelfType contentContains(String expected) {
		Assertions.assertThat(readContent()).contains(expected);
		return (SelfType) this;
	}

	protected String readContent() {
		try {
			return new String(response.out.toByteArray(), response.encoding);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}



}
