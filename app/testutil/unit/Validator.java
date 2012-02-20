package testutil.unit;

import play.data.validation.Error;
import play.data.validation.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static play.data.validation.Validation.ValidationResult;
import static testutil.util.ReflectionUtil.get;

class Validator {

	public static boolean isValid(Object actual) {
		return validate(actual).ok;
	}

	public static List<String> getErrorsForField(Object actual, String fieldName) {
		validate(actual);
		return getErrorMessagesForField(fieldName);
	}

	private static ValidationResult validate(Object actual) {
		Validation.clear();
		return Validation.current().valid(actual);
	}

	private static List<String> getErrorMessagesForField(String field) {
		List<String> result = new ArrayList<String>();
		List<play.data.validation.Error> errors = Validation.current().errorsMap().get("." + field);
		if (errors != null && !errors.isEmpty()) {
			for (Error error : errors) {
				result.add(getErrorKey(error));
			}
		}
		return result;
	}

	private static String getErrorKey(Error error) {
		return get("message", error);
	}

	public static Map<String, List<Error>> getAllErrors() {
		return Validation.current().errorsMap();
	}
}
