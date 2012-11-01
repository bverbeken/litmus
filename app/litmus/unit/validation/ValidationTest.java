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

import litmus.Builder;
import litmus.Category;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import play.test.UnitTest;

import static litmus.engine.CategoryInstance.UNIT;
import static litmus.unit.validation.Validator.getAllErrors;
import static litmus.unit.validation.Validator.isValid;
import static play.test.Fixtures.deleteAllModels;


/**
 * <p>Base class for testing validation annotations on {@link play.db.Model} classes.
 * </p>
 *
 * @author Ben Verbeken
 */
@Category(value = UNIT, priority = 10000)
public abstract class ValidationTest<T> extends UnitTest {

    @Before
    public void cleanDb() {
        deleteAllModels();
    }

	/**
	 * @param fieldName the name of the field on the Model class you want to assert
	 * @return a {@link FieldValidationAssert} instance
	 */
	protected FieldValidationAssert<T> assertThat(String fieldName) {
		return new FieldValidationAssert<T>(buildValid(), fieldName);
	}

    private T buildValid() {
        return valid().build();
    }


    /**
	 * @param t the object to validate
	 * @return a {@link ValidationAssert} instance
	 */
	protected ValidationAssert<T> assertThat(T t) {
		return new ValidationAssert<T>(t);
	}

    /**
     *
     * @param builder the {@link Builder} that will be used to build the object to validate
     * @return a {@link ValidationAssert} instance
     */
    protected ValidationAssert<T> assertThat(Builder<T> builder){
        return new ValidationAssert<T>(builder.build());
    }

	/**
	 * Test to verify that the valid() method actually returns a valid object.
	 *
	 * @see ValidationTest#valid()
	 */
	@Test
	public void validObjectShouldValidate() {
		T validObject = buildValid();
		Assertions.assertThat(isValid(validObject))
				.as(invalidMessage(validObject))
				.isTrue();
	}

	private String invalidMessage(T valid) {
		return String.format(
				"Expected object of type %s to be valid, but it was invalid because: %s",
				valid.getClass().getCanonicalName(),
				getAllErrors());
	}

	/**
	 * Subclasses of ValidationTest should implement this method. It's used in
	 * The validObjectShouldValidate() test verifies that this method actually
	 * returns a valid object.
	 *
	 * @return a valid object of type T
	 * @see litmus.unit.validation.ValidationTest#validObjectShouldValidate()
	 */
	protected abstract Builder<T> valid();

}
