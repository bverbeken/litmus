package functional.html;

import litmus.functional.FunctionalTest;
import org.junit.Test;

public class HtmlAssertExample extends FunctionalTest {

	public static final String PATH = "/html/aPage";

	@Test
	public void hasTitle() {
		assertThat(get(PATH).getHtml()).hasTitle("Home");
		assertThat(getHtml(PATH)).hasTitle("Home");
	}

	@Test
	public void titleContains() {
		assertThat(get(PATH).getHtml()).titleContains("H");
	}

	@Test
	public void titleMatches() {
		assertThat(get(PATH).getHtml()).titleMatches("H.*e");
	}

	@Test
	public void contains() {
		assertThat(getHtml(PATH)).containsElement("#myDiv");
		assertThat(getHtml(PATH)).contains("This is myDiv");
	}

	@Test
	public void doesNotContain() {
		assertThat(getHtml(PATH)).doesNotContainElement("#anUnexistingId");
	}


}
