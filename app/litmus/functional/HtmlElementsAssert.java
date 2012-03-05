package litmus.functional;

import org.fest.assertions.GenericAssert;
import org.jsoup.select.Elements;

public class HtmlElementsAssert extends GenericAssert<HtmlElementsAssert, Elements> {

	protected HtmlElementsAssert(Elements actual) {
		super(HtmlElementsAssert.class, actual);
	}

}
