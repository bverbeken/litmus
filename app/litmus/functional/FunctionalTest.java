package litmus.functional;

import play.mvc.Http;

import java.util.Map;

import static litmus.functional.HttpMethod.GET;
import static litmus.functional.HttpMethod.POST;
import static litmus.util.PlayExceptionUtil.tryToFindNotFound;
import static litmus.util.ReflectionUtil.getStaticFieldValue;


public abstract class FunctionalTest extends FestAssertFunctionalTest {

	protected static Response get(Object url) {
		try {
			return wrapResponse(GET, url, GET(url));
		} catch (Exception e) {
			throw tryToFindNotFound(e);
		}
	}
	
	protected static Html getHtml(Object url){
		return get(url).getHtml();
	}

	protected static Response getAndFollowRedirect(Object url) {
		return wrapResponse(GET, url, GET(url, true));
	}

	protected static Response post(Object url) {
		return wrapResponse(POST, url, POST(url));
	}

	// TODO: add other post, put, head and delete methods

	private static Response wrapResponse(HttpMethod httpMethod, Object request, Http.Response response) {
		return new Response(httpMethod, request, response, getRenderArgs());
	}

	private static Map<String, Object> getRenderArgs() {
		return getStaticFieldValue("renderArgs", play.test.FunctionalTest.class);
	}


}
