package unit.validation;

import models.Person;
import org.junit.Test;
import litmus.unit.validation.ValidationTest;

import static litmus.unit.validation.BuiltInValidation.REQUIRED;

public class SampleObjectValidationTest extends ValidationTest<Person> {

	@Override
	protected Person valid() {
		return new Person("Ben", "Verbeken");
	}

	@Test
	public void firstNameIsRequired() {
		Person personWithoutFirstName = new Person(null);
		assertThat(personWithoutFirstName).isInvalid();
		assertThat(personWithoutFirstName).isInvalidBecause("firstName", REQUIRED);
		assertThat(personWithoutFirstName).isInvalidBecause("firstName", "validation.required");
	}

	@Test
	public void isValid() {
		Person validPerson = valid();
		assertThat(validPerson).isValid();
	}
}
