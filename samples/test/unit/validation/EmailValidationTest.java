package unit.validation;

import litmus.Builder;
import litmus.unit.validation.ValidationTest;
import models.EmailModel;
import org.junit.Test;

public class EmailValidationTest extends ValidationTest<EmailModel> {

	@Override
	protected Builder<EmailModel> valid() {
		return new EmailModelBuilder();
	}


	@Test
	public void emailMustBeValid() {
		assertThat("email").isInvalidWhenEqualTo("not a valid email");
		assertThat("email").mustBeAnEmailAddress();
	}

    private class EmailModelBuilder extends Builder<EmailModel> {


        @Override
        public EmailModel build() {
            return new EmailModel("ben@ostia.be");
        }
    }
}
