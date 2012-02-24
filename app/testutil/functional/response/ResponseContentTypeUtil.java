package testutil.functional.response;


import testutil.functional.Response;

public class ResponseContentTypeUtil {

	// TODO: move this method to Response
	public static boolean hasContentType(Response response, String contentType) {
		if (response.getContentType() == null) {
			return false;
		}
		return response.getContentType().startsWith(contentType);
	}
}
