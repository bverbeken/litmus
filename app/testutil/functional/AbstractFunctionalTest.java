package testutil.functional;

import play.test.FunctionalTest;
import testutil.util.RequestBuilder;

import static play.mvc.Http.Response;
import static testutil.util.ResponseContentTypeUtil.isHtml;

public abstract class AbstractFunctionalTest extends FunctionalTest {

	protected ResponseAssert assertThat(Response response) {
		if (isHtml(response)) {
			return new HtmlResponseAssert(response);
		} else {
			return new ResponseAssert(response);
		}
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

}
