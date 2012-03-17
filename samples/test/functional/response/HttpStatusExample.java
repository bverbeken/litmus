package functional.response;

import org.junit.Test;
import litmus.functional.FunctionalTest;

public class HttpStatusExample extends FunctionalTest {

	@Test
	public void statusOk() {
		assertThat(get("/response/ok")).isOk();
		assertThat(get("/response/ok")).isStatus(200);
	}

	@Test
	public void isSuccess() {
		assertThat(get("/response/ok")).isSuccess();
		assertThat(get("/response/ok")).isNoError();
		assertThat(get("/response/ok")).isNoRedirect();
	}

	@Test
	public void statusNotFound() {
		assertThat(get("/response/notFound")).isNotFound();
	}

	@Test
	public void statusForbidden() {
		assertThat(get("/response/forbidden")).isForbidden();
	}

	@Test
	public void anyError() {
		assertThat(get("/response/notFound")).isError();
		assertThat(get("/response/forbidden")).isError();

		assertThat(get("/response/notFound")).isNoSuccess();
		assertThat(get("/response/notFound")).isNoRedirect();
	}

	@Test
	public void isRedirect() {
		assertThat(get("/response/redirect")).isRedirect();
		assertThat(get("/response/redirect")).isNoSuccess();
		assertThat(get("/response/redirect")).isNoError();
	}

	@Test
	public void isRedirectTo() {
		assertThat(get("/response/redirect")).isRedirectTo("/response/redirectTo");
	}

	@Test
	public void isRedirectToIsCaseInsensitive() {
		assertThat(get("/response/redirect")).isRedirectTo("/response/rEdIrEcTtO");
	}

}
