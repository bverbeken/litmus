package testutil.functional.html;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import static org.jsoup.Jsoup.parse;
import static play.Play.configuration;
import static play.mvc.Http.Response;
import static testutil.functional.response.ResponseContentReader.readContent;

public class HtmlPage {

	private Response response;
	private Document doc;

	public HtmlPage(Response response) {
		this.response = response;
		this.doc = parse(readContent(response), configuration.getProperty("application.baseUrl"));
	}

	public Response getResponse() {
		return response;
	}
	
	public String getMeta(String name){
		return doc.head().getElementsByTag("meta").select("[name=" + name + "]").first().attr("content");
	}

	public Element findById(String id) {
		return doc.getElementById(id);
	}
}
