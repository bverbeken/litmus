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

import java.util.Date;
import java.util.List;

import static java.lang.String.format;
import static litmus.unit.validation.BuiltInValidation.*;
import static litmus.util.DateUtil.*;
import static litmus.util.ReflectionUtil.*;
import static org.apache.commons.lang.RandomStringUtils.random;
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
	 * This is a shorthand notation for <pre>assertThat("xxx").withValue(anInvalidValue().isInvalid()</pre>
	 *
	 * @param value the invalid value
	 * @return this
	 */
	public FieldValidationAssert<T> mustNotBe(Object value) {
		return withValue(value).isInvalid();
	}

	/**
	 * Assert that the field is invalid. You should use this method
	 * in a method chain, after calling .with(invalidValue);
	 *
	 * @return this
	 */
	public FieldValidationAssert<T> isInvalid() {
		Assertions.assertThat(Validator.getErrorsForField(valid, fieldName))
				.as("expected validation error on field '" + fieldName + "' but it was valid.")
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
		assertTrue(
				"expected to be valid, but errors found: " + errorsForField,
				errorsForField.isEmpty());
		return this;
	}


	/**
	 * Assert that the field is invalid and that it fails validation with a given error key.
	 * You should use this method in a method chain, after calling .with(invalidValue).
	 *
	 * @param builtInValidation the built-in validation that is expected to fail
	 * @return this
	 */
	public FieldValidationAssert<T> hasValidationError(BuiltInValidation builtInValidation) {
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
				validationErrorNotFoundMessage(fieldName, error, errorsOnField),
				errorsOnField.contains(error));
		return this;
	}

	/**
	 * Assert that the field is required.
	 * This is checked by setting the field value to 'null'.
	 *
	 * @return this
	 */
	public FieldValidationAssert<T> isRequired() {
		return withValue(null).hasValidationError(REQUIRED);
	}

	/**
	 * Assert that the the field is a valid email address.
	 * This is checked by setting the field value to 'not a valid email address'.
	 *
	 * @return this
	 */
	public FieldValidationAssert<T> mustBeAnEmailAddress() {
		return withValue("not a valid email address").hasValidationError(EMAIL);
	}

	/**
	 * Assert that the field is a valid ip v4 address.
	 * This is checked by setting the field value to 'not a valid ipv4 address'.
	 *
	 * @return this
	 */
	public FieldValidationAssert<T> mustBeAnIPv4Address() {
		return withValue("not a valid ipv4 address").hasValidationError(IP_V4_ADDRESS);
	}


	/**
	 * Assert that the field is a valid ip v6 address.
	 * This is checked by setting the field value to 'not a valid ipv6 address'.
	 *
	 * @return this
	 */
	public FieldValidationAssert<T> mustBeAnIPv6Address() {
		return withValue("not a valid ipv6 address").hasValidationError(IP_V6_ADDRESS);
	}

	/**
	 * Assert that the field is a valid phone number.
	 * This is checked by setting the field value to 'not a valid phone'.
	 *
	 * @return this
	 */
	public FieldValidationAssert<T> mustBeAPhoneNumber() {
		return withValue("not a valid phone").hasValidationError(PHONE);
	}

	/**
	 * Assert that the field is a valid URL.
	 * This is checked by setting the field value to 'not a valid url'.
	 *
	 * @return this
	 */
	public FieldValidationAssert<T> mustBeAURL() {
		return withValue("not a valid url").hasValidationError(URL);
	}

	/**
	 * Assert that the field is 'true'. This is checked by setting the field value to:
	 * <ul>
	 * <li>false if it is a boolean</li>
	 * <li>"false" if it is a String</li>
	 * <li>0 if it is a number</li>
	 * </ul>
	 *
	 * @return this
	 */
	public FieldValidationAssert<T> mustBeTrue() {
		Object validValue = get(fieldName, valid);
		if (validValue instanceof Boolean) {
			return withValue(false).hasValidationError(IS_TRUE);
		} else if (validValue instanceof String) {
			return withValue("false").hasValidationError(IS_TRUE);
		} else if (validValue instanceof Number) {
			return withNumberValue("0").hasValidationError(IS_TRUE);
		}
		throw new UnsupportedOperationException("@IsTrue is not supported on fields of type [" + validValue.getClass() + "]");
	}

	/**
	 * Assert that a Date or String field's value is in the future.
	 *
	 * @return this
	 */
	public FieldValidationAssert<T> mustBeInTheFuture() {
		withValue(new Date()).hasValidationError(IN_FUTURE);
		return withValue(yesterday()).hasValidationError(IN_FUTURE);
	}

	/**
	 * Assert that a Date or String field's value is after a given date.
	 *
	 * @param date the Date after which the field's value must lie
	 * @return this
	 */
	public FieldValidationAssert<T> mustBeAfter(Date date) {
		withValue(date).hasValidationError(AFTER);
		return withValue(date).hasValidationError(AFTER);
	}

	/**
	 * Assert that a Date or String field's value is after a given date, passed as a String.
	 * To parse the string, play.utils.Utils.AlternativeDateFormat.getDefaultFormatter().parse(dateAsString) is used.
	 *
	 * @param dateAsString the date as a String.
	 * @return this
	 */
	public FieldValidationAssert<T> mustBeAfter(String dateAsString) {
		return mustBeAfter(asDate(dateAsString));
	}

	public FieldValidationAssert<T> mustBeInThePast() {
		// TODO : check NOW value like this: withValue(new Date()).hasValidationError(IN_PAST); (fails sometimes..?)
		return withValue(tomorrow()).hasValidationError(IN_PAST);
	}

	public FieldValidationAssert<T> mustBeBefore(Date date) {
		withValue(date).hasValidationError(BEFORE);
		return withValue(date).hasValidationError(BEFORE);
	}

	public FieldValidationAssert<T> mustBeBefore(String dateAsString) {
		return mustBeBefore(asDate(dateAsString));
	}

	public FieldValidationAssert<T> mustNotBeGreaterThan(Number max) {
		return checkBoundary(Integer.toString(max.intValue() + 1), MAX);
	}

	public FieldValidationAssert<T> mustNotBeLessThan(Number minNumber) {
		return checkBoundary(Integer.toString(minNumber.intValue() - 1), MIN);
	}

	public FieldValidationAssert<T> mustNotHaveSizeGreaterThan(int maxSize) {
		withValue(random(maxSize)).isValid();
		return withValue(random(maxSize + 1)).hasValidationError(MAX_SIZE);
	}

	public FieldValidationAssert<T> mustNotHaveSizeSmallerThan(int minSize) {
		withValue(random(minSize)).isValid();
		return withValue(random(minSize - 1)).hasValidationError(MIN_SIZE);
	}

	private FieldValidationAssert<T> withNumberValue(String numberValue) {
		setNumberValue(numberValue, fieldName, valid);
		return this;
	}


	private FieldValidationAssert<T> checkBoundary(String maxPlusOne, BuiltInValidation numberFieldValidation) {
		if (getDeclaredFieldType(valid.getClass(), fieldName).equals(String.class)) {
			return withValue(maxPlusOne).hasValidationError(numberFieldValidation);
		} else {
			return withNumberValue(maxPlusOne).hasValidationError(numberFieldValidation);
		}
	}


	private String validationErrorNotFoundMessage(String field, String errorMessageKey, List<String> errorsOnField) {
		String result = format("Expected validation error '%s' not found on field '%s' of class %s.", errorMessageKey, field, valid.getClass().getCanonicalName());
		if (!errorsOnField.isEmpty()) {
			result += format("Other validation errors '%s' on field '%s'", errorsOnField, field);
		}
		return result;
	}

}
