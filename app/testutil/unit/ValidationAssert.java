package testutil.unit;

import org.fest.assertions.GenericAssert;

import java.util.List;

import static java.lang.String.format;
import static org.junit.Assert.assertTrue;
import static testutil.ReflectionUtil.set;

public class ValidationAssert extends GenericAssert<ValidationAssert, Object> {


	public static final String REQUIRED = "validation.required";

	public ValidationAssert(Object object) {
		super(ValidationAssert.class, object);
	}


	public ValidationAssert hasRequiredError(String fieldName) {
		return hasError(REQUIRED, fieldName);
	}

	public ValidationAssert with(String fieldName, Object value) {
		set(actual, fieldName, value);
		return this;
	}


	public ValidationAssert hasError(String error, String fieldName) {
		List<String> errorsOnField = Validator.getErrorsForField(actual, fieldName);
		assertTrue(
				makeErrorMessage(fieldName, error, errorsOnField),
				errorsOnField.contains(error));
		return this;
	}


	private String makeErrorMessage(String field, String errorMessageKey, List<String> errorsOnField) {
		String result = format("Expected validation error '%s' not found on field '%s' of class %s.", errorMessageKey, field, actual.getClass().getCanonicalName());
		if (!errorsOnField.isEmpty()) {
			result += format("Other validation errors '%s' on field '%s'", errorsOnField, field);
		}
		return result;
	}



}
