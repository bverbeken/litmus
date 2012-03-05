package litmus.functional;

import play.mvc.Http;
import play.mvc.results.Result;

import java.util.Map;

import static litmus.functional.HttpMethod.GET;
import static litmus.util.ReflectionUtil.getStaticFieldValue;

public class Request {

	private final Object url;

	public Request(Object url) {
		this.url = url;
	}

	public Response get() {
		return wrapResponse(GET, url, new ResponseFetcher() {
			Http.Response fetch() {
				return play.test.FunctionalTest.GET(url);
			}
		});
	}

	private static Response wrapResponse(HttpMethod httpMethod, Object request, ResponseFetcher fetcher) {
		Map<String, Object> renderArgs = getStaticFieldValue("renderArgs", play.test.FunctionalTest.class);
		return new Response(httpMethod, request, fetcher.fetchAndHandleException(), renderArgs);
	}

	private abstract static class ResponseFetcher {

		abstract Http.Response fetch();

		private Http.Response fetchAndHandleException() {
			try {
				return fetch();
			} catch (Exception e) {
				throw tryToFindNotFound(e);
			}
		}

		private static RuntimeException tryToFindNotFound(Throwable e) {
			if (e.getCause() != null) {
				if (e.getCause() instanceof Result) {
					return (RuntimeException) e.getCause();
				} else {
					return tryToFindNotFound(e.getCause());
				}
			} else {
				if (e instanceof RuntimeException) {
					return (RuntimeException) e;
				} else {
					return new RuntimeException(e);
				}
			}
		}
	}


}
