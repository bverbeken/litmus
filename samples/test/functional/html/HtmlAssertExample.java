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

import litmus.functional.FunctionalTest;
import org.junit.Test;

public class HtmlAssertExample extends FunctionalTest {

	public static final String PATH = "/html/aPage";

	@Test
	public void hasTitle() {
		assertThat(get(PATH).getHtml()).hasTitle("Home");
		assertThat(getHtml(PATH)).hasTitle("Home");
	}

	@Test
	public void titleContains() {
		assertThat(get(PATH).getHtml()).titleContains("H");
	}

	@Test
	public void titleMatches() {
		assertThat(get(PATH).getHtml()).titleMatches("H.*e");
	}

	@Test
	public void contains() {
		assertThat(getHtml(PATH)).containsElement("#myDiv");
		assertThat(getHtml(PATH)).contains("This is myDiv");
	}

	@Test
	public void doesNotContain() {
		assertThat(getHtml(PATH)).doesNotContainElement("#anUnexistingId");
	}


}
