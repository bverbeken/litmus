package testutil.util;

import play.mvc.Http;

import java.util.HashMap;
import java.util.Map;

import static play.test.FunctionalTest.GET;
import static play.test.FunctionalTest.POST;

public class RequestBuilder {

	private String url;
	private Map<String, String> params = new HashMap<String, String>();

	public RequestBuilder(String url) {
		this.url = url;
	}

	public RequestBuilder withParam(String name, String value) {
		this.params.put(name, value);
		return this;
	}

	public Http.Response post() {
		return POST(url, params);
	}

	public Http.Response get() {
		return GET(url);
	}
}
