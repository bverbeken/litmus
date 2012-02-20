package testutil.functional.html;

import com.google.common.base.Function;
import org.jsoup.nodes.Element;
import testutil.functional.html.tags.LI;

import java.util.List;

import static com.google.common.collect.Lists.transform;

public abstract class AbstractHtmlTag {

	protected Element element;

	public AbstractHtmlTag(Element element) {
		this.element = element;
	}

	public String getText() {
		return element.text();
	}

	protected abstract String getTagName();

	public List<String> getTextFromItems() {
		return transform(element.children(), new Function<Element, String>() {
			public String apply(Element element) {
				return element.text();
			}
		});
	}

	public List<LI> getItems() {
		return transform(element.children(), new Function<Element, LI>() {
			public LI apply(Element element) {
				return new LI(element);
			}
		});
	}
}
