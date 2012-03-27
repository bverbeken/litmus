package unit.validation;

import litmus.unit.validation.ValidationTest;
import models.ModelForValidation;
import models.Person;

public class AllBuiltInValidationsTest extends ValidationTest<ModelForValidation> {

	@Override
	protected ModelForValidation valid() {
		ModelForValidation model = new ModelForValidation();
		model.between10And20 = 15;
		model.validObject = new Person("Joe", "Jackson");
		return model;
	}






}
