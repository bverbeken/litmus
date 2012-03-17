package functional.text;

import org.junit.Test;
import litmus.functional.FunctionalTest;
import litmus.functional.WrongContentTypeException;

public class TextResponseExample extends FunctionalTest {

	@Test
	public void contains() {
		assertThat(get("/contentTypes/text").getContent()).contains("Hello World");
		assertThat(get("/contentTypes/text").getText()).contains("Hello World");
	}

	@Test
	public void getTextThrowsExceptionIfContentTypeIsNotOk() {
		try {
			get("/contentTypes/html").getText();
			fail();
		} catch (WrongContentTypeException e) {
			assertThat(e).hasMessage("Expected to find contentType text/plain but was text/html [Request: GET /contentTypes/html]");
		}
	}

}
