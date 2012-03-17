package unit.validation;

import models.Person;
import org.junit.Test;
import litmus.unit.validation.ValidationTest;

import static litmus.unit.validation.BuiltInValidation.MIN_SIZE;
import static litmus.unit.validation.BuiltInValidation.REQUIRED;

public class SampleFieldValidationTest extends ValidationTest<Person> {

	@Override
	protected Person valid() {
		return new Person("Ben", "Verbeken");
	}

	@Test
	public void firstNameIsRequired() {
		assertThat("firstName").isRequired();
		assertThat("firstName").withValue("").isInvalidBecause(REQUIRED);
		assertThat("firstName").shouldNotBe("");
		assertThat("firstName").shouldNotBe(null);
	}

	@Test
	public void lastNameShouldHaveMinLenght() {
		assertThat("lastName").withValue("123").isInvalidBecause(MIN_SIZE);
		assertThat("lastName").withValue("1234").isValid();
	}

}
