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

package functional.security;

import litmus.functional.FunctionalTest;
import org.junit.Test;

public class AuthenticationExample extends FunctionalTest {

	@Test
	public void unsecuredPageIsAccessibleWithoutLoggingIn() {
		assertThat(get("/html/helloWorld")).isOk();
	}

	@Test
	public void securedPageIsRedirectToLoginIfNotLoggedIn() {
		assertThat(get("/security/secured")).isRedirectTo("/login");
	}


	@Test
	public void securedPageIsAccessibleWhenLoggedIn() {
		login("user1", "secret");
		assertThat(get("/security/secured")).isOk();
	}

	@Test
	public void logoutLogsOut() {
		login("user", "secret");
		assertThat(get("/security/secured")).isOk();
		logout();
		assertThat(get("/security/secured")).isRedirectTo("/login");
	}

}
