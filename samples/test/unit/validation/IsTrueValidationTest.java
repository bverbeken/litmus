package unit.validation;

import litmus.unit.validation.ValidationTest;
import models.IsTrueModel;
import org.junit.Test;

import java.math.BigDecimal;

public class IsTrueValidationTest extends ValidationTest<IsTrueModel> {

	@Override
	protected IsTrueModel valid() {
		IsTrueModel model = new IsTrueModel();
		model.trueBoolean = true;
		model.trueString = "true";
		model.trueInteger = 154;
		model.trueLong = 123L;
		model.trueFloat = 12.3F;
		model.trueDouble = 15.3;
		model.trueBigDecimal = new BigDecimal(12);
		return model;
	}


	@Test
	public void isTrue_Boolean() {
		assertThat("trueBoolean").shouldNotBe(false);
		assertThat("trueBoolean").shouldBeTrue();
	}

	@Test
	public void isTrue_String() {
		assertThat("trueString").shouldNotBe("");
		assertThat("trueString").shouldNotBe("false");
		assertThat("trueString").shouldNotBe("anything else");
		assertThat("trueString").shouldNotBe(null);
		assertThat("trueString").shouldBeTrue();
	}

	@Test
	public void isTrue_Integer() {
		assertThat("trueInteger").shouldNotBe(0);
		assertThat("trueInteger").shouldNotBe(null);
		assertThat("trueInteger").shouldBeTrue();
	}

	@Test
	public void isTrue_Long() {
		assertThat("trueLong").shouldNotBe(0L);
		assertThat("trueLong").shouldNotBe(null);
		assertThat("trueLong").shouldBeTrue();
	}


	@Test
	public void isTrue_Double() {
		assertThat("trueDouble").shouldNotBe(0d);
		assertThat("trueDouble").shouldNotBe(null);
		assertThat("trueDouble").shouldBeTrue();
	}

	@Test
	public void isTrue_Float() {
		assertThat("trueFloat").shouldNotBe(0f);
		assertThat("trueFloat").shouldNotBe(null);
		assertThat("trueFloat").shouldBeTrue();
	}

	@Test
	public void isTrue_BigDecimal() {
		assertThat("trueBigDecimal").shouldNotBe(BigDecimal.ZERO);
		assertThat("trueBigDecimal").shouldNotBe(null);
		assertThat("trueBigDecimal").shouldBeTrue();
	}

}
