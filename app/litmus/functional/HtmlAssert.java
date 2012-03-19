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
import org.jsoup.select.Elements;

import static java.lang.String.format;

public class HtmlAssert extends GenericAssert<HtmlAssert, Html> {

	public HtmlAssert(Html html) {
		super(HtmlAssert.class, html);
	}

	public HtmlAssert hasTitle(String title) {
		Assertions.assertThat(actual.getTitle()).isEqualTo(title);
		return this;
	}

	public HtmlAssert titleContains(String titlePart) {
		Assertions.assertThat(actual.getTitle()).contains(titlePart);
		return this;
	}

	public HtmlAssert titleMatches(String regex) {
		Assertions.assertThat(actual.getTitle()).matches(regex);
		return this;
	}


	public HtmlAssert containsElement(String selector) {
		Assertions.assertThat(actual.select(selector))
				.as(format("Response html does not contain element that satisfies [%s]", selector))
				.isNotEmpty();
		return this;
	}

	public HtmlAssert doesNotContainElement(String selector) {
		Elements elements = actual.select(selector);
		Assertions.assertThat(elements)
				.as(format("Response html contains the following elements that satisfy [%s]: %s", selector, elements))
				.isEmpty();
		return this;
	}

	public HtmlAssert contains(String expectedString) {
		Assertions.assertThat(actual.getSource()).contains(expectedString);
		return this;
	}

}
