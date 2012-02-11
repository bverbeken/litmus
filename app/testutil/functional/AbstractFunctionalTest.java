package testutil.functional;

import org.junit.Before;
import play.mvc.Http;
import play.test.FunctionalTest;

public abstract class AbstractFunctionalTest extends FunctionalTest {
	
	protected FunctionalAssert assertThat(Http.Response response){
		return new FunctionalAssert(response);
	}

    @Before
    public void logoutBeforeTest() {
        GET("/logout");
    }

}
