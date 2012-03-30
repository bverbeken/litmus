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
		assertThat("trueBoolean").isInvalidWhenEqualTo(false);
		assertThat("trueBoolean").mustBeTrue();
	}

	@Test
	public void isTrue_String() {
		assertThat("trueString").isInvalidWhenEqualTo("");
		assertThat("trueString").isInvalidWhenEqualTo("false");
		assertThat("trueString").isInvalidWhenEqualTo("anything else");
		assertThat("trueString").isInvalidWhenEqualTo(null);
		assertThat("trueString").mustBeTrue();
	}

	@Test
	public void isTrue_Integer() {
		assertThat("trueInteger").isInvalidWhenEqualTo(0);
		assertThat("trueInteger").isInvalidWhenEqualTo(null);
		assertThat("trueInteger").mustBeTrue();
	}

	@Test
	public void isTrue_Long() {
		assertThat("trueLong").isInvalidWhenEqualTo(0L);
		assertThat("trueLong").isInvalidWhenEqualTo(null);
		assertThat("trueLong").mustBeTrue();
	}


	@Test
	public void isTrue_Double() {
		assertThat("trueDouble").isInvalidWhenEqualTo(0d);
		assertThat("trueDouble").isInvalidWhenEqualTo(null);
		assertThat("trueDouble").mustBeTrue();
	}

	@Test
	public void isTrue_Float() {
		assertThat("trueFloat").isInvalidWhenEqualTo(0f);
		assertThat("trueFloat").isInvalidWhenEqualTo(null);
		assertThat("trueFloat").mustBeTrue();
	}

	@Test
	public void isTrue_BigDecimal() {
		assertThat("trueBigDecimal").isInvalidWhenEqualTo(BigDecimal.ZERO);
		assertThat("trueBigDecimal").isInvalidWhenEqualTo(null);
		assertThat("trueBigDecimal").mustBeTrue();
	}

}
