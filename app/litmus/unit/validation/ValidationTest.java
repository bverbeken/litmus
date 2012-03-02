package litmus.unit.validation;

import org.fest.assertions.Assertions;
import org.junit.Test;
import play.test.UnitTest;

public abstract class ValidationTest<T> extends UnitTest {


	protected FieldValidationAssert<T> assertThat(String fieldName) {
		return new FieldValidationAssert<T>(valid(), fieldName);
	}

	protected ValidationAssert<T> assertThat(T t) {
		return new ValidationAssert<T>(t);
	}

	@Test
	public void validObjectShouldValidate() {
		T valid = valid();
		Assertions.assertThat(Validator.isValid(valid))
				.as("Expected object of type " + valid.getClass().getCanonicalName() + " to be valid, but it was invalid because: " + Validator.getAllErrors())
				.isTrue();
	}


	protected abstract T valid();

}
