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

package functional.html;

import litmus.functional.*;
import org.junit.Test;

public class HtmlTest extends FunctionalTest {

	@Test
	public void getHtmlThrowsExceptionIfContentTypeIsNotOk() {
		try {
			Response actual = get("/contentTypes/text");
			actual.getHtml();
			fail();
		} catch (WrongContentTypeException e) {
			assertThat(e).hasMessage("Expected to find contentType text/html but was text/plain [Request: GET /contentTypes/text]");
		}
	}

	@Test
	public void getSingleThrowsExceptionIfMoreThanOneElementFound() {
		try {
			Html actual = getHtml("/html/aPage");
			actual.selectSingle("li");
			fail("expected exception!");
		} catch (WrongSelectorException e) {
			assertThat(e).hasMessage("more than one element found for selector [li]");
		}
	}

	@Test
	public void getSingleThrowsExceptionIfNoElementFound() {
		try {
			Html actual = getHtml("/html/aPage");
			actual.selectSingle("#selectorWithNoResults");
			fail("expected exception!");
		} catch (WrongSelectorException e) {
			assertThat(e).hasMessage("no element found for selector [#selectorWithNoResults]");
		}
	}

}
