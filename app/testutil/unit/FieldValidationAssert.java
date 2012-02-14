package testutil.unit;

import org.fest.assertions.Assertions;

import java.util.List;

import static testutil.ReflectionUtil.set;
import static testutil.unit.Validator.getErrorsForField;

public class FieldValidationAssert<T> {

	private T valid;
	private String fieldName;

	public FieldValidationAssert(T valid, String fieldName) {
		this.valid = valid;
		this.fieldName = fieldName;
	}

	public void shouldNotBeNull() {
		set(valid, fieldName, null);
		List<String> errors = getErrorsForField(valid, fieldName);
		Assertions.assertThat(errors).contains(ValidationMessages.REQUIRED);
	}
}
