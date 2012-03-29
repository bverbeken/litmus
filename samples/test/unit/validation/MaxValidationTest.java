package unit.validation;

import litmus.unit.validation.ValidationTest;
import models.MaxModel;
import org.junit.Test;

public class MaxValidationTest extends ValidationTest<MaxModel> {

	@Override
	protected MaxModel valid() {
		MaxModel model = new MaxModel();
		model.maxInt = 5;
		model.maxDouble = 4D;
		model.maxLong = 9L;
		model.maxString = "5";
		return model;
	}

	@Test
	public void maxDouble() {
		assertThat("maxDouble").withValue(9.999999999999).isValid();
		assertThat("maxDouble").mustNotBe(10.000000000000001);
		assertThat("maxDouble").mustNotBeGreaterThan(10D);
		assertThat("maxDouble").mustNotBeGreaterThan(10);
	}

	@Test
	public void maxLong() {
		assertThat("maxLong").withValue(9L).isValid();
		assertThat("maxLong").mustNotBe(11L);
		assertThat("maxLong").mustNotBeGreaterThan(10L);
		assertThat("maxLong").mustNotBeGreaterThan(10);

	}

	@Test
	public void maxInt() {
		assertThat("maxInt").withValue(10).isValid();
		assertThat("maxInt").mustNotBe(11);
		assertThat("maxInt").mustNotBeGreaterThan(10);
	}

	@Test
	public void maxString() {
		assertThat("maxString").withValue("10").isValid();
		assertThat("maxString").mustNotBe("11");
		assertThat("maxString").mustNotBe("aaa");
		assertThat("maxString").mustNotBeGreaterThan(10);
	}
}
