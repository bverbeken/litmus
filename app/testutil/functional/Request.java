package testutil.functional;

import java.util.HashMap;
import java.util.Map;

import static play.test.FunctionalTest.GET;
import static play.test.FunctionalTest.POST;

public class Request {

	private String url;
	private Map<String, String> params = new HashMap<String, String>();

	public Request(String url) {
		this.url = url;
	}

	public Request withParam(String name, String value) {
		this.params.put(name, value);
		return this;
	}

	public Response post() {
		return new Response(POST(url, params));
	}

	public Response get() {
		return new Response(GET(url));
	}

}
