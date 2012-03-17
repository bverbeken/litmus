package functional.security;

import litmus.functional.FunctionalTest;
import org.junit.Test;

public class AuthenticationExample extends FunctionalTest {

	@Test
	public void unsecuredPageIsAccessibleWithoutLoggingIn() {
		assertThat(get("/html/helloWorld")).isOk();
	}

	@Test
	public void securedPageIsRedirectToLoginIfNotLoggedIn() {
		assertThat(get("/security/secured")).isRedirectTo("/login");
	}


	@Test
	public void securedPageIsAccessibleWhenLoggedIn() {
		login("user1", "secret");
		assertThat(get("/security/secured")).isOk();
	}

	@Test
	public void logoutLogsOut() {
		login("user", "secret");
		assertThat(get("/security/secured")).isOk();
		logout();
		assertThat(get("/security/secured")).isRedirectTo("/login");
	}

}
