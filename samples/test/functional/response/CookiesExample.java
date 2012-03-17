package functional.response;

import litmus.functional.FunctionalTest;
import litmus.functional.Response;
import org.junit.Test;

import static play.mvc.Http.Cookie;

public class CookiesExample extends FunctionalTest {

	@Test
	public void hasCookie() {
		Response response = get("/cookies/foo");
		assertThat(response).hasCookie("foo");
	}

	@Test
	public void hasCookieWithValue() {
		Response response = get("/cookies/foo");
		assertThat(response).hasCookieValue("foo", "bar");
	}

	@Test
	public void doesntHaveCookie() {
		Response response = get("/cookies/foo");
		assertThat(response).hasNoCookie("unexistingCookie");
	}


	@Test
	public void simpleCookie() {
		Cookie cookie = get("/cookies/foo").getCookie("foo");
		assertThat(cookie).hasName("foo");
		assertThat(cookie).hasDomain("localhost");
		assertThat(cookie).hasValue("bar");
		assertThat(cookie).hasMaxAge(3600);
	}

	@Test
	public void insecureCookie() {
		assertThat(get("/cookies/insecure").getCookie("insecure")).isInsecure();
	}

	@Test
	public void secureCookie() {
		assertThat(get("/cookies/secure").getCookie("secure")).isSecure();
	}

	@Test
	public void assertThatWithUnexistingCookieDoesntFailWithNullpointer() {
		assertThat(get("/cookies/foo").getCookie("unexisting")).isNull();
	}


}
