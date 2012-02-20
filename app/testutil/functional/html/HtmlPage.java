package testutil.functional.html;

import org.jsoup.nodes.Document;

import static org.jsoup.Jsoup.parse;
import static play.mvc.Http.Response;
import static testutil.functional.response.ResponseContentReader.readContent;

public class HtmlPage {

	private Response response;
	private Document doc;

	public HtmlPage(Response response) {
		this.response = response;
		this.doc = parse(readContent(response), "TODO://find.out.base.url");
	}

	public Response getResponse() {
		return response;
	}
	
	public String getMetaTag(String name){
		return doc.head().getElementsByTag("meta").select("[name=" + name + "]").first().attr("content");
	}
}
