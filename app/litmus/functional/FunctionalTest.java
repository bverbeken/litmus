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

import java.util.Map;

/**
 * Base class for functional tests.
 *
 * @author Ben Verbeken
 */
public abstract class FunctionalTest extends FestAssertFunctionalTest {

    /**
     * Perform a GET on a URL. <br/>
     * This is a shortcut method for <pre>new Request(url).get();</pre>
     *
     * @param url the url to GET
     * @return the {@link Response} object
     */
    protected static Response get(Object url) {
        return new Request(url).get();
    }

    /**
     * Perform a PST on a URL. <br/>
     * This is a shortcut method for <pre>new Request(url).get();</pre>
     *
     * @param url the url to POST
     * @return the {@link Response} object
     */
    protected static Response post(Object url, Map<String, String> params) {
        return new Request(url).post(params);
    }


	/**
	 * Shortcut method you can use instead of <pre>get(url).getHtml();</pre>
	 *
	 * @param url the url to GET
	 * @return an {@link Html} object
	 */
	protected static Html getHtml(Object url) {
		return get(url).getHtml();
	}


	/**
	 * Shortcut method for logging in.
	 * <br/>
	 * This method performs a POST on /login with the provided username and password parameters, like so:
	 * <pre>
	 *     new Request("/login").with("username", username).with("password", password).post();
	 * </pre>
	 *
	 * @param username the username
	 * @param password the password
	 * @return a {@link Response} object
	 */
	protected Response login(String username, String password) {
		return new Request("/login")
				.with("username", username)
				.with("password", password)
				.post();
	}

	/**
	 * Shortcut method for logging out, by calling clearCookies();
	 */
	protected void logout() {
		clearCookies();
	}


}
