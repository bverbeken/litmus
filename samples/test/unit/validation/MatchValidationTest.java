package unit.validation;

import litmus.Builder;
import litmus.unit.validation.ValidationTest;
import models.MatchModel;
import org.junit.Test;

import static litmus.unit.validation.BuiltInValidation.MATCH;

public class MatchValidationTest extends ValidationTest<MatchModel> {

	@Override
	protected Builder<MatchModel> valid() {
		return new MatchModelBuilder();
	}

	@Test
	public void match() {
		assertThat("matchingString").withValue("aaa").hasValidationError(MATCH);
	}

    private class MatchModelBuilder extends Builder<MatchModel> {
        @Override
        public MatchModel build() {
            MatchModel model = new MatchModel();
            model.matchingString = "1290";
            return model;
        }
    }
}
