package testutil.unit;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import play.data.validation.Validation;
import play.test.UnitTest;

public abstract class AbstractValidationTest<T> extends UnitTest {

	protected T valid;

	protected static ValidationAssert assertThat(Object object) {
		return new ValidationAssert(object);
	}

	@Before
	public void initValidatingObject() {
		valid = createValidObject();
	}

	@Before
	public void clearErrors() {
		Validation.clear();
	}

	@Test
	public void validObjectShouldValidate() {
		Assertions.assertThat(Validation.current().valid(valid).ok).isTrue();
	}


	protected abstract T createValidObject();

}
