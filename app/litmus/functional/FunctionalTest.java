package litmus.functional;

public abstract class FunctionalTest extends FestAssertFunctionalTest {

	protected static Response get(Object url) {
		return new Request(url).get();
	}


	protected static Html getHtml(Object url) {
		return get(url).getHtml();
	}

	protected Response login(String username, String password) {
		// TODO: check whether Secure module is available
		return new Request("/login")
				.with("username", username)
				.with("password", password)
				.post();
	}

	protected void logout() {
		// TODO: check whether Secure module is available
		clearCookies();
	}


	// TODO: add post, put, head and delete methods

}
