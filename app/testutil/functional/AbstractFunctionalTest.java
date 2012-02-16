package testutil.functional;

import play.test.FunctionalTest;

import static play.mvc.Http.Response;

public abstract class AbstractFunctionalTest extends FunctionalTest {
	
	protected ResponseAssert assertThat(Response response){
		return new ResponseAssert(response);
	}

    public void logout() {
        GET("/logout");
    }

	protected Response login(String username, String password){
		return new RequestBuilder()
				.withUrl("/login")
				.withParam("username", username)
				.withParam("password", password)
				.post();

	}
	
}
