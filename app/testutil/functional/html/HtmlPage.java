package testutil.functional.html;

import play.mvc.Http;

public class HtmlPage {

	Http.Response response;

	public HtmlPage(Http.Response response) {
		this.response = response;
	}

}
