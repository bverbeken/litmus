package testutil.unit;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import play.data.validation.Validation;
import play.test.UnitTest;

import static testutil.unit.Validator.isValid;

public abstract class AbstractValidationTest<T> extends UnitTest {


	protected ValidationAssert assertThat(Object object) {
		return new ValidationAssert(object);
	}

	protected FieldValidationAssert<T> assertThat(String fieldName) {
		return new FieldValidationAssert<T>(valid(), fieldName);
	}

	@Before
	public void clearErrors() {
		Validation.clear();
	}

	@Test
	public void validObjectShouldValidate() {
		Assertions.assertThat(isValid(valid())).isTrue();
	}


	protected abstract T valid();

}
