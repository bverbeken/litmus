package testutil.functional;

import org.fest.assertions.GenericAssert;
import play.Play;
import testutil.PlayAssertions;
import testutil.functional.response.ResponseContentTypeUtil;

import java.io.UnsupportedEncodingException;

import static java.lang.String.format;
import static java.net.URLEncoder.encode;
import static org.fest.assertions.Assertions.assertThat;
import static play.mvc.Http.Response;
import static play.mvc.Http.StatusCode.*;
import static testutil.functional.response.ResponseContentReader.readContent;

@SuppressWarnings("unchecked")
public abstract class AbstractFunctionalAssert<SelfType extends AbstractFunctionalAssert, ActualType> extends GenericAssert<SelfType, ActualType>{

	private Response response;

	protected AbstractFunctionalAssert(Class<SelfType> selfType, ActualType actual, Response response) {
		super(selfType, actual);
		this.response = response;
	}

	public SelfType isStatus(int httpStatusCode) {
		assertThat(response.status).isEqualTo(httpStatusCode);
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
		assertThat(response.getHeader(headerName)).isEqualTo(headerValue);
		return (SelfType) this;
	}

	public SelfType hasContentType(String expected) {
		assertThat(ResponseContentTypeUtil.hasContentType(response, expected))
				.as("Expected content type '" + expected + "' but was '" + response.contentType + "'")
				.isTrue();
		return (SelfType) this;
	}

	public SelfType isHtml() {
		return hasContentType("text/html");
	}

	public SelfType isEncoded(String encoding) {
		assertThat(response.encoding).isEqualToIgnoringCase(encoding);
		return (SelfType) this;
	}

	public SelfType isUtf8() {
		return isEncoded("utf-8");
	}

	public SelfType contentContains(String expected) {
		assertThat(readContent(response)).contains(expected);
		return (SelfType) this;
	}

	private static final String FLASH_COOKIE_NAME = Play.configuration.getProperty("application.session.cookie", "PLAY") + "_FLASH";


	private String buildFlashCookie(String key, String value) {
		try {
			return encode(format("\u0000%s:%s\u0000", key, value), "utf-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	public SelfType hasFlashVariable(String name, String bar) {
		PlayAssertions.assertThat(response.cookies.get(FLASH_COOKIE_NAME).value).contains(buildFlashCookie(name, bar));
		return (SelfType) this;
	}





}
