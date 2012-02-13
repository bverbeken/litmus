package testutil.unit;

import com.google.common.collect.Lists;
import org.fest.assertions.GenericAssert;
import play.data.validation.Error;
import play.data.validation.Validation;
import testutil.ReflectionUtil;

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
	
	public ValidationAssert without(String fieldName){
		set(actual, fieldName, null);
		return this;
	}


	public ValidationAssert hasError(String error, String fieldName) {
		Validation.current().valid(actual);
		List<String> errorsOnField = getErrorMessagesForField(fieldName);
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

	private List<String> getErrorMessagesForField(String field) {
		List<String> result = Lists.newArrayList();
		List<Error> errors = Validation.current().errorsMap().get("." + field);
		if (errors != null && !errors.isEmpty()) {
			for (Error error : errors) {
				result.add(getErrorKey(error));
			}
		}
		return result;
	}

	private String getErrorKey(Error error) {
		return ReflectionUtil.get("message", error);
	}


}
