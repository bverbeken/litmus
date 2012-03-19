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

public abstract class FunctionalTest extends FestAssertFunctionalTest {

	protected static Response get(Object url) {
		return new Request(url).get();
	}


	protected static Html getHtml(Object url) {
		return get(url).getHtml();
	}

	protected Response login(String username, String password) {
		// TODO: check whether Secure module is available
		return new Request("/login")
				.with("username", username)
				.with("password", password)
				.post();
	}

	protected void logout() {
		// TODO: check whether Secure module is available
		clearCookies();
	}


	// TODO: add post, put, head and delete methods

}
