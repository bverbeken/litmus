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

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Html {

	private final Document document;
	private String source;

	public Html(String source) {
		this.document = Jsoup.parse(source);
		this.source = source;
	}

	public String getTitle() {
		return document.title();
	}

	public Elements select(String selector) {
		return document.select(selector);
	}

	public Element selectSingle(String selector) {
		Elements elements = select(selector);
		if (elements.size() != 1) {
			String msgPrefix = elements.isEmpty() ? "no" : "more than one";
			throw new WrongSelectorException(msgPrefix + " element found for selector [" + selector + "]");
		}
		return elements.first();
	}


	public String getSource() {
		return source;
	}
}
