package unit.validation;

import litmus.unit.validation.ValidationTest;
import models.PhoneModel;
import org.junit.Test;

public class PhoneValidationTest extends ValidationTest<PhoneModel> {

	@Override
	protected PhoneModel valid() {
		PhoneModel model = new PhoneModel();
		model.phone = "+32 123 44 55 66";
		return model;
	}
	
	@Test
	public void validPhone(){
		assertThat("phone").withValue(null).isValid();
		assertThat("phone").withValue("not a phone").isInvalid();
		assertThat("phone").shouldBeAValidPhone();
	}
}
