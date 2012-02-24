package testutil.functional;

import play.mvc.Http;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class Response {

	private final Http.Response wrappedResponse;
	private Map<String, Object> renderArgs;

	public Response(Http.Response wrappedResponse, Map<String, Object> renderArgs){
		this.wrappedResponse = wrappedResponse;
		this.renderArgs = renderArgs;
	}

	public Integer getStatus() {
		return wrappedResponse.status;
	}

	public String getHeader(String name) {
		return wrappedResponse.getHeader(name);
	}

	public String getContentType() {
		return  wrappedResponse.contentType;
	}

	public String getEncoding(){
		return wrappedResponse.encoding;
	}

	public String getContent() {
		try {
			return new String(wrappedResponse.out.toByteArray(), wrappedResponse.encoding);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Failed to read content from response", e);
		}
	}
	
	public Http.Cookie getCookie(String name){
		return wrappedResponse.cookies.get(name);
	}
	
	public String getCookieValue(String name){
		return getCookie(name).value;
	}

	public Map<String, Object> getRenderArgs() {
		return renderArgs;
	}
}
