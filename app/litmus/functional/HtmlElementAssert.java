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
import org.jsoup.nodes.Element;
import play.i18n.Messages;

public class HtmlElementAssert extends GenericAssert<HtmlElementAssert, Element> {

	public HtmlElementAssert(Element element) {
		super(HtmlElementAssert.class, element);
	}

	public HtmlElementAssert containsText(String expectedText) {
		Assertions.assertThat(actual.text()).contains(expectedText);
		return this;
	}

	public HtmlElementAssert containsTextIgnoringCase(String expectedText) {
		Assertions.assertThat(actual.text()).containsIgnoringCase(expectedText);
		return this;
	}


	public HtmlElementAssert hasClass(String cssClass) {
		Assertions.assertThat(actual.className()).contains(cssClass);
		return this;
	}

	public HtmlElementAssert hasNoClass(String cssClass) {
		Assertions.assertThat(actual.className()).doesNotContain(cssClass);
		return this;
	}

	public HtmlElementAssert hasNoClass() {
		Assertions.assertThat(actual.className()).isEqualTo("");
		return this;
	}

	public HtmlElementAssert hasAttribute(String attributeKey) {
		Assertions.assertThat(actual.attr(attributeKey)).isNotEmpty();
		return this;
	}

	public HtmlElementAssert hasAttributeValue(String key, String expectedValue) {
		Assertions.assertThat(actual.attr(key)).isEqualTo(expectedValue);
		return this;
	}

	public HtmlElementAssert hasNoAttribute(String attributeKey) {
		Assertions.assertThat(actual.attr(attributeKey)).isEmpty();
		return this;
	}

	public HtmlElementAssert containsMessage(String key, Object... args) {
		return containsText(Messages.get(key, args));
	}
}
