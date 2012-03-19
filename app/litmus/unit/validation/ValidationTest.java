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

package litmus.unit.validation;

import org.fest.assertions.Assertions;
import org.junit.Test;
import play.test.UnitTest;

public abstract class ValidationTest<T> extends UnitTest {


	protected FieldValidationAssert<T> assertThat(String fieldName) {
		return new FieldValidationAssert<T>(valid(), fieldName);
	}

	protected ValidationAssert<T> assertThat(T t) {
		return new ValidationAssert<T>(t);
	}

	@Test
	public void validObjectShouldValidate() {
		T valid = valid();
		Assertions.assertThat(Validator.isValid(valid))
				.as("Expected object of type " + valid.getClass().getCanonicalName() + " to be valid, but it was invalid because: " + Validator.getAllErrors())
				.isTrue();
	}


	protected abstract T valid();

}
