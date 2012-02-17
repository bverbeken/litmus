package testutil.unit;

import org.fest.assertions.Assertions;

import java.util.List;

import static java.lang.String.format;
import static org.junit.Assert.assertTrue;
import static testutil.util.ReflectionUtil.set;
import static testutil.unit.ValidationMessages.MIN_SIZE;
import static testutil.unit.ValidationMessages.REQUIRED;
import static testutil.unit.Validator.getErrorsForField;


public class ValidationAssert<T> {

	private T valid;
	private String fieldName;

	public ValidationAssert(T valid, String fieldName) {
		this.valid = valid;
		this.fieldName = fieldName;
	}

	public ValidationAssert<T> isRequired() {
		return withValue(null).isInvalidBecauseRequired();
	}

	public ValidationAssert<T> shouldNotBe(Object value) {
		return withValue(value).isInvalid();
	}

	public ValidationAssert<T> withValue(Object value) {
		set(valid, fieldName, value);
		return this;

	}

	public ValidationAssert<T> isInvalidBecauseRequired() {
		return isInvalidBecause(REQUIRED);
	}


	public ValidationAssert<T> isInvalidBecauseTooShort() {
		return isInvalidBecause(MIN_SIZE);
	}

	public ValidationAssert<T> isInvalid(){
		Assertions.assertThat(getErrorsForField(valid, fieldName))
				.as("expected validation error for field '" + fieldName + "' but it was valid.")
				.isNotEmpty();
		return this;
	}
	
	public ValidationAssert<T> isValid(){
		List<String> errorsForField = getErrorsForField(valid, fieldName);
		Assertions.assertThat(errorsForField)
				.as("expected to be valid, but errors found: " + errorsForField)
				.isEmpty();
		return this;
	}

	public ValidationAssert<T> isInvalidBecause(String error) {
		List<String> errorsOnField = getErrorsForField(valid, fieldName);
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