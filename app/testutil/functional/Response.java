package testutil.functional;

import play.mvc.Http;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.regex.Matcher;

import static com.google.common.collect.Maps.newHashMap;
import static java.net.URLDecoder.decode;
import static java.util.regex.Pattern.compile;
import static play.Play.configuration;
import static play.mvc.Http.StatusCode.*;
import static play.utils.HTTP.parseContentType;

@SuppressWarnings("unchecked")
public class Response {

	public static final String FLASH_COOKIE_NAME = configuration.getProperty("application.session.cookie", "PLAY") + "_FLASH";
	private final Http.Response wrappedResponse;
	private final Map<String, Object> renderArgs;
	private final Object request;
	private final String httpMethod;

	public Response(String httpMethod, Object request, Http.Response wrappedResponse, Map<String, Object> renderArgs) {
		this.httpMethod = httpMethod;
		this.request = request;
		this.wrappedResponse = wrappedResponse;
		this.renderArgs = renderArgs;
	}

	public Integer getStatus() {
		return wrappedResponse.status;
	}

	public boolean isSuccess() {
		return success(getStatus());
	}

	public boolean isError() {
		return error(getStatus());
	}

	public boolean isRedirect() {
		return redirect(getStatus());
	}

	public String getHeader(String name) {
		return wrappedResponse.getHeader(name);
	}

	public String getContentType() {
		return parseContentType(wrappedResponse.contentType).contentType;
	}

	public String getEncoding() {
		return wrappedResponse.encoding;
	}

	public String getContent() {
		try {
			return new String(wrappedResponse.out.toByteArray(), wrappedResponse.encoding);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Failed to read content from response", e);
		}
	}

	public String getText() {
		if (!"text/plain".equals(getContentType())) {
			throw new WrongContentTypeException("text/plain", getContentType(), httpMethod, request);
		}
		return getContent();
	}


	public Http.Cookie getCookie(String name) {
		return wrappedResponse.cookies.get(name);
	}

	public String getCookieValue(String name) {
		return getCookie(name).value;
	}

	public Map<String, Object> getRenderArgs() {
		return renderArgs;
	}


	public <T> T getRenderArg(String name) {
		return (T) renderArgs.get(name);
	}


	public Map<String, String> getFlashParams() {
		Map<String, String> result = newHashMap();
		String cookie = getCookieValue(FLASH_COOKIE_NAME);
		if (cookie != null) {
			String flashData = urlDecode(cookie);
			Matcher matcher = compile("\u0000([^:]*):([^\u0000]*)\u0000").matcher(flashData);
			while (matcher.find()) {
				result.put(matcher.group(1), matcher.group(2));
			}
		}
		return result;
	}

	private String urlDecode(String cookie) {
		try {
			return decode(cookie, "utf-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}


	public String getFlashParam(String name) {
		return getFlashParams().get(name);
	}

}
