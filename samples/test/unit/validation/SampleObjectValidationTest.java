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

import static litmus.unit.validation.BuiltInValidation.EMAIL;
import static litmus.unit.validation.BuiltInValidation.REQUIRED;

public class SampleObjectValidationTest extends ValidationTest<Person> {

	private Person personWithoutFirstName = new Person(null);

	@Override
	protected PersonBuilder valid() {
        return new PersonBuilder();
	}

	@Test
	public void personIsInvalidWithoutFirstName() {
		assertThat(personWithoutFirstName).isInvalid();
	}

	@Test
	public void firstNameIsRequired(){
		assertThat(personWithoutFirstName).isInvalidBecause("firstName", REQUIRED);
	}

	@Test
	public void orIfYouWantToProvideYourOwnValidationFailedMessage(){
		assertThat(personWithoutFirstName).isInvalidBecause("firstName", "validation.required");
	}

	@Test
	public void emailShouldBeValid(){
        assertThat(valid().withEmail("not an email")).isInvalidBecause("email", EMAIL);
	}
}
