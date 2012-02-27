package testutil.functional;

import org.fest.assertions.*;
import play.mvc.Http;
import play.test.FunctionalTest;
import testutil.PlayAssertions;
import testutil.functional.cookie.CookieAssert;
import testutil.functional.html.*;
import testutil.functional.html.tags.AbstractHtmlList;
import testutil.functional.html.tags.AbstractHtmlTag;
import testutil.functional.html.tags.Anchor;
import testutil.functional.response.ResponseAssert;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static testutil.util.ReflectionUtil.getStaticFieldValue;

public abstract class AbstractFunctionalTest extends FunctionalTest {

	protected ResponseAssert assertThat(Response response) {
		return PlayAssertions.assertThat(response);
	}

	protected CookieAssert assertThat(Http.Cookie cookie) {
		return PlayAssertions.assertThat(cookie);
	}

	protected HtmlPageAssert assertThat(HtmlPage page) {
		return PlayAssertions.assertThat(page);
	}

	protected HtmlTagAssert assertThat(AbstractHtmlTag tag) {
		return PlayAssertions.assertThat(tag);
	}

	protected HtmlAnchorAssert assertThat(Anchor anchor) {
		return PlayAssertions.assertThat(anchor);
	}

	protected HtmlListAssert assertThat(AbstractHtmlList list) {
		return PlayAssertions.assertThat(list);
	}

	protected StringAssert assertThat(String string) {
		return Assertions.assertThat(string);
	}

	protected CollectionAssert assertThat(Collection<?> c) {
		return Assertions.assertThat(c);
	}

	protected ListAssert assertThat(List<?> l) {
		return Assertions.assertThat(l);
	}

	protected BooleanAssert assertThat(boolean b) {
		return Assertions.assertThat(b);
	}

	public static Response get(Object url) {
		return new Response(GET(url), getRenderArgs());
	}

	private static Map<String, Object> getRenderArgs() {
		return getStaticFieldValue("renderArgs", FunctionalTest.class);
	}


}
