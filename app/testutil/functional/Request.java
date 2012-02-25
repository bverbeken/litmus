package testutil.functional;

import play.mvc.Http;
import play.mvc.Scope;

import java.util.Map;

import static play.test.FunctionalTest.GET;

public class Request {

	private String url;

	public Request(String url) {
		this.url = url;
	}

	public Response get() {
		Http.Response response = GET(url);
		Map<String, Object> renderArgs = Scope.RenderArgs.current().data;
		return new Response(response, renderArgs);
	}

}
