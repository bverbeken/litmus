package unit.validation;

import litmus.unit.validation.ValidationTest;
import models.MatchModel;
import org.junit.Test;

public class MatchValidationTest extends ValidationTest<MatchModel> {

	@Override
	protected MatchModel valid() {
		MatchModel model = new MatchModel();
		model.matchingString = "1290";
		return model;
	}


	@Test
	public void match() {
		assertThat("matchingString").shouldNotBe("aaa");
		assertThat("matchingString").shouldMatch("[0-9]*");
		assertThat("matchingString").shouldMatch("[1-2]*");
		assertThat("matchingString").shouldMatch("[1]*");
	}

}
