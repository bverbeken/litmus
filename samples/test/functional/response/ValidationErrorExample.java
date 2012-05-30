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

import litmus.functional.FunctionalTest;
import litmus.functional.Request;
import org.junit.Test;

import static litmus.unit.validation.BuiltInValidation.MIN_SIZE;
import static litmus.unit.validation.BuiltInValidation.REQUIRED;

public class ValidationErrorExample extends FunctionalTest {
	
	private Request request = new Request("/html/sayHello");

	@Test
	public void nameCannotBeEmpty(){
		assertThat(request.with("name", "").post()).hasValidationError("name", REQUIRED);
	}

	@Test
	public void nameCannotBeNull(){
        assertThat(request.post()).hasValidationError("name", REQUIRED);
        assertThat(request.post()).hasValidationError("name", "validation.required");
	}
	
	@Test
	public void nameShouldBeAtLeast4CharsLong(){
		assertThat(request.with("name", "123").post()).hasValidationError("name", MIN_SIZE);
	}

}
