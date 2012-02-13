package testutil.functional;

import play.mvc.Http;
import play.test.FunctionalTest;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractFunctionalTest extends FunctionalTest {
	
	protected ResponseAssert assertThat(Http.Response response){
		return new ResponseAssert(response);
	}

    public void logout() {
        GET("/logout");
    }

	protected ResponseAssert login(String username, String password){
		Map<String, String> loginUserParams = new HashMap<String, String>();
		loginUserParams.put("username", username);
		loginUserParams.put("password", password);
		return new ResponseAssert(POST("/login", loginUserParams));
	}
	
}
