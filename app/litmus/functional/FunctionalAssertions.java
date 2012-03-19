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
import org.jsoup.nodes.Element;
import play.mvc.Http;

public class FunctionalAssertions extends Assertions {

	public static ResponseAssert assertThat(Response response) {
		return new ResponseAssert(response);
	}

	public static CookieAssert assertThat(Http.Cookie cookie) {
		return new CookieAssert(cookie);
	}

	public static HtmlAssert assertThat(Html html) {
		return new HtmlAssert(html);
	}

	public static HtmlElementAssert assertThat(Element element) {
		return new HtmlElementAssert(element);
	}


}
