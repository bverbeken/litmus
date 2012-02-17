package testutil.util;

import static com.google.common.base.Preconditions.checkArgument;
import static play.mvc.Http.Response;

@SuppressWarnings("ConstantConditions")
public class ResponseContentTypeUtil {

	public static boolean isHtml(Response response) {
		return hasContentType(response, "text/html");
	}


	public static boolean hasContentType(Response response, String contentType) {
		checkArgument(response != null, "Response should not be null");
		if (response.contentType == null) {
			return false;
		}
		return response.contentType.startsWith(contentType);
	}
}
