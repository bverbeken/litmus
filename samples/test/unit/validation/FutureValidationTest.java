package unit.validation;

import litmus.unit.validation.ValidationTest;
import models.FutureModel;
import org.junit.Test;

import static litmus.util.DateUtil.*;

public class FutureValidationTest extends ValidationTest<FutureModel> {
	@Override
	protected FutureModel valid() {
		FutureModel model = new FutureModel();
		model.futureDate = tomorrow();
		model.dateAfter1Jan2100 = asDate("2222-01-01");
		return model;
	}

	@Test
	public void futureDate() {
		assertThat("futureDate").mustNotBe(yesterday());
		assertThat("futureDate").mustBeInTheFuture();
	}

	@Test
	public void dateAfterAGivenDate() {
		assertThat("dateAfter1Jan2100").mustBeAfter(asDate("2100-01-01"));
		assertThat("dateAfter1Jan2100").mustBeAfter("2100-01-01");
	}

}
