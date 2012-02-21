package testutil.functional.response;

import static play.mvc.Http.Response;

@SuppressWarnings("ConstantConditions")
public class ResponseContentTypeUtil {

	public static boolean hasContentType(Response response, String contentType) {
		if (response.contentType == null) {
			return false;
		}
		return response.contentType.startsWith(contentType);
	}
}
