package testutil.functional;

import org.fest.assertions.Assertions;
import org.fest.assertions.StringAssert;
import play.test.FunctionalTest;
import testutil.functional.html.*;
import testutil.functional.response.ResponseAssert;
import testutil.util.RequestBuilder;

import static play.mvc.Http.Response;

public abstract class AbstractFunctionalTest extends FunctionalTest {	

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

	protected ResponseAssert assertThat(Response response) {
		return new ResponseAssert(response);
	}

	protected HtmlPageAssert assertThat(HtmlPage htmlPage) {
		return new HtmlPageAssert(htmlPage);
	}

	protected HtmlElementAssert assertThat(HtmlElement tag){
		return new HtmlElementAssert(tag);
	}

	protected StringAssert assertThat(String string){
		return Assertions.assertThat(string);
	}



}
