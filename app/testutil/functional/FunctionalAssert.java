package testutil.functional;

import play.mvc.Http;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.internal.matchers.StringContains.containsString;
import static play.mvc.Http.StatusCode.*;

public class FunctionalAssert {

	private Http.Response response;

	public FunctionalAssert(Http.Response response) {
		this.response = response; 
	}

	public FunctionalAssert isStatus(int httpStatusCode) {
		assertThat("Wrong http status code ", response.status, equalTo(httpStatusCode));
		return this;
	}
	
	public FunctionalAssert isOk(){
		return isStatus(OK);
	}
	
	public FunctionalAssert isNotFound(){
		return isStatus(NOT_FOUND);
	}

	public FunctionalAssert isForbidden() {
		return isStatus(FORBIDDEN);
	}

	public FunctionalAssert redirectsTo(String location) {
		return isStatus(FOUND).hasHeader("location", location);
	}

	private FunctionalAssert hasHeader(String headerName, String headerValue) {
		assertThat("Wrong header value for ["+ headerName+ "]", response.getHeader(headerName), equalTo(headerValue));
		return this;
	}


	public FunctionalAssert hasContentType(String contentType) {
		assertThat("Wrong contentType", response.contentType, containsString(contentType));
		return this;
	}

	public FunctionalAssert isHtml(){
		return hasContentType("text/html");
	}

	public FunctionalAssert isEncoded(String encoding) {
		assertThat("Wrong encoding", response.encoding, equalTo(encoding));
		return this;
	}

	public FunctionalAssert isUtf8(){
		return isEncoded("utf-8");
	}
}
