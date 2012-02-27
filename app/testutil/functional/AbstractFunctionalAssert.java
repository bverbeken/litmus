package testutil.functional;

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;
import play.mvc.Http;
import testutil.PlayAssertions;

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

	public SelfType isSuccess() {
		assertThat(response.isSuccess()).isTrue();
		return (SelfType) this;
	}

	public SelfType isNoSuccess() {
		assertThat(response.isSuccess()).isFalse();
		return (SelfType) this;
	}

	public SelfType isError() {
		assertThat(response.isError()).isTrue();
		return (SelfType) this;
	}

	public SelfType isNoError() {
		assertThat(response.isError()).isFalse();
		return (SelfType) this;
	}


	public SelfType isRedirect() {
		assertThat(response.isRedirect()).isTrue();
		return (SelfType) this;
	}


	public SelfType isNoRedirect() {
		assertThat(response.isRedirect()).isFalse();
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


	public SelfType isRedirectTo(String location) {
		isRedirect();
		hasHeaderIgnoringCase("location", location);
		return (SelfType) this;
	}

	public SelfType hasHeaderIgnoringCase(String headerName, String headerValue) {
		assertThat(response.getHeader(headerName)).isEqualToIgnoringCase(headerValue);
		return (SelfType) this;
	}

	public SelfType hasContentType(String expected) {
		assertThat(response.getContentType())
				.as("Expected content type '" + expected + "' but was '" + response.getContentType() + "'")
				.startsWith(expected);

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

	public SelfType hasFlashParam(String name, String value) {
		PlayAssertions.assertThat(response.getFlashParam(name)).isEqualTo(value);
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
