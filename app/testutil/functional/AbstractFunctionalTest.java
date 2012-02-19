package testutil.functional;

import play.test.FunctionalTest;
import testutil.PlayAssertions;
import testutil.functional.html.HtmlPage;
import testutil.functional.html.HtmlPageAssert;
import testutil.functional.response.ResponseAssert;
import testutil.util.RequestBuilder;

import static play.mvc.Http.Response;

public abstract class AbstractFunctionalTest extends FunctionalTest {

	protected ResponseAssert assertThat(Response response) {
		return PlayAssertions.assertThat(response);
	}

	protected HtmlPageAssert assertThat(HtmlPage htmlPage) {
		return PlayAssertions.assertThat(htmlPage);
	}

	public void logout() {
		GET("/logout");
	}

	protected Response login(String username, String password) {
		return new RequestBuilder()
				.withUrl("/login")
				.withParam("username", username)
				.withParam("password", password)
				.post();

	}

	protected HtmlPage getHtml(String url) {
		return new HtmlPage(GET(url));
	}

}
