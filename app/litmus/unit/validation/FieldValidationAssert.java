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

import litmus.util.ReflectionUtil;
import org.fest.assertions.Assertions;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static java.lang.String.format;
import static java.math.BigDecimal.ZERO;
import static litmus.unit.validation.BuiltInValidation.*;
import static litmus.util.DateUtil.asDate;
import static litmus.util.ReflectionUtil.set;
import static org.junit.Assert.assertTrue;


public class FieldValidationAssert<T> {

	private T valid;
	private String fieldName;

	public FieldValidationAssert(T valid, String fieldName) {
		this.valid = valid;
		this.fieldName = fieldName;
	}

	/**
	 * Set a value on the field (using reflection).
	 *
	 * @param value the value to set on the field
	 * @return this
	 */
	public FieldValidationAssert<T> withValue(Object value) {
		set(valid, fieldName, value);
		return this;
	}


	/**
	 * Assert that the field is invalid when it contains the specified value.
	 *
	 * @param value the invalid value
	 * @return this
	 */
	public FieldValidationAssert<T> shouldNotBe(Object value) {
		return withValue(value).isInvalid();
	}

	/**
	 * Assert that the field is required.
	 * This is checked by setting the field value to 'null'.
	 *
	 * @return this
	 */
	public FieldValidationAssert<T> isRequired() {
		return withValue(null).isInvalidBecause(REQUIRED);
	}

	public FieldValidationAssert<T> shouldBeAValidEmailAddress() {
		return verifyBuiltInValidation(EMAIL);
	}

	public FieldValidationAssert<T> shouldBeInFuture() {
		return verifyBuiltInValidation(IN_FUTURE);
	}

	public FieldValidationAssert<T> shouldBeAfter(Date date) {
		return withValue(date).isInvalidBecause(AFTER);
	}

	public FieldValidationAssert<T> shouldBeAfter(String dateAsString) {
		// TODO: check other values (corner cases).
		return withValue(asDate(dateAsString)).isInvalidBecause(AFTER);
	}


	public FieldValidationAssert<T> shouldBeInPast() {
		return verifyBuiltInValidation(IN_PAST);
	}

	public FieldValidationAssert<T> shouldBeBefore(Date date) {
		return withValue(date).isInvalidBecause(BEFORE);
	}

	public FieldValidationAssert<T> shouldBeBefore(String dateAsString) {
		return withValue(asDate(dateAsString)).isInvalidBecause(BEFORE);
	}

	public FieldValidationAssert<T> shouldBeAValidIPv4Address() {
		return verifyBuiltInValidation(IP_V4_ADDRESS);
	}

	public FieldValidationAssert<T> shouldBeTrue() {
		Object validValue = ReflectionUtil.get(fieldName, valid);
		if (validValue instanceof Boolean) {
			return withValue(false).isInvalidBecause(IS_TRUE);
		} else if (validValue instanceof String) {
			return withValue("false").isInvalidBecause(IS_TRUE);
		} else if (validValue instanceof Integer) {
			return withValue(0).isInvalidBecause(IS_TRUE);
		} else if (validValue instanceof Double) {
			return withValue(0D).isInvalidBecause(IS_TRUE);
		} else if (validValue instanceof Long) {
			return withValue(0L).isInvalidBecause(IS_TRUE);
		} else if (validValue instanceof Float) {
			return withValue(0F).isInvalidBecause(IS_TRUE);
		} else if (validValue instanceof BigDecimal) {
			return withValue(ZERO).isInvalidBecause(IS_TRUE);
		}
		throw new UnsupportedOperationException("@IsTrue is not supported on fields of type [" + validValue.getClass() + "]");
	}


	private FieldValidationAssert<T> verifyBuiltInValidation(BuiltInValidation validation) {
		return withValue(validation.getInvalidValue()).isInvalidBecause(validation);
	}

	/**
	 * Assert that the field is invalid. You should use this method
	 * in a method chain, after calling .with(invalidValue);
	 *
	 * @return this
	 */
	public FieldValidationAssert<T> isInvalid() {
		Assertions.assertThat(Validator.getErrorsForField(valid, fieldName))
				.as("expected validation error for field '" + fieldName + "' but it was valid.")
				.isNotEmpty();
		return this;
	}

	/**
	 * Assert that the field is valid. You should use this method
	 * in a method chain, after calling .with(validValue);
	 *
	 * @return this
	 */
	public FieldValidationAssert<T> isValid() {
		List<String> errorsForField = Validator.getErrorsForField(valid, fieldName);
		Assertions.assertThat(errorsForField)
				.as("expected to be valid, but errors found: " + errorsForField)
				.isEmpty();
		return this;
	}

	private FieldValidationAssert<T> isInvalidBecause(BuiltInValidation builtInValidation) {
		return hasValidationError(builtInValidation.getMessageKey());
	}

	/**
	 * Assert that the field is invalid and that it fails validation with a given error key.
	 * You should use this method in a method chain, after calling .with(invalidValue).
	 *
	 * @param error the expected error
	 * @return this
	 */
	public FieldValidationAssert<T> hasValidationError(String error) {
		List<String> errorsOnField = Validator.getErrorsForField(valid, fieldName);
		assertTrue(
				makeErrorMessage(fieldName, error, errorsOnField),
				errorsOnField.contains(error));
		return this;
	}

	private String makeErrorMessage(String field, String errorMessageKey, List<String> errorsOnField) {
		String result = format("Expected validation error '%s' not found on field '%s' of class %s.", errorMessageKey, field, valid.getClass().getCanonicalName());
		if (!errorsOnField.isEmpty()) {
			result += format("Other validation errors '%s' on field '%s'", errorsOnField, field);
		}
		return result;
	}


}
