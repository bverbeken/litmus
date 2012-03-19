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
import litmus.functional.Response;

public class FlashParamsExample extends FunctionalTest {

	@Test
	public void somethingPutInFlashScope() {
		assertThat(get("/flash/oneFlashParam")).hasFlashParam("foo");
		assertThat(get("/flash/oneFlashParam")).hasFlashParam("foo", "bar");
		assertThat(get("/flash/oneFlashParam").getFlashParam("foo")).isEqualTo("bar");
	}

	@Test
	public void multipleFlashScopeVars() {
		Response response = get("/flash/twoFlashParams");
		assertThat(response).hasFlashParam("foo", "message1");
		assertThat(response).hasFlashParam("bar", "message2");
	}

	@Test
	public void doesntHaveFlashParam() {
		assertThat(get("/flash/oneFlashParam")).hasNoFlashParam("unknownFlashParam");
	}

}
