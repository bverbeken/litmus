package litmus.functional;

import play.mvc.Http;

import java.util.Map;

import static litmus.util.ReflectionUtil.getStaticFieldValue;


public abstract class FunctionalTest extends FestAssertFunctionalTest {

	public static Response get(Object url) {
		return wrapResponse("GET", url, GET(url));
	}

	public static Response getAndFollowRedirect(Object url) {
		return wrapResponse("GET", url, GET(url, true));
	}

	public static Response post(Object url) {
		return wrapResponse("POST", url, POST(url));
	}

	// TODO: add other post, put, head and delete methods

	private static Response wrapResponse(String httpMethod, Object request, Http.Response response ) {
		return new Response(httpMethod, request, response, getRenderArgs());
	}

	private static Map<String, Object> getRenderArgs() {
		return getStaticFieldValue("renderArgs", play.test.FunctionalTest.class);
	}


}
