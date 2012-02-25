package testutil.functional;

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;
import play.Play;
import play.mvc.Http;
import testutil.PlayAssertions;
import testutil.functional.response.ResponseContentTypeUtil;

import java.io.UnsupportedEncodingException;

import static java.lang.String.format;
import static java.net.URLEncoder.encode;
import static org.fest.assertions.Assertions.assertThat;
import static play.mvc.Http.StatusCode.*;

@SuppressWarnings("unchecked")
public abstract class AbstractFunctionalAssert<SelfType extends AbstractFunctionalAssert, ActualType> extends GenericAssert<SelfType, ActualType> {

	private Response response;

	protected AbstractFunctionalAssert(Class<SelfType> selfType, ActualType actual, Response response) {
		super(selfType, actual);
		this.response = response;
	}

	public SelfType isStatus(int httpStatusCode) {
		assertThat(response.getStatus()).isEqualTo(httpStatusCode);
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
	
	public SelfType isRedirect(){
		assertThat(response.getStatus()).isGreaterThanOrEqualTo(300).isLessThan(400);
		return (SelfType) this;
	}

	public SelfType isRedirectTo(String location) {
		isRedirect();
		hasHeaderIgnoringCase("location", location);
		return (SelfType) this;
	}

	public SelfType hasHeader(String headerName, String headerValue) {
		assertThat(response.getHeader(headerName)).isEqualTo(headerValue);
		return (SelfType) this;
	}

	public SelfType hasHeaderIgnoringCase(String headerName, String headerValue) {
		assertThat(response.getHeader(headerName)).isEqualToIgnoringCase(headerValue);
		return (SelfType) this;
	}

	public SelfType hasContentType(String expected) {
		assertThat(ResponseContentTypeUtil.hasContentType(response, expected))
				.as("Expected content type '" + expected + "' but was '" + response.getContentType() + "'")
				.isTrue();
		return (SelfType) this;
	}

	public SelfType isHtml() {
		return hasContentType("text/html");
	}

	public SelfType isEncoded(String encoding) {
		assertThat(response.getEncoding()).isEqualToIgnoringCase(encoding);
		return (SelfType) this;
	}

	public SelfType isUtf8() {
		return isEncoded("utf-8");
	}

	public SelfType contentContains(String expected) {
		assertThat(response.getContent()).contains(expected);
		return (SelfType) this;
	}

	// TODO move this to Response
	private static final String FLASH_COOKIE_NAME = Play.configuration.getProperty("application.session.cookie", "PLAY") + "_FLASH";

	// TODO move this to Response
	private String buildFlashCookie(String key, String value) {
		try {
			return encode(format("\u0000%s:%s\u0000", key, value), "utf-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	public SelfType hasFlashVariable(String name, String bar) {
		PlayAssertions.assertThat(response.getCookieValue(FLASH_COOKIE_NAME)).contains(buildFlashCookie(name, bar));
		return (SelfType) this;
	}

	public SelfType hasCookie(String cookieName) {
		Http.Cookie cookie = response.getCookie(cookieName);
		Assertions.assertThat(cookie).describedAs(String.format("cookie [%s] not found", cookieName)).isNotNull();
		return (SelfType) this;
	}

	public SelfType hasNoCookie(String cookieName) {
		Assertions.assertThat(response.getCookie(cookieName)).isNull();
		return (SelfType) this;
	}


	public SelfType hasRenderArg(String argName) {
		Assertions.assertThat(response.getRenderArgs().keySet()).contains(argName);
		return (SelfType) this;
	}


}
