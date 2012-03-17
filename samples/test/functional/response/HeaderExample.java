package functional.response;

import org.junit.Test;
import litmus.functional.FunctionalTest;

public class HeaderExample extends FunctionalTest {

	@Test
	public void hasHeader() {
		assertThat(get("/headers/foo")).hasHeader("foo");
	}

	@Test
	public void hasHeaderIsCaseInsensitive() {
		assertThat(get("/headers/foo")).hasHeader("foo");
		assertThat(get("/headers/foo")).hasHeader("FOO");
		assertThat(get("/headers/foo")).hasHeader("fOo");
	}

	@Test
	public void hasHeaderValue() {
		assertThat(get("/headers/foo")).hasHeaderValue("foo", "bar");
	}


	@Test
	public void hasHeaderValueIsCaseInsensitive() {
		assertThat(get("/headers/foo")).hasHeaderValue("foo", "bar");
		assertThat(get("/headers/foo")).hasHeaderValue("foo", "BAR");
		assertThat(get("/headers/foo")).hasHeaderValue("foo", "bAr");
	}


	@Test
	public void hasNoHeader() {
		assertThat(get("/headers/foo")).hasNoHeader("anUnexistingHeaderName");
	}
}
