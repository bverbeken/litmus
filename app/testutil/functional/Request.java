package testutil.functional;

import play.mvc.Http;
import play.mvc.Scope;

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
		Http.Response response = POST(url, params);
		Map<String, Object> renderArgs = Scope.RenderArgs.current().data;
		return new Response(response, renderArgs);
	}

	public Response get() {
		Http.Response response = GET(url);
		Map<String, Object> renderArgs = Scope.RenderArgs.current().data;
		return new Response(response, renderArgs);
	}

}
