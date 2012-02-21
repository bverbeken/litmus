package testutil.functional;

import org.fest.assertions.Assertions;
import org.fest.assertions.BooleanAssert;
import org.fest.assertions.CollectionAssert;
import org.fest.assertions.StringAssert;
import play.test.FunctionalTest;
import testutil.PlayAssertions;
import testutil.functional.html.*;
import testutil.functional.html.tags.AbstractHtmlList;
import testutil.functional.html.tags.AbstractHtmlTag;
import testutil.functional.html.tags.Anchor;
import testutil.functional.response.ResponseAssert;
import testutil.util.RequestBuilder;

import java.util.Collection;

import static play.mvc.Http.Response;

public abstract class AbstractFunctionalTest extends FunctionalTest {

	public void logout() {
		GET("/logout");
	}

	protected Response login(String username, String password) {
		return new RequestBuilder("/login")
				.withParam("username", username)
				.withParam("password", password)
				.post();
	}

	protected HtmlPage getHtml(String url) {
		return new HtmlPage(GET(url));
	}

	protected ResponseAssert assertThat(Response response) {
		return PlayAssertions.assertThat(response);
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
	
	protected BooleanAssert assertThat(boolean b){
		return Assertions.assertThat(b);
	}


}
