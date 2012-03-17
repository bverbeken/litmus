package functional.response;

import litmus.functional.FunctionalTest;
import litmus.functional.Request;
import org.junit.Test;

import static litmus.unit.validation.BuiltInValidation.MIN_SIZE;
import static litmus.unit.validation.BuiltInValidation.REQUIRED;

public class ValidationErrorExample extends FunctionalTest {
	
	private Request request = new Request("/html/sayHello");

	@Test
	public void nameCannotBeEmpty(){
		assertThat(request.with("name", "").post()).hasValidationError("name", REQUIRED);
	}

	@Test
	public void nameCannotBeNull(){
		assertThat(request.post()).hasValidationError("name", REQUIRED);
	}
	
	@Test
	public void nameShouldBeAtLeast4CharsLong(){
		assertThat(request.with("name", "123").post()).hasValidationError("name", MIN_SIZE);
	}

}
