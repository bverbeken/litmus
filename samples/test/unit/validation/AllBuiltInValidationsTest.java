package unit.validation;

import litmus.unit.validation.ValidationTest;
import models.ModelForValidation;
import models.Person;
import org.junit.Test;

import java.math.BigDecimal;

import static litmus.util.DateUtil.*;

public class AllBuiltInValidationsTest extends ValidationTest<ModelForValidation> {



	@Override
	protected ModelForValidation valid() {
		ModelForValidation model = new ModelForValidation();
		model.email = "ben@ostia.be";
		model.futureDate = dateInFuture();
		model.dateAfter1Jan2100 = asDate("2222-01-01");
		model.pastDate = dateInPast();
		model.dateBefore31Dec2012 = asDate("2000-01-01");
		model.ipV4Address = "10.11.12.13";
		// TODO: ipV6Address
		model.trueBoolean = true;
		model.trueString = "true";
		model.trueInteger = 154;
		model.trueLong = 123L;
		model.trueFloat = 12.3F;
		model.trueDouble = 15.3;
		model.trueBigDecimal = new BigDecimal(12);
		model.matchingString = "1290";
		model.maxInt = 8;
		model.minInt = 15;
		model.phone = "+32 222 33 44 55";
		model.between10And20 = 15;
		model.requiredString = "aString";
		model.url = "http://www.google.com";
		model.validObject = new Person("Joe", "Jackson");
		return model;
	}

	@Test
	public void emailShouldBeAnEmail() {
		assertThat("email").shouldNotBe("not a valid email");
		assertThat("email").shouldBeAValidEmailAddress();
	}

	@Test
	public void futureDate() {
		assertThat("futureDate").shouldNotBe(dateInPast());
		assertThat("futureDate").shouldBeInFuture();
	}

	@Test
	public void dateAfterAGivenDate() {
		assertThat("dateAfter1Jan2100").shouldBeAfter(asDate("2100-01-01"));
		assertThat("dateAfter1Jan2100").shouldBeAfter("2100-01-01");
	}

	@Test
	public void pastDate() {
		assertThat("pastDate").shouldNotBe(dateInFuture());
		assertThat("pastDate").shouldBeInPast();
	}

	@Test
	public void dateBeforeAGivenDate() {
		assertThat("dateBefore31Dec2012").shouldBeBefore(asDate("2012-12-31"));
		assertThat("dateBefore31Dec2012").shouldBeBefore("2012-12-31");
	}

	@Test
	public void ipv4Address() {
		assertThat("ipV4Address").shouldNotBe("invalid ip address");
		assertThat("ipV4Address").shouldBeAValidIPv4Address();
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
	public void isTrue_BigDecimal(){
		assertThat("trueBigDecimal").shouldNotBe(BigDecimal.ZERO);
		assertThat("trueBigDecimal").shouldNotBe(null);
		assertThat("trueBigDecimal").shouldBeTrue();
	}




}
