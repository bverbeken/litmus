package functional.html;

import litmus.functional.*;
import org.junit.Test;

public class HtmlTest extends FunctionalTest {

	@Test
	public void getHtmlThrowsExceptionIfContentTypeIsNotOk() {
		try {
			Response actual = get("/contentTypes/text");
			actual.getHtml();
			fail();
		} catch (WrongContentTypeException e) {
			assertThat(e).hasMessage("Expected to find contentType text/html but was text/plain [Request: GET /contentTypes/text]");
		}
	}

	@Test
	public void getSingleThrowsExceptionIfMoreThanOneElementFound() {
		try {
			Html actual = getHtml("/html/aPage");
			actual.selectSingle("li");
			fail("expected exception!");
		} catch (WrongSelectorException e) {
			assertThat(e).hasMessage("more than one element found for selector [li]");
		}
	}

	@Test
	public void getSingleThrowsExceptionIfNoElementFound() {
		try {
			Html actual = getHtml("/html/aPage");
			actual.selectSingle("#selectorWithNoResults");
			fail("expected exception!");
		} catch (WrongSelectorException e) {
			assertThat(e).hasMessage("no element found for selector [#selectorWithNoResults]");
		}
	}

}
