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

package functional.response;

import org.junit.Test;
import litmus.functional.FunctionalTest;

public class HeaderExample extends FunctionalTest {

	@Test
	public void hasHeader() {
		assertThat(get("/headers/foo")).hasHeader("foo");
	}

	@Test
	public void hasHeaderIsCaseInsensitive() {
		assertThat(get("/headers/foo")).hasHeader("foo");
		assertThat(get("/headers/foo")).hasHeader("FOO");
		assertThat(get("/headers/foo")).hasHeader("fOo");
	}

	@Test
	public void hasHeaderValue() {
		assertThat(get("/headers/foo")).hasHeaderValue("foo", "bar");
	}


	@Test
	public void hasHeaderValueIsCaseInsensitive() {
		assertThat(get("/headers/foo")).hasHeaderValue("foo", "bar");
		assertThat(get("/headers/foo")).hasHeaderValue("foo", "BAR");
		assertThat(get("/headers/foo")).hasHeaderValue("foo", "bAr");
	}


	@Test
	public void hasNoHeader() {
		assertThat(get("/headers/foo")).hasNoHeader("anUnexistingHeaderName");
	}
}
