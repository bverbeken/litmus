package unit.validation;

import litmus.unit.validation.ValidationTest;
import models.EmailModel;
import org.junit.Test;

public class EmailValidationTest extends ValidationTest<EmailModel> {

	@Override
	protected EmailModel valid() {
		return new EmailModel("ben@ostia.be");
	}


	@Test
	public void emailMustBeValid() {
		assertThat("email").isInvalidWhenEqualTo("not a valid email");
		assertThat("email").mustBeAnEmailAddress();
	}

}
