package testutil.unit.validation;

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;

public class ValidationAssert<T> extends GenericAssert<ValidationAssert, T> {


	protected ValidationAssert(T actual) {
		super(ValidationAssert.class, actual);
	}


	public ValidationAssert<T> isValid() {
		Assertions.assertThat(Validator.isValid(actual)).isTrue();
		return this;
	}

	public ValidationAssert<T> isInvalid() {
		Assertions.assertThat(Validator.isValid(actual)).isFalse();
		return this;
	}

	public ValidationAssert<T> isInvalidBecause(String fieldName, String error) {
		Assertions.assertThat(Validator.getErrorMessagesForField(fieldName)).contains(error);
		return this;
	}

	public ValidationAssert<T> isInvalidBecause(String fieldName, BuiltInValidation error) {
		return isInvalidBecause(fieldName, error.getMessageKey());
	}

}
