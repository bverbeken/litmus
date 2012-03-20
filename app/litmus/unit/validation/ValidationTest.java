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


/**
 * <p>Base class for testing validation annotations on {@link play.db.Model} classes.
 * </p>
 *
 * @author Ben Verbeken
 */
public abstract class ValidationTest<T> extends UnitTest {


	/**
	 * @param fieldName the name of the field on the Model class you want to assert
	 * @return a {@link FieldValidationAssert} instance
	 */
	protected FieldValidationAssert<T> assertThat(String fieldName) {
		return new FieldValidationAssert<T>(valid(), fieldName);
	}


	/**
	 * @param t the object to validate
	 * @return a {@link ValidationAssert} instance
	 */
	protected ValidationAssert<T> assertThat(T t) {
		return new ValidationAssert<T>(t);
	}

	/**
	 * Test to verify that the valid() method actually returns a valid object.
	 *
	 * @see ValidationTest#valid()
	 */
	@Test
	public void validObjectShouldValidate() {
		T valid = valid();
		Assertions.assertThat(Validator.isValid(valid))
				.as("Expected object of type " + valid.getClass().getCanonicalName() + " to be valid, but it was invalid because: " + Validator.getAllErrors())
				.isTrue();
	}

	/**
	 * Subclasses of ValidationTest should implement this method. It's used in
	 * The validObjectShouldValidate() test verifies that this method actually
	 * returns a valid object.
	 *
	 * @return a valid object of type T
	 * @see litmus.unit.validation.ValidationTest#validObjectShouldValidate()
	 */
	protected abstract T valid();

}
