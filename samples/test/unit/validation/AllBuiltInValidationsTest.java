package unit.validation;

import litmus.unit.validation.ValidationTest;
import models.ModelForValidation;
import models.Person;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.System.currentTimeMillis;

public class AllBuiltInValidationsTest extends ValidationTest<ModelForValidation> {

	public static final Date FUTURE = new Date(currentTimeMillis() + 99999);
	public static final Date PAST = new Date(currentTimeMillis() - 99999);

	@Override
	protected ModelForValidation valid() {
		ModelForValidation model = new ModelForValidation();
		model.email = "ben@ostia.be";
		model.futureDate = FUTURE;
		model.dateAfter1Jan2100 = makeDate("2222-01-01");
		model.pastDate = PAST;
		model.ipV4Address = "10.11.12.13";
		model.trueBoolean = true;
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

	private Date makeDate(String date) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void emailShouldBeAnEmail() {
		assertThat("email").shouldNotBe("not a valid email");
		assertThat("email").shouldBeAValidEmailAddress();
	}

	@Test
	public void futureDate() {
		assertThat("futureDate").shouldNotBe(PAST);
		assertThat("futureDate").shouldBeInFuture();
	}

	@Test
	public void dateAfterAGivenDate() {
		assertThat("dateAfter1Jan2100").shouldBeAfter(makeDate("2100-01-01"));
		assertThat("dateAfter1Jan2100").shouldBeAfter("2100-01-01");
	}

	// TODO: add tests for @Past("10-12-2025")

	@Test
	public void pastDate() {
		assertThat("pastDate").shouldNotBe(FUTURE);
		assertThat("pastDate").shouldBeInPast();
	}

	@Test
	public void ipv4Address() {
		assertThat("ipV4Address").shouldNotBe("invalid ip address");
		assertThat("ipV4Address").shouldBeAValidIPv4Address();
	}

	@Test
	public void isTrue() {
		assertThat("trueBoolean").shouldNotBe(false);
		assertThat("trueBoolean").shouldBeTrue();
	}


	// TODO: add tests for isTrue with String (Boolean.parseBoolean)
	// TODO: add tests for isTrue with Number (true <> 0)


}
