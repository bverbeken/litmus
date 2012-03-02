package litmus.functional;

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;

import static play.mvc.Http.Cookie;

public class CookieAssert extends GenericAssert<CookieAssert, Cookie> {

	protected CookieAssert(Cookie actual) {
		super(CookieAssert.class, actual);
	}

	public CookieAssert hasName(String name) {
		Assertions.assertThat(actual.name).isEqualTo(name);
		return this;
	}

	public CookieAssert hasDomain(String domain) {
		Assertions.assertThat(actual.domain).isEqualTo(domain);
		return this;
	}

	public CookieAssert isSecure() {
		Assertions.assertThat(actual.secure).isTrue();
		return this;
	}

	public CookieAssert isInsecure() {
		Assertions.assertThat(actual.secure).isFalse();
		return this;
	}

	public CookieAssert hasValue(String value) {
		Assertions.assertThat(actual.value).isEqualTo(value);
		return this;
	}

	public CookieAssert hasMaxAge(Integer maxAge) {
		Assertions.assertThat(actual.maxAge).isEqualTo(maxAge);
		return this;
	}

}
