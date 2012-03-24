package unit.validation;

import litmus.unit.validation.ValidationTest;
import models.ModelForValidation;
import models.Person;

public class AllBuiltInValidationsTest extends ValidationTest<ModelForValidation> {

	@Override
	protected ModelForValidation valid() {
		ModelForValidation model = new ModelForValidation();
		model.minInt = 15;
		model.phone = "+32 222 33 44 55";
		model.between10And20 = 15;
		model.requiredString = "aString";
		model.url = "http://www.google.com";
		model.validObject = new Person("Joe", "Jackson");
		return model;
	}






}
