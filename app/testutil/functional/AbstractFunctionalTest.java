package testutil.functional;

import org.junit.Before;
import play.mvc.Http;
import play.test.FunctionalTest;

import static play.mvc.Http.StatusCode.FORBIDDEN;

public abstract class AbstractFunctionalTest extends FunctionalTest {
	
	protected FunctionalAssert assertThat(Http.Response response){
		return new FunctionalAssert(response);
	}

    @Before
    public void logoutBeforeTest() {
        GET("/logout");
    }

	public static void assertIsForbidden(Http.Response response) {
		assertStatus(FORBIDDEN, response);
	}


}
