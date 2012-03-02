package litmus.functional;

import static java.lang.String.format;

public class WrongContentTypeException extends RuntimeException {

	public WrongContentTypeException(String expectedContentType, String actualContentType, HttpMethod method, Object request) {
		super(format("Expected to find contentType %s but was %s [Request: %s %s]", expectedContentType, actualContentType, method, request));
	}

}
