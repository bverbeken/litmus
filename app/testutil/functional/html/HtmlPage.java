package testutil.functional.html;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import testutil.functional.html.exception.ElementNotFoundException;
import testutil.util.RequestBuilder;

import static org.jsoup.Jsoup.parse;
import static play.Play.configuration;
import static play.mvc.Http.Response;
import static testutil.PlayAssertions.assertThat;
import static testutil.functional.response.ResponseContentReader.readContent;

public class HtmlPage {

	private Response response;
	private Document doc;

	public HtmlPage(Response response) {
		this.response = response;
		assertThat(response).isOk().isHtml();
		initDocument(response);
	}

	private void initDocument(Response response) {
		if (configuration.getProperty("application.baseUrl") == null) {
			throw new IllegalStateException("Please specify the application.baseUrl property in your application.conf!");
		} else {
			this.doc = parse(readContent(response), configuration.getProperty("application.baseUrl"));
		}
	}

	protected Response getResponse() {
		return response;
	}

	public String getMeta(String name) {
		return doc.head().getElementsByTag("meta").select("[name=" + name + "]").first().attr("content");
	}


	public String getTitle() {
		return doc.title();
	}

	protected Element findById(String id) {
		Element element = doc.getElementById(id);
		if (element == null) {
			throw new ElementNotFoundException("Unable to find element by id '" + id + "'");
		}
		return element;
	}


	protected static Response GET(String url) {
		return new RequestBuilder(url).get();
	}

	// TODO add other Http methods from FunctionalTest here (GET, PUT, POST, DELETE)
}
