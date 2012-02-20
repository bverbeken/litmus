package testutil.functional.html;

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;
import org.jsoup.nodes.Element;

public class HtmlElementAssert extends GenericAssert<HtmlElementAssert, Element> {

	public HtmlElementAssert(Element element) {
		super(HtmlElementAssert.class, element);
	}
	
	public HtmlElementAssert containsText(String text){
		Assertions.assertThat(actual.text()).contains(text);
		return this; 
	}

}
