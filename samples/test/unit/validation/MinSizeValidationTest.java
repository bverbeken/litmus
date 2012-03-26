package unit.validation;

import litmus.unit.validation.ValidationTest;
import models.MinSizeModel;
import org.junit.Test;

public class MinSizeValidationTest extends ValidationTest<MinSizeModel> {

	@Override
	protected MinSizeModel valid() {
		MinSizeModel model = new MinSizeModel();
		model.minString = "String longer than 4 characters";
		return model;
	}

	@Test
	public void minString() {
		assertThat("minString").withValue(null).isValid();
		assertThat("minString").withValue("").isValid();
		assertThat("minString").shouldBeMinSize(4);
	}

}
