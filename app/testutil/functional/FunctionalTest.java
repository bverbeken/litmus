package testutil.functional;

import org.fest.assertions.BooleanAssert;
import org.fest.assertions.CollectionAssert;
import org.fest.assertions.ListAssert;
import org.fest.assertions.StringAssert;
import play.mvc.Http;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static testutil.util.ReflectionUtil.getStaticFieldValue;

public abstract class FunctionalTest extends play.test.FunctionalTest {

	protected ResponseAssert assertThat(Response response) {
		return FunctionalAssertions.assertThat(response);
	}

	protected CookieAssert assertThat(Http.Cookie cookie) {
		return FunctionalAssertions.assertThat(cookie);
	}

	protected StringAssert assertThat(String string) {
		return FunctionalAssertions.assertThat(string);
	}

	protected CollectionAssert assertThat(Collection<?> c) {
		return FunctionalAssertions.assertThat(c);
	}

	protected ListAssert assertThat(List<?> l) {
		return FunctionalAssertions.assertThat(l);
	}

	protected BooleanAssert assertThat(boolean b) {
		return FunctionalAssertions.assertThat(b);
	}


	public static Response get(Object url) {
		return new Response(play.test.FunctionalTest.GET(url), getRenderArgs());
	}

	private static Map<String, Object> getRenderArgs() {
		return getStaticFieldValue("renderArgs", play.test.FunctionalTest.class);
	}


}
