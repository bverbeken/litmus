package unit.validation;

import litmus.unit.validation.ValidationTest;
import models.MatchModel;
import org.junit.Test;

import static litmus.unit.validation.BuiltInValidation.MATCH;

public class MatchValidationTest extends ValidationTest<MatchModel> {

	@Override
	protected MatchModel valid() {
		MatchModel model = new MatchModel();
		model.matchingString = "1290";
		return model;
	}

	@Test
	public void match() {
		assertThat("matchingString").withValue("aaa").hasValidationError(MATCH);
	}

}
