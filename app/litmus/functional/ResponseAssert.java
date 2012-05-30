/*
 * Copyright 2012 Ben Verbeken
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package litmus.functional;

import litmus.unit.validation.BuiltInValidation;
import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;
import play.mvc.Http;

import static org.fest.assertions.Assertions.assertThat;
import static play.mvc.Http.StatusCode.*;

public class ResponseAssert extends GenericAssert<ResponseAssert, Response> {

	private Response response;

	protected ResponseAssert(Response response) {
		super(ResponseAssert.class, response);
		this.response = response;
	}

	public ResponseAssert isStatus(int httpStatusCode) {
		assertThat(response.getStatus()).isEqualTo(httpStatusCode);
		return this;
	}

	public ResponseAssert isOk() {
		return isStatus(OK);
	}

	public ResponseAssert isNotFound() {
		return isStatus(NOT_FOUND);
	}

	public ResponseAssert isForbidden() {
		return isStatus(FORBIDDEN);
	}

	public ResponseAssert isSuccess() {
		assertThat(response.isSuccess()).isTrue();
		return this;
	}

	public ResponseAssert isNoSuccess() {
		assertThat(response.isSuccess()).isFalse();
		return this;
	}

	public ResponseAssert isError() {
		assertThat(response.isError()).isTrue();
		return this;
	}

	public ResponseAssert isNoError() {
		assertThat(response.isError()).isFalse();
		return this;
	}

	public ResponseAssert isRedirect() {
		assertThat(response.isRedirect()).as("Expected a redirect, but status code was " + response.getStatus()).isTrue();
		return this;
	}

	public ResponseAssert isNoRedirect() {
		assertThat(response.isRedirect()).isFalse();
		return this;
	}

	public ResponseAssert isRedirectTo(String location) {
		isRedirect();
		hasHeaderValue("location", location);
		return this;
	}

	public ResponseAssert hasHeader(String name) {
		assertThat(response.getHeader(name)).isNotNull();
		return this;
	}

	public ResponseAssert hasNoHeader(String name) {
		assertThat(response.getHeader(name)).isNull();
		return this;
	}

	public ResponseAssert hasHeaderValue(String headerName, String headerValue) {
		assertThat(response.getHeader(headerName)).isEqualToIgnoringCase(headerValue);
		return this;
	}

	public ResponseAssert hasFlashParam(String name) {
		FunctionalAssertions.assertThat(response.getFlashParam(name)).isNotNull();
		return this;
	}

	public ResponseAssert hasFlashParam(String name, String value) {
		FunctionalAssertions.assertThat(response.getFlashParam(name)).isEqualTo(value);
		return this;
	}

	public ResponseAssert hasNoFlashParam(String name) {
		FunctionalAssertions.assertThat(response.getFlashParam(name)).isNull();
		return this;
	}

	public ResponseAssert hasCookie(String name) {
		Http.Cookie cookie = response.getCookie(name);
		Assertions.assertThat(cookie).describedAs(String.format("cookie [%s] not found", name)).isNotNull();
		return this;
	}

	public ResponseAssert hasCookieValue(String name, String value) {
		Http.Cookie cookie = response.getCookie(name);
		Assertions.assertThat(cookie).describedAs(String.format("cookie [%s] not found", name)).isNotNull();
		Assertions.assertThat(cookie.value).isEqualTo(value);
		return this;
	}

	public ResponseAssert hasNoCookie(String cookieName) {
		Assertions.assertThat(response.getCookie(cookieName)).isNull();
		return this;
	}

	public ResponseAssert hasRenderArg(String name) {
		Assertions.assertThat(response.getRenderArgs().get(name)).isNotNull();
		return this;
	}

	public ResponseAssert hasRenderArgValue(String name, Object expected) {
		Assertions.assertThat(response.getRenderArgs().get(name)).isEqualTo(expected);
		return this;
	}


	public ResponseAssert hasNoRenderArg(String name) {
		FunctionalAssertions.assertThat(response.getRenderArgs().get(name)).isNull();
		return this;
	}


	public ResponseAssert isHtml() {
		return hasContentType("text/html");
	}

	public ResponseAssert isXml() {
		return hasContentType("text/xml");
	}

	public ResponseAssert isJson() {
		return hasContentType("application/json");
	}

	public ResponseAssert isText() {
		return hasContentType("text/plain");
	}

	public ResponseAssert hasContentType(String contentType) {
		FunctionalAssertions.assertThat(response.getContentType()).isEqualTo(contentType);
		return this;
	}

	public ResponseAssert isEncoded(String encoding) {
		assertThat(response.getEncoding()).isEqualToIgnoringCase(encoding);
		return this;
	}

	public ResponseAssert isUtf8() {
		return isEncoded("utf-8");
	}

	public ResponseAssert hasValidationError(String fieldName, BuiltInValidation validation) {
        return hasValidationError(fieldName, validation.getMessageKey());
	}

    public ResponseAssert hasValidationError(String fieldName, String validationMessage){
        assertThat(response.getCookie("PLAY_ERRORS").value)
                .as("expected validation error [" + validationMessage +  "] on field [" + fieldName + "] not found")
                .contains(fieldName + "%3A" + validationMessage);
        return this;
    }
}
