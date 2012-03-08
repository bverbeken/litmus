package litmus.unit.validation;

public enum BuiltInValidation {

	/* TODO: add value for inverse of most of the built in validations so that a is() method is possible on FieldValidationAssert
	e.g. email -> invalid email, required -> null, past -> future date, is_true -> false, etc
	 */

	EMAIL,
	EQUALS,
	FUTURE,
	IS_TRUE("isTrue"),
	MATCH,
	MAX,
	MAX_SIZE("maxSize"),
	MIN,
	MIN_SIZE("minSize"),
	PAST,
	RANGE,
	REQUIRED,
	URL,
	PHONE,
	IP4ADDRESS("ipv4"),
	IP6ADDRESS("ipv6");

	private final String messageSuffix;

	BuiltInValidation() {
		this.messageSuffix = name().toLowerCase();
	}

	BuiltInValidation(String messageSuffix) {
		this.messageSuffix = messageSuffix;
	}


	public String getMessageKey() {
		return "validation." + messageSuffix;
	}
}
