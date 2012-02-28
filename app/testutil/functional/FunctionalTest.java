package testutil.functional;

import play.mvc.Http;

import java.util.Map;

import static testutil.util.ReflectionUtil.getStaticFieldValue;


public abstract class FunctionalTest extends FestAssertFunctionalTest {

	public static Response get(Object url) {
		return wrapResponse(GET(url));
	}

	public static Response getAndFollowRedirect(Object url) {
		return wrapResponse(GET(url, true));
	}

	public static Response post(Object url) {
		return wrapResponse(POST(url));
	}

	// TODO: add other post, put, head and delete methods

	private static Response wrapResponse(Http.Response get) {
		return new Response(get, getRenderArgs());
	}

	private static Map<String, Object> getRenderArgs() {
		return getStaticFieldValue("renderArgs", play.test.FunctionalTest.class);
	}


}
