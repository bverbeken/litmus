package testutil.functional.response;

import play.mvc.Http;

import java.io.UnsupportedEncodingException;

public class ResponseContentReader {
	
	public static String readContent(Http.Response response){
		try {
			return new String(response.out.toByteArray(), response.encoding);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
}
