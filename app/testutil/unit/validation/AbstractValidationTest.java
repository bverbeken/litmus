package testutil.unit.validation;

import org.fest.assertions.Assertions;
import org.junit.Test;
import play.test.UnitTest;

public abstract class AbstractValidationTest<T> extends UnitTest {


	protected ValidationAssert<T> assertThat(String fieldName) {
		return new ValidationAssert<T>(valid(), fieldName);
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
