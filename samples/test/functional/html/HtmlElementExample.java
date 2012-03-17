package functional.html;

import litmus.functional.FunctionalTest;
import litmus.functional.WrongContentTypeException;
import org.jsoup.nodes.Element;
import org.junit.Test;

public class HtmlElementExample extends FunctionalTest {

	public static final String PATH = "/html/aPage";

	@Test
	public void containsText() {
		Element actual = getHtml(PATH).selectSingle("#myDiv");
		assertThat(actual).containsText("This");
		assertThat(actual).containsText("is");
		assertThat(actual).containsText("myDiv");
		assertThat(actual).containsText("This is myDiv");
		assertThat(actual).containsTextIgnoringCase("tHiS iS mYdIv");
	}

	@Test
	public void hasClass() {
		Element actual = getHtml(PATH).selectSingle("#myDiv");
		assertThat(actual).hasClass("class1").hasClass("class2");
		assertThat(actual).hasClass("class1 class2"); // but here the order is important!
	}

	@Test
	public void hasNoClasses() {
		Element actual = getHtml(PATH).selectSingle("#myDiv");
		assertThat(actual).hasNoClass("aClass");
	}

	@Test
	public void elementThatHasNoClassAtAll() {
		Element actual = getHtml(PATH).selectSingle("ul");
		assertThat(actual).hasNoClass();
	}

	@Test
	public void hasAttribute() {
		Element actual = getHtml(PATH).selectSingle("#myDiv");
		assertThat(actual).hasAttribute("title");
	}

	@Test
	public void hasAttributeValue() {
		Element actual = getHtml(PATH).selectSingle("#myDiv");
		assertThat(actual).hasAttributeValue("title", "myDiv title");
	}

	@Test
	public void hasNoAttribute() {
		Element actual = getHtml(PATH).selectSingle("#myDiv");
		assertThat(actual).hasNoAttribute("unexistingAttr");
	}

	@Test
	public void containsMessage(){
		Element actual = getHtml(PATH).selectSingle("#divWithMessage");
		assertThat(actual).containsMessage("this.is.a.message.key");
	}


	@Test
	public void containsMessageWithArgs(){
		Element actual = getHtml(PATH).selectSingle("#divWithMessageWithArgs");
		assertThat(actual).containsMessage("this.is.a.message.key.with.args", "argValue1", "argValue2");
	}

	@Test
	public void getHtmlThrowsExceptionIfContentTypeIsNotOk() {
		try {
			getHtml("/contentTypes/text");
			fail();
		} catch (WrongContentTypeException e) {
			assertThat(e).hasMessage("Expected to find contentType text/html but was text/plain [Request: GET /contentTypes/text]");
		}
	}
}
