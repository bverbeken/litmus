package litmus.unit.validation;

public enum BuiltInValidation {

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
