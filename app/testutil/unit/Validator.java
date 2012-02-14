package testutil.unit;

import play.data.validation.Error;
import play.data.validation.Validation;
import testutil.ReflectionUtil;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

class Validator {

	public static boolean isValid(Object actual) {
		return validate(actual).ok;
	}

	public static List<String> getErrorsForField(Object actual, String fieldName) {
		validate(actual);
		return getErrorMessagesForField(fieldName);
	}

	private static Validation.ValidationResult validate(Object actual) {
		return Validation.current().valid(actual);
	}

	private static List<String> getErrorMessagesForField(String field) {
		List<String> result = newArrayList();
		List<play.data.validation.Error> errors = Validation.current().errorsMap().get("." + field);
		if (errors != null && !errors.isEmpty()) {
			for (Error error : errors) {
				result.add(getErrorKey(error));
			}
		}
		return result;
	}

	private static String getErrorKey(Error error) {
		return ReflectionUtil.get("message", error);
	}

}
