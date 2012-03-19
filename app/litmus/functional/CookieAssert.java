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

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;

import static play.mvc.Http.Cookie;

public class CookieAssert extends GenericAssert<CookieAssert, Cookie> {

	protected CookieAssert(Cookie actual) {
		super(CookieAssert.class, actual);
	}

	public CookieAssert hasName(String name) {
		Assertions.assertThat(actual.name).isEqualTo(name);
		return this;
	}

	public CookieAssert hasDomain(String domain) {
		Assertions.assertThat(actual.domain).isEqualTo(domain);
		return this;
	}

	public CookieAssert isSecure() {
		Assertions.assertThat(actual.secure).isTrue();
		return this;
	}

	public CookieAssert isInsecure() {
		Assertions.assertThat(actual.secure).isFalse();
		return this;
	}

	public CookieAssert hasValue(String value) {
		Assertions.assertThat(actual.value).isEqualTo(value);
		return this;
	}

	public CookieAssert hasMaxAge(Integer maxAge) {
		Assertions.assertThat(actual.maxAge).isEqualTo(maxAge);
		return this;
	}

}
