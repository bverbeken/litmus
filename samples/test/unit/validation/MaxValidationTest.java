package unit.validation;

import litmus.unit.validation.ValidationTest;
import models.MaxModel;
import org.junit.Test;

public class MaxValidationTest extends ValidationTest<MaxModel> {

	@Override
	protected MaxModel valid() {
		MaxModel model = new MaxModel();
		model.maxInt = 5;
		model.maxString = "5";
		model.maxDouble = 4D;
		return model;
	}

	
	@Test
	public void maxDouble(){
		assertThat("maxDouble").withValue(9.999999999999).isValid();
		assertThat("maxDouble").shouldNotBe(10.000000000000001);
		assertThat("maxDouble").shouldBeMax(10D);
		assertThat("maxDouble").shouldBeMax(10);

	}
	
	@Test
	public void maxInt(){
		assertThat("maxInt").withValue(10).isValid();
		assertThat("maxInt").shouldNotBe(11);
		assertThat("maxInt").shouldBeMax(10);
	}

	@Test
	public void maxString(){
		assertThat("maxString").withValue("10").isValid();
		assertThat("maxString").shouldNotBe("11");
		assertThat("maxString").shouldNotBe("aaa");
		assertThat("maxString").shouldBeMax(10);
	}
}
