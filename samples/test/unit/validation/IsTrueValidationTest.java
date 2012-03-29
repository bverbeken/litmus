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
		assertThat("trueBoolean").mustNotBe(false);
		assertThat("trueBoolean").mustBeTrue();
	}

	@Test
	public void isTrue_String() {
		assertThat("trueString").mustNotBe("");
		assertThat("trueString").mustNotBe("false");
		assertThat("trueString").mustNotBe("anything else");
		assertThat("trueString").mustNotBe(null);
		assertThat("trueString").mustBeTrue();
	}

	@Test
	public void isTrue_Integer() {
		assertThat("trueInteger").mustNotBe(0);
		assertThat("trueInteger").mustNotBe(null);
		assertThat("trueInteger").mustBeTrue();
	}

	@Test
	public void isTrue_Long() {
		assertThat("trueLong").mustNotBe(0L);
		assertThat("trueLong").mustNotBe(null);
		assertThat("trueLong").mustBeTrue();
	}


	@Test
	public void isTrue_Double() {
		assertThat("trueDouble").mustNotBe(0d);
		assertThat("trueDouble").mustNotBe(null);
		assertThat("trueDouble").mustBeTrue();
	}

	@Test
	public void isTrue_Float() {
		assertThat("trueFloat").mustNotBe(0f);
		assertThat("trueFloat").mustNotBe(null);
		assertThat("trueFloat").mustBeTrue();
	}

	@Test
	public void isTrue_BigDecimal() {
		assertThat("trueBigDecimal").mustNotBe(BigDecimal.ZERO);
		assertThat("trueBigDecimal").mustNotBe(null);
		assertThat("trueBigDecimal").mustBeTrue();
	}

}
