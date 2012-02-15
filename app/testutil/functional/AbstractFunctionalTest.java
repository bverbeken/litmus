package testutil.functional;

import play.mvc.Http;
import play.test.FunctionalTest;

public abstract class AbstractFunctionalTest extends FunctionalTest {
	
	protected ResponseAssert assertThat(Http.Response response){
		return new ResponseAssert(response);
	}

    public void logout() {
        GET("/logout");
    }

	protected Http.Response login(String username, String password){
		return new RequestBuilder()
				.withUrl("/login")
				.withParam("username", username)
				.withParam("password", password)
				.post();

	}
	
}
