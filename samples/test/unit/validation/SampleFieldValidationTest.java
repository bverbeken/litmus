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

package unit.validation;

import litmus.unit.validation.ValidationTest;
import models.Person;
import org.junit.Test;

public class SampleFieldValidationTest extends ValidationTest<Person> {

	@Override
	protected Person valid() {
		return new Person("Ben", "Verbeken");
	}

	@Test
	public void firstNameIsRequired() {
		assertThat("firstName").isRequired();
		assertThat("firstName").mustNotBe("");
		assertThat("firstName").mustNotBe(null);
	}

	@Test
	public void lastNameShouldHaveMinLenght() {
		assertThat("lastName").withValue("1234").isValid();
	}

}
