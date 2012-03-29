package unit.validation;

import litmus.unit.validation.ValidationTest;
import models.Person;
import models.ValidModel;
import org.junit.Test;

import static litmus.unit.validation.BuiltInValidation.VALID;

public class ValidValidationTest extends ValidationTest<ValidModel> {

	@Override
	protected ValidModel valid() {
		ValidModel model = new ValidModel();
		model.validPerson = new Person("Ben");
		return model;
	}


	@Test
	public void validShouldBeValid() {
		Object invalidPerson = new Person(null, null);
		assertThat("validPerson").withValue(invalidPerson).hasValidationError(VALID);
		assertThat("validPerson").withValue(invalidPerson).hasValidationError("validation.object");
	}
}
