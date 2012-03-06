package litmus.functional;

public abstract class FunctionalTest extends FestAssertFunctionalTest {

	protected static Response get(Object url) {
		return new Request(url).get();
	}

	protected static Html getHtml(Object url) {
		return get(url).getHtml();
	}

	protected Response login(String userName, String password) {
		// TODO: check whether Secure module is available
		return new Request("/login")
				.with("username", userName)
				.with("password", password)
				.post();
	}


	// TODO: add post, put, head and delete methods

}
