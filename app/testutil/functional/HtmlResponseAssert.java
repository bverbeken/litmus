package testutil.functional;

import static java.lang.String.format;
import static play.mvc.Http.Response;

public class HtmlResponseAssert extends ResponseAssert<HtmlResponseAssert> {

	public HtmlResponseAssert(Response response) {
		super(HtmlResponseAssert.class, response);
	}

	public HtmlResponseAssert hasMetaTag(String name, String content) {
		// TODO: use HtmlUsnit here? Or some html parser at least..
		contains(format("<meta name=\"%s\" content=\"%s\">", name, content));
		return this;
	}

}
