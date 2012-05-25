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

package functional.text;

import litmus.functional.FunctionalTest;
import litmus.functional.WrongContentTypeException;
import org.junit.Test;

public class TextResponseExample extends FunctionalTest {

	@Test
	public void contains() {
		assertThat(get("/contentTypes/text").getContent()).contains("Hello World");
		assertThat(get("/contentTypes/text").getText()).contains("Hello World");
	}

	@Test
	public void getTextThrowsExceptionIfContentTypeIsNotOk() {
		try {
			get("/contentTypes/html").getText();
			fail();
		} catch (WrongContentTypeException e) {
			assertThat(e).hasMessage("Expected to find contentType text/plain but was text/html [Request: GET /contentTypes/html]");
		}
	}

}
