package testutil.functional.html;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import testutil.functional.html.exception.CannotInitializePageException;
import testutil.functional.html.exception.ElementNotFoundException;

import static org.jsoup.Jsoup.parse;
import static play.Play.configuration;
import static play.mvc.Http.Response;
import static play.test.FunctionalTest.GET;
import static testutil.PlayAssertions.assertThat;
import static testutil.functional.response.ResponseContentReader.readContent;

public class HtmlPage {

	private Response response;
	private Document doc;

	public HtmlPage(String url) {
		initAndVerifyResponse(url);
		initDocument(response);
	}

	private void initAndVerifyResponse(String url) {
		try {
			this.response = GET(url);
			assertThat(response).isOk().isHtml();
		} catch (Exception e) {
			throw new CannotInitializePageException("Could not initialize page. Did you provide the correct url ('" + url + "'), and is it declared in your routes file?", e);
		}
	}

	private void initDocument(Response response) {
		String baseUrl = configuration.getProperty("application.baseUrl");
		if (baseUrl == null) {
			throw new CannotInitializePageException("Please specify the application.baseUrl property in your application.conf!");
		} else {
			this.doc = parse(readContent(response), baseUrl);
		}
	}

	protected Response getResponse() {
		return response;
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
}
